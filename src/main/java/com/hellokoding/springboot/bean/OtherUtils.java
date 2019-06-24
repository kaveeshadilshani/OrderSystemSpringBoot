package com.hellokoding.springboot.bean;

import java.util.Map;
public class OtherUtils {
    private static OtherUtils otherUtils;

    public static OtherUtils getOtherUtils() {
        if (otherUtils == null) {
            otherUtils = new OtherUtils();
        }
        return otherUtils;
    }

//    public void create_sessions(Map<Integer, RequestBean<LoginReqDataBean>> loginMap) {
//        subscriptionNum++;
//        for (int key : loginMap.keySet()) {
//            webSocketDirecter.sendMessage(loginMap.get(key));
//            ResponseBean<LoginResDataBean> responseBean = responseHandler.getResponseDetails(webSocketDirecter, loginMap.get(key).getCommonHeader().getUnqReqId(), CCConst.LOGIN);
//            if (responseBean != null && responseBean.getCommonData().getAuthSts()==1) {
//                //logger.info("Login successful for Channel:" + key);
//                loginIdMap.put(key, responseBean.getCommonHeader().getLoginId());
//            } else {
//                //logger.error("Login Unsuccessful :" + key);
//                throw new RuntimeException("Login Failed");
//            }
//        }
//    }


}
