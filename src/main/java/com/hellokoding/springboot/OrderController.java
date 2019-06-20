package com.hellokoding.springboot;
import com.hellokoding.springboot.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.IOException;
import java.net.URI;
import java.util.*;

import static com.hellokoding.springboot.UserController1.hashMap_ordersPerTimeSlice;
import static com.hellokoding.springboot.UserController1.userRepository1;
import static com.hellokoding.springboot.bean.WebSocketClientEndPoint.responseCount;
import static com.hellokoding.springboot.bean.WebSocketRunner.requestList;
@Controller
public class OrderController {

    @Autowired

    public static List<String> responseList = new ArrayList<String>();
    public static List<Long> timeList = new ArrayList<>();
    public static String orderAction = "2";
    private static WebSocketRunnerSetting settings;
    private static List<WebSocketClientEndPoint> clientEndPoints;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/startOrder")
    public void startOrder() {
        responseCount = 0;
        responseList.clear();
        timeList.clear();
        if(requestList != null){
            requestList.clear();
        }
        WebSocketRunner webSocketRunner = new WebSocketRunner();
        String textLocation = (webSocketRunner.TEXT_PATH);
        long noOfRequests = userRepository1.count();
//        System.out.println(webSocketRunner.operatingMethod);
        boolean threadStatus = true;
        try {
//            WebSocketRunnerSetting settings = new WebSocketRunnerSetting();
//            settings.setIp(userRepository1.findById((long) noOfRequests).get().getIp());
//            settings.setPort(userRepository1.findById((long) noOfRequests).get().getPort());
//            settings.setGWClient(false);
//            settings.setNumOfEndPoints(userRepository1.findById((long) noOfRequests).get().getEndpoint());
//            System.out.println(settings.getIp());
//            List<WebSocketClientEndPoint> clientEndPoints = populateEndPoints(settings);
            int sentCount;
            String orderPerTimeSLice = "500:1";
            int a = 1;
            if (orderPerTimeSLice != null) {
                String orderPerSlice = orderPerTimeSLice.split(":")[0];
               // String timePeriod = orderPerTimeSLice.split(":")[1];
                String timePeriod = Integer.toString(hashMap_ordersPerTimeSlice.get(Integer.toString(hashMap_ordersPerTimeSlice.size()-1)).getTimePeriod());
//                int ordersPerSec = Integer.parseInt(orderPerSlice);
                int ordersPerSec  = hashMap_ordersPerTimeSlice.get(Integer.toString(hashMap_ordersPerTimeSlice.size()-1)).getOrderPerSlice();
                int i = 0;
                long timeSpread = 0;
                long startTime = System.currentTimeMillis();
                long start = System.currentTimeMillis();
                long timePeriodForOrders = Long.parseLong(timePeriod) * 1000;
                System.out.println("== Placing timed orders, Order per period:" + orderPerSlice + ", period(Seconds):" + timePeriod);
                int orderLoopCount = 0;
                while (threadStatus) {
                    if (webSocketRunner.operatingMethod) {
                        WebClientDB webClientDB_internalTemp = new WebClientDB(textLocation);
                        webSocketRunner.status = webClientDB_internalTemp.inputCommandLine();
                        requestList = webClientDB_internalTemp.getRequestList();
                    } else {
                        WebClientUtils webClientUtilsInternalTmp = new WebClientUtils();
                        webSocketRunner.status = webClientUtilsInternalTmp.processCommandLind();
                        requestList = WebClientUtils.getRequestList();
                    }
                    if (webSocketRunner.status) {
                        for (int j = 0; j < requestList.size(); j++) {
                            i++;
                            String s = requestList.get(j);
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
//                    a++;
                    threadStatus = false;
                    requestList.clear();
                    System.out.println("\n Request sent count:" + orderLoopCount + "\n\n\n");
                    //logger.info("LN:138", "==Orders placed:" + orderLoopCount);
                    if (orderLoopCount >= Integer.MAX_VALUE) {
                        threadStatus = false;
                    }
                }
            } else {
                while (threadStatus) {
                    sentCount = 0;
                    if (webSocketRunner.operatingMethod) {
                        WebClientDB webClientDB_internalTemp = new WebClientDB(textLocation);
                        webSocketRunner.status = webClientDB_internalTemp.inputCommandLine();
                        requestList = webClientDB_internalTemp.getRequestList();
                    } else {
                        WebClientUtils webClientUtilsInternalTmp = new WebClientUtils();
                        webSocketRunner.status = webClientUtilsInternalTmp.processCommandLind();
                        requestList = WebClientUtils.getRequestList();
                    }
                    responseCount = 0;
                    if (webSocketRunner.status) {
                        for (int i = 0; i < requestList.size(); i++) {
                            String s = requestList.get(i);
                            if (settings.getNumOfEndPoints() > 1) {
                                clientEndPoints.get(i % settings.getNumOfEndPoints()).sendMessage1(s);
                            } else {
                                clientEndPoints.get(0).sendMessage1(s);
                            }
                            sentCount++;
                        }
                        requestList.clear();
                    }
                    System.out.println("\n Request sent count:" + sentCount + "\n\n\n");
                    //  logger.info("LN:172", "==Orders placed:" + sentCount);
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
        ordersPerTimeSlice.setOrderPerSlice(500);
        ordersPerTimeSlice.setTimePeriod(1);
        ordersPerTimeSlice.setGWClient(false);
        hashMap_ordersPerTimeSlice.put("0",ordersPerTimeSlice);
        long noOfRequests = userRepository1.count();
        try{
            settings = new WebSocketRunnerSetting();
            settings.setIp(userRepository1.findById((long) noOfRequests).get().getIp());
            settings.setPort(userRepository1.findById((long) noOfRequests).get().getPort());
//            settings.setGWClient(hashMap_ordersPerTimeSlice.get(Integer.toString(hashMap_ordersPerTimeSlice.size()-1)).isGWClient());
            settings.setGWClient(false);
            settings.setNumOfEndPoints(userRepository1.findById((long) noOfRequests).get().getEndpoint());
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
            System.out.println("\n Connecting to :" + "ws://127.0.0.1:9080/streaming-api");
            for (int i = 0; i < settings.getNumOfEndPoints(); i++) {
                WebSocketClientEndPoint clientEndPoint = new WebSocketClientEndPoint(new URI("ws://192.168.16.106:9080/streaming-api"));
                clientEndPoints.add(clientEndPoint);
            }
        }
        return clientEndPoints;
    }
}


