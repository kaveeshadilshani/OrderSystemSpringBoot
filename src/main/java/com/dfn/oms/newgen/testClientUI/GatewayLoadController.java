package com.dfn.oms.newgen.testClientUI;

import com.dfn.oms.newgen.testClientUI.Controller.UserController;
import com.dfn.oms.newgen.testClientUI.bean.CreateOrderComponent.WebSocketClientEndPoint;
import com.dfn.oms.newgen.testClientUI.bean.GatewayClient.*;
import com.dfn.oms.newgen.testClientUI.bean.GatewayUser;
import com.dfn.oms.newgen.testClientUI.bean.JMSComponent.LoginReqDataBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import static java.lang.Long.sum;

@RestController
public class GatewayLoadController {

    private int NUMBER_OF_MESSAGE_TYPES = 7;
    private boolean threadStatus = true;    // TODO properly implement this with applying threads
    private RequestBean[] reqBeanList = new RequestBean[NUMBER_OF_MESSAGE_TYPES] ;
    private WebSocketClientEndPoint webSocketClientEndPoint = new WebSocketClientEndPoint();
    private WebSocketClientEndPoint.MessageHandler messageHandler = new  WebSocketClientEndPoint.MessageHandler();
    public Map<String, RequestBean<LoginReqDataBean>> reqBeanMap = new HashMap<>() ;
    public static Map<String, ResponseBean<LoginResDataBean>> responseBeanMap = new HashMap<>();

    public static List<RequestBean<LoginReqDataBean>> loginReqBeanList = new ArrayList<>();

