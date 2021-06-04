package com.meicai.ppblossom.theone.commons.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName ParamUtil
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/12 11:45
 * @Version 1.0
 **/
public class ParamUtil {
    public static final String UNDERLINE_FLAG = "_";

    public static final String COMMA_FLAG = ",";

    /**
     * 如果字符串为空返回
     *
     * @param str
     * @return
     */
    public static boolean isStringEmpty(String str) {
        return (str == null || "".equals(str));
    }

    public static boolean isListEmpty(List list) {
        return (null == list || list.size() == 0);
    }

    public static boolean isCollectionEmpty(Collection list) {
        return (null == list || list.size() == 0);
    }

    public static boolean isArrayEmpty(Object[] list) {
        return (null == list || list.length == 0);
    }

    public static boolean isIntegerEmpty(Integer arg) {
        return (null == arg || 0 == arg);
    }

    public static boolean isLongEmpty(Long arg) {
        return (null == arg || 0 == arg);
    }

    /**
     * 四舍五入保留n位小数
     *
     * @param value value
     * @param scale n位小数
     * @return return
     */
    public static Double formatNum(Double value, int scale) {
        if (null == value) {
            return 0.0;
        }
        BigDecimal bd = new BigDecimal(value);
        return bd.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 把list转换成相应的map结构
     * <p>
     *
     * @param list list
     * @param key  key
     * @param <T>  </T>
     * @return return
     */
    public static <T> Map<Long, T> changeListToLongKeyMap(List<T> list, String key) {
        Map<Long, T> result = new LinkedHashMap<>();
        if (null == list || list.size() == 0) {
            return result;
        }
        try {
            Field field = getDeclaredField(list.get(0), key);
            field.setAccessible(true);
            for (T item : list) {
                Long id = (Long) field.get(item);
                result.put(id, item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     *
     * @param object    : 子类对象
     * @param fieldName : 父类中的属性名
     * @return 父类中的属性对象
     */
    public static Field getDeclaredField(Object object, String fieldName) {
        Field field = null;
        Class<?> clazz = object.getClass();
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

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     *
     * @param clazz     : 子类类型
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

    /**
     * 提取相关的变量
     *
     * @param list list
     * @param key  key
     * @param <T>  </T>
     * @return return
     */
    public static <T> List<Long> changeListToLongList(List<T> list, String key) {
        if (null == list || list.size() == 0) {
            return new ArrayList<Long>();
        }
        List<Long> result = new ArrayList<>();
        try {
            Field field = getDeclaredField(list.get(0), key);
            field.setAccessible(true);
            for (T item : list) {
                Long id = (Long) field.get(item);
                if (!result.contains(id)) {
                    result.add(id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 从map中提取相关变量
     *
     * @param list list
     * @param key  key
     * @return return
     */
    public static <K, V> List<Long> changeMapListToLongList(List<Map<K, V>> list, String key) {
        List<Long> result = new ArrayList<>();
        try {
            for (Map m : list) {
                if (m.containsKey(key)) {
                    Long item = Long.parseLong("" + m.get(key));
                    if (!result.contains(item)) {
                        result.add(item);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 根据条件过滤list,保留只满足条件的list
     *
     * @param list      list
     * @param key       key
     * @param conditons conditions
     * @param clazz     clazz
     * @param <T>       <T>
     * @return return
     */
    public static <T, V> List<T> filterList(List<T> list, String key, Class<V> type, List<V> conditons, Class<T> clazz) {
        if (null == list || list.size() == 0) {
            return new ArrayList<T>();
        }
        try {
            Field field = getDeclaredField(list.get(0), key);
            field.setAccessible(true);
            Iterator<T> itr = list.iterator();
            while (itr.hasNext()) {
                T item = itr.next();
                V id = (V) field.get(item);
                if (!conditons.contains(id)) {
                    itr.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 判断字符串是否是整数
     */
    public static boolean isInteger(String value) {
        if (value == null || "".equals(value)) {
            return false;
        }
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断字符串是否是long
     */
    public static boolean isLong(String value) {
        if (value == null || "".equals(value)) {
            return false;
        }
        try {
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断字符串是否是double
     */
    public static boolean isDouble(String value) {
        if (value == null || "".equals(value)) {
            return false;
        }
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 将固定格式的字符串转换成list
     *
     * @param source    source
     * @param separator separator
     * @return return
     */
    public static List<Long> splitStringToLongList(String source, String separator) {
        List<Long> result = new ArrayList<>();
        if (StringUtils.isEmpty(source) || StringUtils.isEmpty(separator)) {
            return result;
        }
        String sourceArr[] = source.split(separator);
        for (int i = 0; i < sourceArr.length; i++) {
            String item = sourceArr[i];
            if (StringUtils.isNumeric(item)) {
                result.add(Long.parseLong(item));
            }
        }
        return result;
    }

    public static <T> String splitListToStr(List<T> datas, String separator) {
        if (ParamUtil.isListEmpty(datas)) {
            return "";
        }
        if (StringUtils.isEmpty(separator)) {
            separator = ParamUtil.COMMA_FLAG;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (T data : datas) {
            sb.append(data + "");
            if (i < datas.size() - 1) {
                sb.append(separator);
            }
            i++;
        }
        return sb.toString();
    }

    /**
     * 将大集合按照数量拆分成小集合
     *
     * @param totalList  被拆分集合
     * @param splitCount 拆分总集合
     * @return return
     */
    public static <T> List<List<T>> listSplit(List<T> totalList, int splitCount) {
        List<List<T>> result = new ArrayList<List<T>>();
        if (CollectionUtils.isEmpty(totalList) || splitCount < 1) {
            return result;
        }
        int size = totalList.size();
        //数据量不足count指定的大小
        if (size <= splitCount) {
            result.add(totalList);
        } else {
            int page = size / splitCount;
            int last = size % splitCount;
            //前面pre个集合，每个大小都是count个元素
            for (int i = 0; i < page; i++) {
                List<T> itemList = new ArrayList<T>();
                for (int j = 0; j < splitCount; j++) {
                    itemList.add(totalList.get(i * splitCount + j));
                }
                result.add(itemList);
            }
            //last的进行处理
            if (last > 0) {
                List<T> itemList = new ArrayList<T>();
                for (int i = 0; i < last; i++) {
                    itemList.add(totalList.get(page * splitCount + i));
                }
                result.add(itemList);
            }
        }
        return result;

    }


    /**
     * 字符串拼接
     *
     * @param source    source
     * @param delimeter 分隔符
     * @param addInfo   addInfo
     * @return return
     */
    public static String addInfo(String source, String delimeter, String addInfo) {
        StringBuffer buffer = new StringBuffer();
        if (StringUtils.isEmpty(source)) {
            buffer.append(addInfo);
        } else {
            buffer.append(source).append(delimeter).append(addInfo);
        }
        return buffer.toString();
    }

    public static String objectToString(Object o, boolean isDefalutEmpty) {
        if (null == o && isDefalutEmpty) {
            return "";
        } else if (null == o) {
            return null;
        }
        return o.toString();
    }

    public static Long objectToLong(Object o, boolean isDefalutZero) {
        if (null == o && isDefalutZero) {
            return 0L;
        } else if (null == o) {
            return null;
        }
        return Long.parseLong(o.toString());
    }

    public static Integer objectToInteger(Object o, boolean isDefalutZero) {
        if (null == o && isDefalutZero) {
            return 0;
        } else if (null == o) {
            return null;
        }
        return Integer.parseInt(o.toString());
    }

    public static Double objectToDouble(Object o, boolean isDefalutZero) {
        if (null == o && isDefalutZero) {
            return 0d;
        } else if (null == o) {
            return null;
        }
        return Double.parseDouble(o.toString());
    }

    public static Boolean objectToBoolean(Object o, boolean isDefalutFalse) {
        if (null == o && isDefalutFalse) {
            return false;
        } else if (null == o) {
            return null;
        }
        return Boolean.parseBoolean(o.toString());
    }

    public static Float objectToFloat(Object o, boolean isDefalutZero) {
        if (null == o && isDefalutZero) {
            return 0F;
        } else if (null == o) {
            return null;
        }
        return Float.parseFloat(o.toString());
    }

    public static List<String> longListToStringList(List<Long> longList) {
        if (null == longList) {
            return null;
        }
        List<String> strList = new ArrayList<>();
        for (Long eachLong : longList) {
            strList.add(String.valueOf(eachLong));
        }
        return strList;
    }

    /**
     * 移除map中的value空值
     *
     * @param map
     * @return
     */
    public static void removeNullValue(Map map) {
        Set set = map.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Object obj = (Object) iterator.next();
            Object value = (Object) map.get(obj);
            remove(value, iterator);
        }
    }

    /**
     * 内部调用
     *
     * @param obj
     * @param iterator
     */
    private static void remove(Object obj, Iterator iterator) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (isStringEmpty(str)) {  //过滤掉为null和""的值 主函数输出结果map：{2=BB, 1=AA, 5=CC, 8=  }
                //if("".equals(str.trim())){  //过滤掉为null、""和" "的值 主函数输出结果map：{2=BB, 1=AA, 5=CC}
                iterator.remove();
            }
        } else if (obj instanceof Collection) {
            Collection col = (Collection) obj;
            if (col == null || col.isEmpty()) {
                iterator.remove();
            }
        } else if (obj instanceof Map) {
            Map temp = (Map) obj;
            if (temp == null || temp.isEmpty()) {
                iterator.remove();
            }
        } else if (obj instanceof Object[]) {
            Object[] array = (Object[]) obj;
            if (array == null || array.length <= 0) {
                iterator.remove();
            }
        } else {
            if (obj == null) {
                iterator.remove();
            }
        }
    }

    // 验证手机号
    public static boolean isMobile(String str) {
        if (null == str || "" == str) {
            return false;
        }
        Pattern p = Pattern.compile("^[1][3,4,5,8,7,9,2,6][0-9]{9}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 当key不唯一，对应多条数据时，转成key->list类型数据返回
     *
     * @param list
     * @param key
     * @param <T>
     * @return
     */
    public static <T> Map<Long, List<T>> changeListToLongKeyList(List<T> list, String key) {
        Map<Long, List<T>> resultMap = new LinkedHashMap<>();
        List<T> resultList = new ArrayList<>();
        if (null == list || list.size() == 0) {
            return resultMap;
        }
        try {
            Field field = getDeclaredField(list.get(0), key);
            field.setAccessible(true);
            for (T item : list) {
                for (int i = 0; i < list.size(); i++) {
                    if (field.get(item).equals(field.get(list.get(i)))) {
                        resultList.add(list.get(i));
                    }
                }
                resultMap.put((Long) field.get(item), resultList);
                resultList = new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    public static BigDecimal formatMoneyConvert(Long value, BigDecimal roundingMode, int scale) {
        if (null == value) {
            return new BigDecimal(0.0D);
        } else if (null != roundingMode && !roundingMode.equals(BigDecimal.ZERO)) {
            BigDecimal bd = new BigDecimal(value.longValue());
            return bd.divide(roundingMode, scale, 4);
        } else {
            return new BigDecimal(value.longValue());
        }
    }

    /**
     * Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
     *
     * @param obj
     * @return songzhaoying
     */
    public static Map<String, Object> transBean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }
        return map;
    }

    public static List getSubList(List list, int offset, int limit) {
        if (isListEmpty(list)) {
            return new ArrayList();
        }
        int size = list.size();
        if (size >= offset + limit) {
            return list.subList(offset, offset + limit);
        } else if (size > offset && size < offset + limit) {
            return list.subList(offset, size);
        }
        return new ArrayList();
    }

    /**
     *
     * 方法描述 判断一个对象是否是一个数组
     *
     * @param obj
     * @return
     *
     * @author yaomy
     * @date 2018年2月5日 下午5:03:00
     */
    public static boolean isArray(Object obj) {
        if(obj == null) {
            return false;
        }
        return obj.getClass().isArray();
    }
}
