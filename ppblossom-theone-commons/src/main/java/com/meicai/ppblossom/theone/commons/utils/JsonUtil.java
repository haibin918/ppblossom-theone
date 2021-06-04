package com.meicai.ppblossom.theone.commons.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JsonUtil
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/22 15:59
 * @Version 1.0
 **/
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectMapper objectMapper2 = new ObjectMapper();
    private static ObjectMapper objectMapper3 = new ObjectMapper();
    private static ObjectMapper objectMapper4 = new ObjectMapper();
    private static ObjectMapper objectMapper5 = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        objectMapper2.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper2.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        objectMapper3.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper3.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper3.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper3.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        objectMapper4.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper4.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper4.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper4.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper4.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper4.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public JsonUtil() {
    }

    public static <T> T stringToObject(String json, Class<T> clazz) throws IOException, JsonParseException, JsonMappingException {
        ObjectMapper objectMapper = new ObjectMapper();
        T result = objectMapper.readValue(json, clazz);
        return result;
    }

    public static Map<String, Object> getMap(String s) throws IOException, JsonParseException, JsonMappingException {
        Map map = (Map) stringToObject(s, Map.class);
        return map;
    }

    public static List<String> getList(String json) throws IOException, JsonParseException, JsonMappingException {
        List list = (List) stringToObject(json, List.class);
        return list;
    }

    public static String objectToString(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    public JsonNode getJson(String result) throws JsonProcessingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(result);
    }

    public static String writeValueAsString(Object obj) {
        return writeValueAsString(obj, true);
    }

    public static String writeValueAsDateString(Object obj) {
        try {
            return objectMapper4.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("failed translate object to json", e);
        }
    }

    public static String writeValueAsString(Object obj, boolean ignoreNullField) {
        try {
            if (ignoreNullField) {
                return objectMapper.writeValueAsString(obj);
            } else {
                return objectMapper2.writeValueAsString(obj);
            }
        } catch (Exception e) {
            throw new RuntimeException("failed translate object to json", e);
        }
    }

    public static <T> T readValue(String json, Class<T> type) {
        return readValue(json, type, true);
    }

    public static Object readValue(String json, JavaType javaType) {
        try {
            return objectMapper4.readValue(json, javaType);
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }

    public static <T> T readValue(String json, com.fasterxml.jackson.core.type.TypeReference<T> valueType) {
        try {
            return objectMapper4.readValue(json, valueType);
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }

    public static <T> T readValue(String json, Class<T> type, boolean isAllowNoField) {
        try {
            if (!isAllowNoField) {
                return objectMapper.readValue(json, type);
            } else {
                return objectMapper3.readValue(json, type);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("failed read object from json", e);
        }
    }

    public static <T> T readValueByDate(String json, Class<T> type) {
        try {
            return objectMapper4.readValue(json, type);
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> List<T> readValueByDate(String json, Class listClass, Class<T> type) {
        try {
            TypeFactory t = TypeFactory.defaultInstance();
            return objectMapper4.readValue(json, t.constructCollectionType(listClass, type));
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }

    public static <T> T readValue(JsonNode jsonNode, Class<T> type) {
        try {
            return objectMapper.readValue(writeValueAsString(jsonNode), type);
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }

    public static <T> List<T> readValue(String json, Class<?> listClass, Class<T> typeClass) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(listClass, typeClass);
        try {
            return objectMapper3.readValue(json, javaType);
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }

    public static JavaType constructParametricType(Class<?> parametrized, Class<?>... parameterClasses) {
        return objectMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }

    public static JavaType constructParametricType(Class<?> parametrized, JavaType... parameterClasses) {
        return objectMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }

    /**
     * 下划线转驼峰可以使用这个
     *
     * @param json      json
     * @param valueType valueType
     * @param <T>
     * @return return
     */
    public static <T> T readValueWithCamel(String json, com.fasterxml.jackson.core.type.TypeReference<T> valueType) {
        try {
            objectMapper5.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
            return objectMapper5.readValue(json, valueType);
        } catch (Exception e) {
            throw new RuntimeException("failed read object from json", e);
        }
    }

    public static <T> T parseJson(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * @param json
     * @param type 例 new TypeReference<Map<Integer, Map<BigDecimal,
     *             UmFullstep>>>() {}
     * @return
     */
    public static <T> T parseJson(String json, TypeReference<T> type) {
        return JSON.parseObject(json, type);
    }

    public static String toJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     *
     * @param str
     * @return
     */
    public static boolean isJSON(String str) {
        boolean result = false;
        try {
            Object obj=JSON.parse(str);
            result = true;
        } catch (Exception e) {
            result=false;
        }
        return result;
    }
}
