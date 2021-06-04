package com.meicai.ppblossom.theone.commons.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreDataConstants {

    public static final Map<String, String> STORE_VERIFY_FIELDS_MAP = new HashMap<String, String>();
        static {
            STORE_VERIFY_FIELDS_MAP.put("storeName", "store_name");
            STORE_VERIFY_FIELDS_MAP.put("provinceId", "province_id");
            STORE_VERIFY_FIELDS_MAP.put("provinceName", "province_name");
            STORE_VERIFY_FIELDS_MAP.put("cityId", "city_id");
            STORE_VERIFY_FIELDS_MAP.put("cityName", "city_name");
            STORE_VERIFY_FIELDS_MAP.put("regionId", "region_id");
            STORE_VERIFY_FIELDS_MAP.put("regionName", "region_name");
            STORE_VERIFY_FIELDS_MAP.put("address", "address");
            STORE_VERIFY_FIELDS_MAP.put("addressDetail", "address_detail");
            STORE_VERIFY_FIELDS_MAP.put("lat", "lat");
            STORE_VERIFY_FIELDS_MAP.put("lng", "lng");
            STORE_VERIFY_FIELDS_MAP.put("areaId", "area_id");
            STORE_VERIFY_FIELDS_MAP.put("classA", "class_a");
            STORE_VERIFY_FIELDS_MAP.put("classAName", "class_a_name");
            STORE_VERIFY_FIELDS_MAP.put("classB", "class_b");
            STORE_VERIFY_FIELDS_MAP.put("classBName", "class_b_name");
            STORE_VERIFY_FIELDS_MAP.put("classC", "class_c");
            STORE_VERIFY_FIELDS_MAP.put("classCName", "class_c_name");
            STORE_VERIFY_FIELDS_MAP.put("placeId", "place_id");
            STORE_VERIFY_FIELDS_MAP.put("receiveStartTime", "receive_start_time");
            STORE_VERIFY_FIELDS_MAP.put("receiveEndTime", "receive_end_time");
            STORE_VERIFY_FIELDS_MAP.put("doorFacePic", "door_face_pic");
            STORE_VERIFY_FIELDS_MAP.put("shopInPic", "shop_in_pic");
            STORE_VERIFY_FIELDS_MAP.put("licensePic", "license_pic");
            STORE_VERIFY_FIELDS_MAP.put("regNum", "reg_num");
            STORE_VERIFY_FIELDS_MAP.put("expireType", "expire_type");
            STORE_VERIFY_FIELDS_MAP.put("expireDate", "expire_date");
            STORE_VERIFY_FIELDS_MAP.put("licenseName", "license_name");

        }


    public static final Map<String, String> VERIFY_FIELD_JC_MAP = new HashMap<String, String>();
        static{
            VERIFY_FIELD_JC_MAP.put("classA", "class");
            VERIFY_FIELD_JC_MAP.put("classAName", "class");
            VERIFY_FIELD_JC_MAP.put("classB", "class");
            VERIFY_FIELD_JC_MAP.put("classBName", "class");
            VERIFY_FIELD_JC_MAP.put("classC", "class");
            VERIFY_FIELD_JC_MAP.put("classCName", "class");
            VERIFY_FIELD_JC_MAP.put("address", "address");
            VERIFY_FIELD_JC_MAP.put("areaId", "address");
            VERIFY_FIELD_JC_MAP.put("provinceId", "address");
            VERIFY_FIELD_JC_MAP.put("provinceName", "address");
            VERIFY_FIELD_JC_MAP.put("cityId", "address");
            VERIFY_FIELD_JC_MAP.put("cityName", "address");
            VERIFY_FIELD_JC_MAP.put("regionId", "address");
            VERIFY_FIELD_JC_MAP.put("regionName", "address");
            VERIFY_FIELD_JC_MAP.put("addressDetail", "address");
            VERIFY_FIELD_JC_MAP.put("lng", "address");
            VERIFY_FIELD_JC_MAP.put("lat", "address");
            VERIFY_FIELD_JC_MAP.put("receiveStartTime", "receiveStartTime");
            VERIFY_FIELD_JC_MAP.put("receiveEndTime", "receiveStartTime");
            VERIFY_FIELD_JC_MAP.put("licensePic", "licensePic");
            VERIFY_FIELD_JC_MAP.put("regNum", "licensePic");
            VERIFY_FIELD_JC_MAP.put("expireType", "licensePic");
            VERIFY_FIELD_JC_MAP.put("expireDate", "licensePic");
            VERIFY_FIELD_JC_MAP.put("licenseName", "licensePic");
            VERIFY_FIELD_JC_MAP.put("shopInPic", "shopInPic");
            VERIFY_FIELD_JC_MAP.put("doorFacePic", "shopInPic");

        }



    public static final List<String> VALUE_IS_ARRAY_VERIFY_FIELDS = Arrays.asList("classC","classCName","doorFacePic","shopInPic");

    public static final List<String> EXTEND_STABLE_FIELDS = Arrays.asList("doorFacePic","shopInPic","licensePic","regNum",
            "expireType","expireDate","licenseName","serviceType");

    public static final Map<String, Map<String,Object>> VERIFY_FIELD_MAP = new HashMap<>();
    public static final  Map<String, Object> CLASS_MAP = new HashMap<>();
    public static final  Map<String, Object> ADDRESS_MAP = new HashMap<>();
    public static final  Map<String, Object> RECEIVE_TIME_MAP = new HashMap<>();
    public static final  Map<String, Object> LICENSE_PIC_MAP = new HashMap<>();
    public static final  Map<String, Object> SHOP_PIC_MAP = new HashMap<>();
    //CLASS_MAP
    static {
        CLASS_MAP.put("classA", null);
        CLASS_MAP.put("classAName",null);
        CLASS_MAP.put("classB", null);
        CLASS_MAP.put("classBName", null);
        CLASS_MAP.put("classC", null);
        CLASS_MAP.put("classCName", null);
    }
    //ADDRESS_MAP
    static {
        ADDRESS_MAP.put("address",null);
        ADDRESS_MAP.put("areaId", null);
        ADDRESS_MAP.put("provinceId",null);
        ADDRESS_MAP.put("provinceName", null);
        ADDRESS_MAP.put("cityId", null);
        ADDRESS_MAP.put("cityName", null);
        ADDRESS_MAP.put("regionId",null);
        ADDRESS_MAP.put("regionName", null);
        ADDRESS_MAP.put("addressDetail", null);
        ADDRESS_MAP.put("lng",null);
        ADDRESS_MAP.put("lat",null);
    }
    //RECEIVE_TIME_MAP
    static {
        RECEIVE_TIME_MAP.put("receiveStartTime",null);
        RECEIVE_TIME_MAP.put("receiveEndTime", null);

    }
    //LICENSE_PIC_MAP
    static {
        LICENSE_PIC_MAP.put("licensePic", null);
        LICENSE_PIC_MAP.put("regNum", null);
        LICENSE_PIC_MAP.put("expireType", null);
        LICENSE_PIC_MAP.put("expireDate", null);
        LICENSE_PIC_MAP.put("licenseName", null);
    }
    //LICENSE_PIC_MAP
    static {
        SHOP_PIC_MAP.put("shopInPic", null);
        SHOP_PIC_MAP.put("doorFacePic", null);
    }
    static {
        VERIFY_FIELD_MAP.put("class",CLASS_MAP);
        VERIFY_FIELD_MAP.put("address",ADDRESS_MAP);
        VERIFY_FIELD_MAP.put("receiveStartTime",RECEIVE_TIME_MAP);
        VERIFY_FIELD_MAP.put("licensePic",LICENSE_PIC_MAP);
        VERIFY_FIELD_MAP.put("shopInPic",SHOP_PIC_MAP);
    }

    public static final  Map<String, String> VERIFY_FIELDS_NAME_MAP = new HashMap<>();
    static {
        VERIFY_FIELDS_NAME_MAP.put("allPass","全部");
        VERIFY_FIELDS_NAME_MAP.put("storeName","门店名称");
        VERIFY_FIELDS_NAME_MAP.put("address","门店地址");
        VERIFY_FIELDS_NAME_MAP.put("class","门店类型");
        VERIFY_FIELDS_NAME_MAP.put("placeId","经营场所");
        VERIFY_FIELDS_NAME_MAP.put("receiveStartTime","收货时间");
        VERIFY_FIELDS_NAME_MAP.put("shopInPic","门店图片");
        VERIFY_FIELDS_NAME_MAP.put("licensePic","营业执照");

    }
    /**
     * 更新门店信息与企业平台审核字段 映射
     */
    public static final  Map<String, String> CORP_API_FIELDS_MAP = new HashMap<>();
    static {
        CORP_API_FIELDS_MAP.put("storeId","id");
        CORP_API_FIELDS_MAP.put("storeName","name");
        CORP_API_FIELDS_MAP.put("lat","lat");
        CORP_API_FIELDS_MAP.put("lng","lng");
        CORP_API_FIELDS_MAP.put("address","address_detail");
        CORP_API_FIELDS_MAP.put("addressDetail","poi_address");
        CORP_API_FIELDS_MAP.put("ywCityId","city_id");
        CORP_API_FIELDS_MAP.put("provinceName","province");
        CORP_API_FIELDS_MAP.put("cityName","city");
        CORP_API_FIELDS_MAP.put("regionName","region");
        CORP_API_FIELDS_MAP.put("floor","floor");
        CORP_API_FIELDS_MAP.put("personName","person_name");
        CORP_API_FIELDS_MAP.put("phone","phone");
    }

}
