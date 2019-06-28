package com.dfn.oms.newgen.testClientUI;

import com.dfn.oms.newgen.testClientUI.bean.CommonHeader;
import com.dfn.oms.newgen.testClientUI.bean.LoginReqDataBean;
import com.dfn.oms.newgen.testClientUI.bean.RequestBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GatewayLoadController {


    boolean threadStatus = true;
    RequestBean reqBean = new RequestBean();
//    long noOfRequests = UserController1.userRepository1.count();

    @PostMapping("/gatewayload")
    @ResponseStatus(value = HttpStatus.OK)
    public void gatwayLoadHandle(@RequestBody Map<Integer,Boolean> msgType){


        if(msgType.get(1)){
            CommonHeader commonHeader ;
            commonHeader = buildCommonHeader(1);
            LoginReqDataBean dataBean = new LoginReqDataBean();
            dataBean.setLgnNme("das_1");
            dataBean.setPwd("123");
            reqBean.setCommonHeader(commonHeader);
            reqBean.setDataBean(dataBean);
        }else if(msgType.get(2)){

        }

        if(OrderController.settings !=null && UserController1.userRepository1 != null){
            long noOfRequests = UserController1.userRepository1.count();
            for(int i=0;i<UserController1.userRepository1.findById(noOfRequests).get().getNoOfOrders();i++){
                if (OrderController.settings.getNumOfEndPoints() > 1) {
                    OrderController.clientEndPoints.get(i % OrderController.settings.getNumOfEndPoints()).sendMessage(reqBean);
                } else {
                    OrderController.clientEndPoints.get(0).sendMessage(reqBean);
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
