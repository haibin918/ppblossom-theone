package com.meicai.ppblossom.theone.commons.utils;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @ClassName BeanMapper
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/12 11:42
 * @Version 1.0
 **/
public class BeanMapper {
    static Logger logger = LoggerFactory.getLogger(BeanMapper.class);
    /**
     * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
     */
    private static DozerBeanMapper dozer = new DozerBeanMapper();

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        return dozer.map(source, destinationClass);
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    @SuppressWarnings("rawtypes")
    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = Lists.newArrayList();
        for (Object sourceObject : sourceList) {
            T destinationObject = dozer.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    /**
     * 基于Dozer将对象A的值拷贝到对象B中.
     */
    public static void copy(Object source, Object destinationObject) {
        dozer.map(source, destinationObject);
    }

    /**
     * set field value for given object
     *
     * @param targetObject
     * @param field
     * @param value
     */
    public static void setFieldValue(Object targetObject, Field field, String value) {
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);

        Class<?> fieldType = field.getType();

        try {
            if (fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)) {
                field.set(targetObject, Boolean.valueOf(value));
            } else if (fieldType.equals(byte.class) || fieldType.equals(Byte.class)) {
                field.set(targetObject, Byte.valueOf(value));
            } else if (fieldType.equals(char.class) || fieldType.equals(Character.class)) {
                field.set(targetObject, Character.valueOf(value.charAt(0)));
            } else if (fieldType.equals(double.class) || fieldType.equals(Double.class)) {
                field.set(targetObject, Double.valueOf(value));
            } else if (fieldType.equals(float.class) || fieldType.equals(Float.class)) {
                field.set(targetObject, Float.valueOf(value));
            } else if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
                field.set(targetObject, Integer.valueOf(value));
            } else if (fieldType.equals(long.class) || fieldType.equals(Long.class)) {
                field.set(targetObject, Long.valueOf(value));
            } else if (fieldType.equals(short.class) || fieldType.equals(Short.class)) {
                field.set(targetObject, Short.valueOf(value));
            } else {
                field.set(targetObject, value);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("setFieldValue failed for ").append(targetObject.getClass().getName()).append(".").append(field.getName()).append(". value = ").append(value);
            throw new RuntimeException(sb.toString(), e);
        }

