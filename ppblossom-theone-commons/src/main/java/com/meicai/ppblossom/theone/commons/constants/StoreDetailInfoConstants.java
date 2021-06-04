package com.meicai.ppblossom.theone.commons.constants;

/**
 * @ClassName StoreDetailInfoConstants
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/1/8 下午5:41
 * @Version 1.0
 **/
public class StoreDetailInfoConstants {

    /*
     * 普通大客户标签
     */
    public static final Integer NORMAL_BIG_GROUP_TAG = 4;//普通大客户

    /*
     * 默认服务类型
     */
    public static final Integer DEFAULT_SERVICE_TYPE = 0;

    /*
     * 门店单笔订单限额
     */
    public static final Integer STORE_ORDER_LIMITS_ONE = -1;

    /*
     * 门店单日订单限额
     */
    public static final Integer STORE_ORDER_LIMITS_DAY = -1;


    public static final Integer CACHE_STORE_DETAIL_TIME = 86400 * 7;

    public static final Integer CACHE_GROUP_DETAIL_TIME = 86400 * 7;

    /**
     * 待审核
     *
     * @var integer
     */
    public static final Integer VERIFY_STATUS_WAIT = 1;

    /**
     * 已通过
     *
     * @var integer
     */
    public static final Integer VERIFY_STATUS_YES = 2;

    /**
     * 未通过
     *
     * @var integer
     */
    public static final Integer VERIFY_STATUS_NO = 3;


    //固定有效期
    public static final Integer FIX_EXPIRE = 1;
    //永久有效期
    public static final Integer FOREVER_EXPIRE = 2;

    public static final Integer FOREVER_EXPIRE_DATE = 2082643200;


}
