package com.dfn.oms.newgen.testClientUI.Controller;
import com.dfn.oms.newgen.testClientUI.bean.GatewayClient.CommonHeader;
import com.dfn.oms.newgen.testClientUI.bean.GatewayClient.LoginResDataBean;
import com.dfn.oms.newgen.testClientUI.bean.GatewayClient.RequestBean;
import com.dfn.oms.newgen.testClientUI.bean.GatewayClient.ResponseBean;
import com.dfn.oms.newgen.testClientUI.bean.JMSComponent.LoginReqDataBean;
import com.dfn.oms.newgen.testClientUI.bean.CreateOrderComponent.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;
@Controller
public class OrderController {

    @Autowired

    public static List<String> responseList = new ArrayList<String>();
    public static List<Long> timeList = new ArrayList<>();
    public static String orderAction = "2";
    private static WebSocketRunnerSetting settings;
    private static List<WebSocketClientEndPoint> clientEndPoints;
    private WebSocketClientEndPoint webSocketClientEndPoint;
    private  WebSocketClientEndPoint.MessageHandler messageHandler;
    public static String sessionID;
    private static boolean stopFlag = false;
    private static boolean timedOrdersFlag = false;


    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/startOrder")
    public void startOrder() {
        stopFlag = false;
        WebSocketClientEndPoint.responseCount = 0;
        responseList.clear();
        timeList.clear();
        if(WebSocketRunner.requestList != null){
            WebSocketRunner.requestList.clear();
        }
        WebSocketRunner webSocketRunner = new WebSocketRunner();
        String textLocation = (webSocketRunner.TEXT_PATH);
        long noOfRequests = UserController.userRepository.count();
//        System.out.println(webSocketRunner.operatingMethod);
        boolean threadStatus = true;
        try {

            int sentCount;
            String orderPerTimeSLice = "500:1";
            long start = System.currentTimeMillis();
            if (timedOrdersFlag) {
                // while(!stopFlag) {
                String orderPerSlice = orderPerTimeSLice.split(":")[0];
                String timePeriod = Integer.toString(UserController.hashMap_ordersPerTimeSlice.get(Integer.toString(UserController.hashMap_ordersPerTimeSlice.size() - 1)).getTimePeriod());
                int ordersPerSec = UserController.hashMap_ordersPerTimeSlice.get(Integer.toString(UserController.hashMap_ordersPerTimeSlice.size() - 1)).getOrderPerSlice();
                int i = 0;
                long timeSpread = 0;
                long startTime = System.currentTimeMillis();

                long timePeriodForOrders = Long.parseLong(timePeriod) * 1000;
                System.out.println("== Placing timed orders, Order per period:" + orderPerSlice + ", period(Seconds):" + timePeriod);
                int orderLoopCount = 0;
                while (threadStatus && !stopFlag) {
                    if (webSocketRunner.operatingMethod) {
                        WebClientDB webClientDB_internalTemp = new WebClientDB(textLocation);
                        webSocketRunner.status = webClientDB_internalTemp.inputCommandLine();
                        WebSocketRunner.requestList = webClientDB_internalTemp.getRequestList();
                    } else {
                        WebClientUtils webClientUtilsInternalTmp = new WebClientUtils();
                        webSocketRunner.status = webClientUtilsInternalTmp.processCommandLind();
                        WebSocketRunner.requestList = WebClientUtils.getRequestList();
                    }
                    if (webSocketRunner.status) {
                        for (int j = 0; j < WebSocketRunner.requestList.size(); j++) {
                            i++;
                            String s = WebSocketRunner.requestList.get(j);
                            orderLoopCount++;
                            if (settings.getNumOfEndPoints() > 1) {
                                clientEndPoints.get(j % settings.getNumOfEndPoints()).sendMessage1(s);
                            } else {
                                clientEndPoints.get(0).sendMessage1(s);
                            }
                            long end = System.currentTimeMillis();
                            long duration = end - start;
                            timeList.add(duration);
                            if (i >= ordersPerSec) {
                                System.out.println("more than orders per sec");
                                timeSpread = System.currentTimeMillis() - startTime;
                                if (timeSpread < timePeriodForOrders) {
                                    System.out.println("sleep");
                                    Thread.sleep(timePeriodForOrders - timeSpread); //sleep time time period per orders is reached
                                }
                                i = 0; // reInit order count
                                startTime = System.currentTimeMillis(); //re init time spread calc
                            }
                        }
                        System.out.println("All sent");

                    }

                    WebSocketRunner.requestList.clear();
                    System.out.println("\n Request sent count:" + orderLoopCount + "\n\n\n");

                    if (orderLoopCount >= Integer.MAX_VALUE) {
                        threadStatus = false;
                    }

                }
            } else {
                while (threadStatus && !stopFlag) {
                    sentCount = 0;
                    if (webSocketRunner.operatingMethod) {
                        WebClientDB webClientDB_internalTemp = new WebClientDB(textLocation);
                        webSocketRunner.status = webClientDB_internalTemp.inputCommandLine();
                        WebSocketRunner.requestList = webClientDB_internalTemp.getRequestList();
                    } else {
                        WebClientUtils webClientUtilsInternalTmp = new WebClientUtils();
                        webSocketRunner.status = webClientUtilsInternalTmp.processCommandLind();
                        WebSocketRunner.requestList = WebClientUtils.getRequestList();
                    }
                    WebSocketClientEndPoint.responseCount = 0;
                    if (webSocketRunner.status) {
                        for (int i = 0; i < WebSocketRunner.requestList.size(); i++) {
                            String s = WebSocketRunner.requestList.get(i);
                            if (settings.getNumOfEndPoints() > 1) {
                                clientEndPoints.get(i % settings.getNumOfEndPoints()).sendMessage1(s);
                            } else {
                                clientEndPoints.get(0).sendMessage1(s);
                            }
                            sentCount++;
                            long end = System.currentTimeMillis();
                            long duration = end - start;
                            timeList.add(duration);
                        }
                        WebSocketRunner.requestList.clear();
                    }
                    System.out.println("\n Request sent count:" + sentCount + "\n\n\n");

                    threadStatus = false;
                    if (sentCount >= Integer.MAX_VALUE) {
                        threadStatus = false;
                    }
                }
            }
            orderAction = "2";
        } catch (Exception ex) {
            System.err.println("client exception in start order...: " + ex);
        }
    }

