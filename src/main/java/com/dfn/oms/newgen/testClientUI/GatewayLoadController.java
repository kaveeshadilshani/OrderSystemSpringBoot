package com.dfn.oms.newgen.testClientUI;

import com.dfn.oms.newgen.testClientUI.bean.CommonHeader;
import com.dfn.oms.newgen.testClientUI.bean.LoginReqDataBean;
import com.dfn.oms.newgen.testClientUI.bean.RequestBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GatewayLoadController {

    int NUMBER_OF_MESSAGE_TYPES = 7;
    boolean threadStatus = true;
    RequestBean [] reqBeanList = new RequestBean[NUMBER_OF_MESSAGE_TYPES] ;
//    long noOfRequests = UserController1.userRepository1.count();

    @PostMapping("/gatewayload")
    @ResponseStatus(value = HttpStatus.OK)
    public void gatwayLoadHandle(@RequestBody Map<Integer,Boolean> msgType){


        if(msgType.get(1)){
            System.out.println("==Login Message==");
            CommonHeader commonHeader ;
            commonHeader = buildCommonHeader(1);
            reqBeanList[0] = new RequestBean();
            LoginReqDataBean dataBean = new LoginReqDataBean();
            dataBean.setLgnNme("das_1");
            dataBean.setPwd("123");
            reqBeanList[0].setCommonHeader(commonHeader);
            reqBeanList[0].setDataBean(dataBean);
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
            for(int j=0; j<reqBeanList.length; j++) {
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
        commonHeader.setUnqReqId("0_1538998178633");
        commonHeader.setRouteId(0);
        return commonHeader;
    }

}
