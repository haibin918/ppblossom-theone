package com.meicai.ppblossom.theone.commons.redis;

/**
 * @Author: guohaibin
 * @Date: 2020/06/03
 * @Version 1.0
 */
public class RedisKey {

    public static final String STRATEGY_FREQUENCY_SHOW_TIMES = "ide:s:f:%d:%s";// %d: companyId, %s: date,   value: 今天显示次数

    public static String key(String key, Object... values) {
        return String.format(key, values);
    }

    public static final String APPOINT_NO_REDISKEY = "ppblossom-theone-appoint-no-";

    public static final String APPOINT_GROUP_REDISKEY = "ppblossom-theone-appoint-group-";

    public static final String SMS_PHONE_REDISKEY  = "ppblossom-theone-sms-phone-";

    public static final String SALE_CLASS_REDISKEY = "ppblossom-theone-saleClass-";

    public static final String SKU_SSU_REDISKEY = "ppblossom-theone-skuSsu-";

    public static final String RISK_MANAGE_PHONE_REDISKEY = "ppblossom-theone-risk-phone-";

    public static final String STORE_DETAIL_REDISKEY = "DMALL_{STORE_DETAIL_1}_";

    public static final String GROUP_DETAIL_REDISKEY = "DMALL_{GROUP_DETAIL_1}_";

    public static final String GROUP_MEMBER_REDISKEY = "DMALL_{MEMBER_DETAIL_1}_";

    public static final String STORE_MODIFY_FIELDS_REDISKEY = "dmall_store_modify_fields_";


}