    @PostMapping("/gatewayload")
    @ResponseStatus(value = HttpStatus.OK)
    public void gatwayLoadHandle(@RequestBody Map<Integer,Boolean> msgType){

        Date date = new Date();
        long stopTime = Integer.MAX_VALUE;
        threadStatus = true;

        if(!UserController.gatewayUser.isSendFileContent()){

            if(UserController.gatewayUser.isTimeBounded()){
                long currentTime = date.getTime();
                if(UserController.gatewayUser.getTimeConstraintMin()<0){
                    stopTime = 0;
                }else{
                    stopTime = sum(currentTime ,UserController.gatewayUser.getTimeConstraintMin()*60000) ;
                }
//            System.out.println(new Date(stopTime));
            }

        }else{
            UserController.gatewayUser.setTimeBounded(false);
        }


        if(msgType.get(1)){
            System.out.println("==Login Message==");

            try {
                webSocketClientEndPoint = new WebSocketClientEndPoint(new URI("ws://192.168.0.50:9080/streaming-api"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            for(int i=0;i<UserController.gatewayUser.getRepeatCount();i++){
                if(!UserController.gatewayUser.isSendFileContent() || !threadStatus){        //make it repeatable or run it once
                    i = Integer.MAX_VALUE-1;
                }

                if(UserController.gatewayUser.isTimeBounded() && !UserController.gatewayUser.isSendFileContent()){  //time bound
                    for(int j=0;j<loginReqBeanList.size();j++){
                        if(UserController.gatewayUser.isRated() && (j+1)%UserController.gatewayUser.getRequestsPerSec()==0){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        sendRequest(loginReqBeanList.get(j),webSocketClientEndPoint);
                        Date now = new Date();
                        if((now.getTime()>stopTime && stopTime!=0) || !threadStatus){  //TODO remove these and properly implement with threads
                            j = Integer.MAX_VALUE-1;
                        }else if(loginReqBeanList.size()-1 == j){
                            j = 0;
                        }
                    }
                }else if(!UserController.gatewayUser.isTimeBounded() && !UserController.gatewayUser.isSendFileContent()){   //count bound
                    int initialMsgCount = UserController.gatewayUser.getMsgCount();
                    for(int j=0;j<UserController.gatewayUser.getMsgCount();j++){
                        if(UserController.gatewayUser.isRated() && (j+1)%UserController.gatewayUser.getRequestsPerSec()==0){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if(loginReqBeanList.size() == j){
                            j=0;
                            int msgCountTmp = UserController.gatewayUser.getMsgCount();
                            UserController.gatewayUser.setMsgCount(msgCountTmp-loginReqBeanList.size());
                        }
                        if(!threadStatus){
                            j = Integer.MAX_VALUE-1; //TODO remove these and properly implement with threads
                        }
                        sendRequest(loginReqBeanList.get(j),webSocketClientEndPoint);
                    }
                    UserController.gatewayUser.setMsgCount(initialMsgCount);
                }else{
                    for(int l=0;l<loginReqBeanList.size();l++){
                        sendRequest(loginReqBeanList.get(l),webSocketClientEndPoint);
                        if(UserController.gatewayUser.isRated() && (l+1)%UserController.gatewayUser.getRequestsPerSec()==0){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if(!threadStatus){
                            l = Integer.MAX_VALUE-1;    //TODO remove these and properly implement with threads
                        }
                    }
                }
            }



        }
        if(msgType.get(2)){
            System.out.println("==Buying Power Message==");
        }
        if(msgType.get(3)){
            System.out.println("==Account Summary Message==");
        }
        if(msgType.get(4)){
            System.out.println("==Order List Message==");
        }
        if(msgType.get(5)){
            System.out.println("==Order Search Message==");
        }
        if(msgType.get(6)){
            System.out.println("==Customer Search Message==");
        }
        if(msgType.get(7)){
            System.out.println("==Portfolio Details Message==");
        }

//        if(OrderController.settings !=null && UserController.userRepository != null){
//            long noOfRequests = UserController.userRepository.count();
//            for(int j=1; j<reqBeanList.length; j++) {
//                if(reqBeanList[j]!=null) {
//                    for (int i = 0; i < UserController.userRepository.findById(noOfRequests).get().getNoOfOrders(); i++) {
//                        if (OrderController.settings.getNumOfEndPoints() > 1) {
//                            OrderController.clientEndPoints.get(i % OrderController.settings.getNumOfEndPoints()).sendMessage(reqBeanList[j]);
//                        } else {
//                            OrderController.clientEndPoints.get(0).sendMessage(reqBeanList[j]);
//                        }
//                    }
//                }
//            }
//        }

    }

    @GetMapping("/stopsending")
    public void killReqSending(){
        threadStatus = false;
    }

    public void sendRequest(RequestBean reqBean,WebSocketClientEndPoint webSocketClientEndPoint){
        webSocketClientEndPoint.sendMessage(reqBean);
    }

    public static void queueUpMsgs(GatewayUser gwUser){
        //Login requests queuing up
        List<LoginReqDataBean> loginReqDataBeanList  =  getLoginReqDataBeans("src/main/resources/Logins.csv");
        loginReqBeanList.clear();
        for(int i=0;i<loginReqDataBeanList.size();i++){
            loginReqBeanList.add(buildRequest(1,loginReqDataBeanList.get(i)));
        }
    }

    public static RequestBean buildRequest(int msgType, ReqData reqDataBean){
        CommonHeader commonHeader = buildCommonHeader(msgType);
        RequestBean requestBean = new RequestBean();
        requestBean.setCommonHeader(commonHeader);
        requestBean.setDataBean(reqDataBean);
//        webSocketClientEndPoint.sendMessage(requestBean);
        return requestBean;
    }

    public static CommonHeader buildCommonHeader(int msgType){
        CommonHeader commonHeader = new CommonHeader();
        commonHeader.setMsgTyp(msgType);
        commonHeader.setTenantCode("DEFAULT_TENANT");
        commonHeader.setCommVer("DFNUAWEB_AIOLOS_M_1.000.02.882+82b0a229");
        commonHeader.setSesnId("");
        commonHeader.setLoginId(0);
        commonHeader.setChannel(1);
        commonHeader.setClientIp("192.168.16.106");
//        commonHeader.setUnqReqId("0_1538998178633");
        commonHeader.setRouteId(0);
        String requestIdLogin = "CommonClientlogin" + System.nanoTime() + "1";

        commonHeader.setUnqReqId(requestIdLogin);
        return commonHeader;
    }

    public static void forwardResponseMessage(String unqReqId, ResponseBean responseBean){

        GatewayLoadController.responseBeanMap.put(unqReqId,responseBean);
        System.out.println("UnqReqID => "+unqReqId+"\n"+responseBean.getCommonHeader().getSesnId());
    }

    public static List<LoginReqDataBean> getLoginReqDataBeans(String path){
        List<LoginReqDataBean> reqDataBeansList = new ArrayList<>();
        LoginReqDataBean dataBean ;
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] dataBeanString = line.split(",");
              if(!dataBeanString[2].equals("") && !dataBeanString[3].equals("")){
                  dataBean = new LoginReqDataBean();
                  dataBean.setLgnNme(dataBeanString[2].split("\"")[1]);
                  dataBean.setPwd(dataBeanString[3].split("\"")[1]);
                  reqDataBeansList.add(dataBean);
              }
            }
            UserController.readyState = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            UserController.readyState = false;
        } catch (IOException e) {
            e.printStackTrace();
            UserController.readyState = false;
        }

        return reqDataBeansList;
    }

}
