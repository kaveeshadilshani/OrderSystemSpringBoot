package com.dfn.oms.newgen.testClientUI.bean;




import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by samurdiw on 7/27/2016.
 */
public class JSONHandler implements JSONHandlerI {
  //  private static final OMSLogHandlerI logger = new Log4j2HndlAdaptor("JSONHandler");
    private ObjectMapper mapper = new ObjectMapper();
    private ObjectMapper mapperNoneAnnotated = new ObjectMapper();
    private TypeReference<HashMap<String, Object>> typeRef
            = new TypeReference<HashMap<String, Object>>() {
    };

    /**
     * @param jsonString
     * @param jsonPath
     * @return return the value element of the given JSCN path
     * @throws Exception
     */
    @Override
    public Object extractJSONPath(String jsonString, String jsonPath) {
        return JsonPath.read(jsonString, jsonPath);
    }

    @Override
    public HashMap<String, String> parseJsonAsMap(String jsonMsg) {

        HashMap<String, String> map;
        try {
            map = mapper.readValue(jsonMsg, new TypeReference<HashMap<String, String>>() {
            });
        } catch (IOException e) {
            throw new OMSCoreRuntimeException(e.getMessage(), e);
        }
        return map;
    }

    @Override
    public String getJSonString(Object pojo) {
        try {
            return mapper.writeValueAsString(pojo);

        } catch (JsonProcessingException e) {
            throw new OMSCoreRuntimeException(e.getMessage(), e);
        }
    }

    public String getJsonStringNoneAnnotated(Object pojo) throws Exception {
        mapperNoneAnnotated.configure(MapperFeature.USE_ANNOTATIONS, false);
        return mapperNoneAnnotated.writeValueAsString(pojo);
    }

    @Override
    public <T> T parserJSON(String jsonMsg, Class<T> clz) {
        try {
            return mapper.readValue(jsonMsg, clz);
        } catch (Exception e) {
            //logger.error("LN:72", "JSON Request Passing Error:" + e.getMessage(), e);
            throw new OMSCoreRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public <T> T convertMapToObject(Map map, Class<T> clz) {
        try {
            return mapper.convertValue(map, clz);
        } catch (Exception e) {
           // logger.error("LN:82", "JSON Passing Error:" + e.getMessage(), e);
            throw new OMSCoreRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public int extractRequestID(String jsonReqString) {
        //return extractRequestIDWithJsonPath(jsonReqString);//todo implement with index of
        try {
            String messageType = jsonReqString.split(OMSConst.OMS_MESSAGE_PROTOCOL_PREFIX)[1].split("}")[0];
            messageType = messageType.split(",")[0].trim();
            return Integer.parseInt(messageType);
        } catch (Exception e) {
          //  logger.error("LN:95", "Parsing failed with string manipulation:" + e.getMessage(), e);
        }
        return extractRequestIDWithJsonPath(jsonReqString);
    }

    public int extractRequestIDWithJsonPath(String jsonReqString) {
        try {
            return (Integer) (extractJSONPath(jsonReqString, OMSConst.OMS_MESSAGE_PROTOCOL_PREFIX_JPATH));
        } catch (Exception e) {
            throw new OMSCoreRuntimeException("Fail to extract request id:", e);
        }
    }

    @Override
    public String convertObjectToJSON(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new OMSCoreRuntimeException("Jackson parser error:", e);
        }
    }

    @Override
    public Map parseJsonToMap(String jsonString) {
        HashMap<String, Object> keyValueMap;
        try {
            keyValueMap = mapper.readValue(jsonString, typeRef);
        } catch (IOException e) {
            throw new OMSCoreRuntimeException("Jackson parser error:", e);
        }
        return keyValueMap;
    }


}