    public static WebSocketRunnerSetting processArgs(String args[]) {
        WebSocketRunnerSetting settings = new WebSocketRunnerSetting();
        if (args != null && args.length > 0) {
            settings.setIp(args[0]);
            if (args.length > 1) {
                settings.setPort(Integer.parseInt(args[1]));
            }
            try {
                settings.setGWClient(Boolean.parseBoolean(args[2]));
            } catch (Exception e) {
                settings.setGWClient(false);
            }
            try {
                settings.setNumOfEndPoints(Integer.parseInt(args[3]));
            } catch (Exception e) {
                settings.setNumOfEndPoints(1);
            }
        }
        return settings;
    }
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/connect")
    public void connectToEndpoints(){
        WebSocketRunner webSocketRunner = new WebSocketRunner();
        String textLocation = (webSocketRunner.TEXT_PATH);
        OrdersPerTimeSlice ordersPerTimeSlice = new OrdersPerTimeSlice();
        ordersPerTimeSlice.setOrderPerSlice(700);
        ordersPerTimeSlice.setTimePeriod(1);
        ordersPerTimeSlice.setGWClient(false);
        UserController.hashMap_ordersPerTimeSlice.put("0",ordersPerTimeSlice);
        long noOfRequests = UserController.userRepository.count();
        try{
            settings = new WebSocketRunnerSetting();
            settings.setIp(UserController.userRepository.findById((long) noOfRequests).get().getIp());
            settings.setPort(UserController.userRepository.findById((long) noOfRequests).get().getPort());
//            settings.setGWClient(hashMap_ordersPerTimeSlice.get(Integer.toString(hashMap_ordersPerTimeSlice.size()-1)).isGWClient());
            settings.setGWClient(false);
            settings.setNumOfEndPoints(UserController.userRepository.findById((long) noOfRequests).get().getEndpoint());
            System.out.println(settings.getIp());
            if(clientEndPoints!= null){
                clientEndPoints.clear();
            }
            clientEndPoints = populateEndPoints(settings);
        }
        catch (Exception ex){
            System.err.println("client exception...: " + ex);
        }

    }

