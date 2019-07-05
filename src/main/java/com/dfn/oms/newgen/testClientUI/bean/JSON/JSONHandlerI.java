package com.dfn.oms.newgen.testClientUI.bean.JSON;

import com.dfn.oms.newgen.testClientUI.bean.OMS.OMSCoreRuntimeException;

import java.util.HashMap;
import java.util.Map;

public interface JSONHandlerI {
    public <T> T parserJSON(String jsonMsg, Class<T> clz) throws OMSCoreRuntimeException;

    public String getJSonString(Object pojo) throws OMSCoreRuntimeException;

    public HashMap<String, String> parseJsonAsMap(String jsonMsg) throws OMSCoreRuntimeException;

    public Object extractJSONPath(String jsonString, String jsonPath) throws OMSCoreRuntimeException;

    public int extractRequestID(String jsonReqString);

    public String convertObjectToJSON(Object o);

    public Map parseJsonToMap(String jsonString);

    public <T> T convertMapToObject(Map map, Class<T> clz);
}

