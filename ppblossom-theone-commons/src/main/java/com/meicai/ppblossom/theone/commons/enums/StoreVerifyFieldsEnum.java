package com.meicai.ppblossom.theone.commons.enums;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName StoreVerifyFieldsEnum
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/1/12 下午2:38
 * @Version 1.0
 **/

@Getter
public enum StoreVerifyFieldsEnum {

    STORE_NAME("storeName", "store_name"),
    PROVINCE_ID("provinceId", "province_id");

    private String key;

    private String value;

    StoreVerifyFieldsEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static Map<String, String> getStoreVerifyFieldsMap() {
        Map<String, String> map = new HashMap<>();
        for (StoreVerifyFieldsEnum storeKey : StoreVerifyFieldsEnum.values()) {
            map.put(storeKey.getKey(), storeKey.getValue());
        }
        return map;
    }
}