        field.setAccessible(isAccessible);
    }

    /**
     * get the field value for given object
     *
     * @param targetObject
     * @param field
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getFieldValue(Object targetObject, Field field) {
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        Object value = null;
        try {
            value = field.get(targetObject);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getFieldValue failed for ").append(targetObject.getClass().getName()).append(".").append(field.getName()).append(". value = ").append(value);
            throw new RuntimeException(sb.toString(), e);
        }
        field.setAccessible(isAccessible);
        return (T) value;
    }

    /**
     * 获取实例化对象
     *
     * @param c             对象Class
     * @param understoreMap
     * @return
     */
    public static <T> T changeToCamelClsByMap(Map<String, Object> understoreMap, Class<T> c) {
        if (null == understoreMap) {
            return null;
        }
        try {
            T o = c.newInstance();
            String[] names = understoreMap.keySet().toArray(new String[0]);
            Map<String, Object> methodMap = new HashMap<String, Object>();
            for (int i = 0; i < names.length; i++) {
                String name = names[i];
                StringBuilder tname = new StringBuilder().append("set");
                if (name.indexOf("_") == 1 ||
                        (Character.isLowerCase(name.charAt(0)) && Character.isUpperCase(name.charAt(1)))) {
                    tname.append(name.charAt(0));
                } else {
                    tname.append((char) (name.charAt(0) - 32));
                }
                if (name.indexOf("_") > 0) {
                    int start = 1;
                    int end = name.indexOf("_");
                    while (end > 0) {
                        tname.append(name.substring(start, end));
                        start = end + 1;
                        tname.append((char) (name.charAt(start) - 32));
                        start++;
                        end = name.indexOf("_", start);
                    }
                    if (start < name.length()) {
                        tname.append(name.substring(start, name.length()));
                    }
                } else {
                    tname.append(name.substring(1));
                }
                methodMap.put(tname.toString(), understoreMap.get(name));
            }
            Method[] rs = c.getMethods();
            for (Method method : rs) {
                String mn = method.getName();
                if (mn.startsWith("set")) {
                    if (methodMap.containsKey(mn) && methodMap.get(mn) != null) {
                        try {
                            setValueToObject(method, methodMap.get(mn), o);
                        } catch (Exception e) {
                            logger.error(e.getMessage(), e);
                        }
                    }
                }
            }
            return o;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     *
     * @param fieldName : 父类中的属性名
     * @return 父类中的属性对象
     */
    public static Field getDeclaredField(Class<?> clazz, String fieldName) {
        Field field = null;
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return null;
    }

    public static List<Field> getDeclaredFields(Class<?> clazz) {
        List<Field> results = new ArrayList<>();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                for (Field field1 : clazz.getDeclaredFields()) {
                    results.add(field1);
                }
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return results;
    }

    private static void setValueToObject(Method method, Object vlaue, Object o) throws Exception {
        if ("java.lang.Long".equals(method.getGenericParameterTypes()[0].getTypeName())) {
            vlaue = ParamUtil.objectToLong(vlaue, false);
            method.invoke(o, new Object[]{vlaue});
        } else if (method.getParameterTypes()[0] == String.class) {
            vlaue = ParamUtil.objectToString(vlaue, false);
            method.invoke(o, new Object[]{vlaue});
        } else if (method.getParameterTypes()[0] == Integer.class || method.getParameterTypes()[0] == int.class) {
            vlaue = ParamUtil.objectToInteger(vlaue, false);
            method.invoke(o, new Object[]{vlaue});
        } else if (method.getParameterTypes()[0] == Double.class || method.getParameterTypes()[0] == double.class) {
            vlaue = ParamUtil.objectToDouble(vlaue, false);
            method.invoke(o, new Object[]{vlaue});
        } else if (method.getParameterTypes()[0] == Boolean.class || method.getParameterTypes()[0] == boolean.class) {
            vlaue = ParamUtil.objectToBoolean(vlaue, false);
            method.invoke(o, new Object[]{vlaue});
        } else if (method.getParameterTypes()[0] == Float.class || method.getParameterTypes()[0] == float.class) {
            vlaue = ParamUtil.objectToFloat(vlaue, false);
            method.invoke(o, new Object[]{vlaue});
        } else if ("java.util.Collection<java.lang.Long>".equals(method.getGenericParameterTypes()[0].getTypeName())) {
            List<Long> listObjects = new ArrayList<Long>();
            for (Object oVlaue : (List) vlaue) {
                listObjects.add(ParamUtil.objectToLong(oVlaue, false));
            }
            method.invoke(o, new Object[]{listObjects});
        } else if (method.getParameterTypes()[0] == Collection.class && vlaue instanceof Object[]) {
            List listObjects = new ArrayList<>();
            for (Object oVlaue : (Object[]) vlaue) {
                listObjects.add(oVlaue);
            }
            method.invoke(o, new Object[]{listObjects});
        } else {
            method.invoke(o, new Object[]{vlaue});
        }
    }

    /**
     * List<Map> 转 Map<Long, Map>
     *
     * @param datasMap
     * @param mapUniqueKey
     * @return
     */
    public static Map<Long, Map> changeToMapLongKeyList(List<Map> datasMap, String mapUniqueKey) {
        Map<Long, Map> uniqueKeyMap = new HashMap<Long, Map>();
        for (Map map : datasMap) {
            if (!map.containsKey(mapUniqueKey)) {
                continue;
            }
            Object keyValue = map.get(mapUniqueKey);
            if (null == keyValue) {
                continue;
            }
            uniqueKeyMap.put(Long.parseLong(keyValue.toString()), map);

        }
        return uniqueKeyMap;
    }
}
