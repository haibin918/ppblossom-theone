package com.meicai.ppblossom.theone.commons.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JsonUtilNew
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/12 12:12
 * @Version 1.0
 **/
public class JsonUtilNew {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectMapper objectMapper2 = new ObjectMapper();
    private static ObjectMapper objectMapper3 = new ObjectMapper();
    private static ObjectMapper objectMapper4 = new ObjectMapper();
    private static ObjectMapper objectMapper5 = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(JsonUtilNew.class);

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

        objectMapper5.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper5.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper5.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper5.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper5.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper5.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //下划线转驼峰
        objectMapper5.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
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

    public static <T> T readValue(String json, TypeReference<T> valueType) {
        try {
            return objectMapper4.readValue(json, valueType);
        } catch (Exception e) {
            logger.error("failed read object from json,json{},error:", json, e);
            throw new RuntimeException("failed read object from json", e);
        }
    }


    /**
     * 下划线转驼峰可以使用这个
     *
     * @param json      json
     * @param valueType valueType
     * @param <T>
     * @return return
     */
    public static <T> T readValueWithCamel(String json, TypeReference<T> valueType) {
        try {
            return objectMapper5.readValue(json, valueType);
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
     * 将对象的大写转换为下划线加小写，例如：userName-->user_name
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    public static String toUnderlineJSONString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String reqJson = null;
        try {
            reqJson = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("failed toUnderlineJSONString string", e);
        }
        return reqJson;
    }
    /**
     * 将下划线转换为驼峰的形式，例如：user_name-->userName
     *
     * @param json
     * @param clazz
     * @return
     * @throws IOException
     */
    public static <T> T toSnakeObject(String json, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        T reqJson = null;
        try {
            reqJson = mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("failed toSnakeObject object", e);
        }
        return reqJson;
    }

    /**
     * 将Object对象里面的属性和值转化成Map对象
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj){
        Map<String, Object> map = new HashMap<String,Object>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = null;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("failed get objectToMap", e);
            }
            map.put(fieldName, value);
        }
        return map;
    }

    /**
     * map转对象
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) {
        if (map == null){
            return null;
        }
        Object obj = null;
        try {
            obj = beanClass.newInstance();

            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                    continue;
                }

                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }

        }catch (Exception e){
            throw new RuntimeException("failed get mapToObject", e);
        }

        return obj;
    }

}
