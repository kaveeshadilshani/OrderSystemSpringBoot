package com.dfn.oms.newgen.testClientUI;

import com.dfn.oms.newgen.testClientUI.bean.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    private boolean threadStatus = true;
    private RequestBean [] reqBeanList = new RequestBean[NUMBER_OF_MESSAGE_TYPES] ;
    private WebSocketClientEndPoint webSocketClientEndPoint = new WebSocketClientEndPoint();
    private WebSocketClientEndPoint.MessageHandler messageHandler = new  WebSocketClientEndPoint.MessageHandler();
    public Map<String, RequestBean<LoginReqDataBean>> reqBeanMap = new HashMap<>() ;
    public static Map<String, ResponseBean<LoginResDataBean>> responseBeanMap = new HashMap<>();

    @PostMapping("/gatewayload")
    @ResponseStatus(value = HttpStatus.OK)
    public void gatwayLoadHandle(@RequestBody Map<Integer,Boolean> msgType){


        if(!UserController1.gatewayUser.isPeriodically()){
            Date date = new Date();
            long currentTime = date.getTime();
            long stopTime = sum(sum(currentTime ,UserController1.gatewayUser.getTimeConstraintHour()*3600000),
                    UserController1.gatewayUser.getTimeConstraintMin()*60000) ;
            System.out.println(new Date(stopTime));
        }

        if(msgType.get(1)){
            System.out.println("==Login Message==");

            reqBeanList[0] = new RequestBean();
            List<LoginReqDataBean> reqDataBeanList = getReqDataBeans("src/main/resources/Logins.csv");

            try {
                webSocketClientEndPoint = new WebSocketClientEndPoint(new URI("ws://192.168.0.50:9080/streaming-api"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            if(!UserController1.gatewayUser.isPeriodically()){
                for(int j=0;j<UserController1.gatewayUser.getRepeatCount();j++){
                    for(int i=0;i<reqDataBeanList.size();i++){
                        CommonHeader commonHeader = buildCommonHeader(1);
                        RequestBean requestBean = new RequestBean();
                        requestBean.setCommonHeader(commonHeader);
                        requestBean.setDataBean(reqDataBeanList.get(i));
                        webSocketClientEndPoint.sendMessage(requestBean);
                    }
                }
            }




//            reqBeanMap =  fetchLoginDetails("src/main/java/com/dfn/oms/newgen/testClientUI/bean/Login.yaml");
//
//            try {
//                webSocketClientEndPoint = new WebSocketClientEndPoint(new URI("ws://192.168.0.50:9080/streaming-api"));
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//            }
//            for (Map.Entry<String, RequestBean<LoginReqDataBean>> entry : reqBeanMap.entrySet()){
//                webSocketClientEndPoint.sendMessage(entry.getValue());
//            }

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

        if(OrderController.settings !=null && UserController1.userRepository1 != null){
            long noOfRequests = UserController1.userRepository1.count();
            for(int j=1; j<reqBeanList.length; j++) {
                if(reqBeanList[j]!=null) {
                    for (int i = 0; i < UserController1.userRepository1.findById(noOfRequests).get().getNoOfOrders(); i++) {
                        if (OrderController.settings.getNumOfEndPoints() > 1) {
                            OrderController.clientEndPoints.get(i % OrderController.settings.getNumOfEndPoints()).sendMessage(reqBeanList[j]);
                        } else {
                            OrderController.clientEndPoints.get(0).sendMessage(reqBeanList[j]);
                        }
                    }
                }
            }
        }

    }



    public CommonHeader buildCommonHeader(int msgType){
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

    public List<LoginReqDataBean> getReqDataBeans(String path){
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reqDataBeansList;
    }

//    public Map<String, RequestBean<LoginReqDataBean>> fetchLoginDetails(String path){
//
//        InputStream inputStream;
//        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
//        List<RequestBean<LoginReqDataBean>> requestBeanlist = null;
//        try {
//            inputStream = new FileInputStream(path);
//            requestBeanlist = yamlMapper.readValue(inputStream, new TypeReference<List<RequestBean<LoginReqDataBean>>>() {
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Map<String, RequestBean<LoginReqDataBean>> loginBeanMap = new HashMap<>();
//        for (RequestBean<LoginReqDataBean> reqBean : requestBeanlist) {
//            loginBeanMap.put(reqBean.getCommonHeader().getUnqReqId(), reqBean);
//        }
//        return loginBeanMap;
//    }

}