    public List<WebSocketClientEndPoint> populateEndPoints(WebSocketRunnerSetting settings) throws Exception {

        System.out.println("\nNumber of end points:" + settings.getNumOfEndPoints());
        List<WebSocketClientEndPoint> clientEndPoints = new ArrayList<WebSocketClientEndPoint>();
        if (!settings.isGWClient()) {//web socket
            System.out.println("\n Connecting to :" + settings.getIp() + ":" + settings.getPort());
            for (int i = 0; i < settings.getNumOfEndPoints(); i++) {
                WebSocketClientEndPoint clientEndPoint = new WebSocketClientEndPoint(new URI("ws://"
                        + settings.getIp() + ":" + settings.getPort() + "/OMSRestConnect/WebSocketServices"));
                clientEndPoints.add(clientEndPoint);
            }
        } else {//rest
            System.out.println("\n Connecting to :" + "ws://192.168.0.50:9080/streaming-api");
            for (int i = 0; i < 1; i++) {
                //WebSocketClientEndPoint clientEndPoint = new WebSocketClientEndPoint(new URI("ws://192.168.0.50:9080/streaming-api"));
                // clientEndPoints.add(clientEndPoint);
                webSocketClientEndPoint = new WebSocketClientEndPoint(new URI("ws://192.168.0.50:9080/streaming-api"));
                clientEndPoints.add(webSocketClientEndPoint);
                //  setup();
            }
        }
        return clientEndPoints;
    }
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/setup")
    public void setup(){
        OtherUtils otherUtils = OtherUtils.getOtherUtils();
//        webSocketClientEndPoint = WebSocketClientEndPoint.getInstance();
        messageHandler =  new WebSocketClientEndPoint.MessageHandler();
        Map<Integer, RequestBean<LoginReqDataBean>> login ;
        CommonHeader commonHeader = new CommonHeader();
        commonHeader.setMsgTyp(1);
        commonHeader.setTenantCode("DEFAULT_TENANT");
        commonHeader.setCommVer("DFNUAWEB_AIOLOS_M_1.000.02.882+82b0a229");
        commonHeader.setSesnId("");
        commonHeader.setLoginId(0);
        commonHeader.setChannel(1);
        commonHeader.setClientIp("192.168.16.106");
        commonHeader.setUnqReqId("0_1538998178633");
        commonHeader.setRouteId(0);
        LoginReqDataBean dataBean = new LoginReqDataBean();
        dataBean.setLgnNme("das_1");
        dataBean.setPwd("123");
        //dataBean.setLgnNme("IGNL2_UApp_User1");
        // dataBean.setPwd("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3");
        RequestBean reqBean = new RequestBean();
        reqBean.setCommonHeader(commonHeader);
        reqBean.setDataBean(dataBean);
        Map<Integer, RequestBean<LoginReqDataBean>> loginBeanMap = new HashMap<>();
        loginBeanMap.put(reqBean.getCommonHeader().getChannel(), reqBean);
        String requestIdLogin = "CommonClientlogin" + System.currentTimeMillis() + "1";
        loginBeanMap.get(1).getCommonHeader().setUnqReqId(requestIdLogin);
        //otherUtils.create_sessions(loginBeanMap);
        webSocketClientEndPoint.sendMessage(loginBeanMap.get(1));
        ResponseBean<LoginResDataBean> responseBean = messageHandler.getResponseDetails(webSocketClientEndPoint, loginBeanMap.get(1).getCommonHeader().getUnqReqId(),1);
        System.out.println("sessionID :" +responseBean.getCommonHeader().getSesnId());
        sessionID = responseBean.getCommonHeader().getSesnId();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/stop")
    public void stop(){
        stopFlag = true;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/sendTimedOrders")
    public void setTimedOrdersFlag(){
        timedOrdersFlag = true;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/sendConventionalOrders")
    public void sendConventionalOrders(){
        timedOrdersFlag = false;
    }

}


