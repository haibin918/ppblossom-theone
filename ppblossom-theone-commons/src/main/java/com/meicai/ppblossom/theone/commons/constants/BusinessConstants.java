package com.meicai.ppblossom.theone.commons.constants;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName BusinessConstants
 * @Description 业务code码
 * @Author zf
 * @Date 2020/6/30 09:53
 * @Version 1.0
 **/
public class BusinessConstants {

    //订单状态 0:待确认1:已确认
    public static final Integer  ORDER_STATUS_ZERO = 0;
    public static final Integer  ORDER_STATUS_ONE  = 1;

    //订单type 1:预占；2:解预占
    public static final Integer FLOCK_TYPE_ONE = 1;
    public static final Integer FLOCK_TYPE_TWO = 2;

    //是否取消订单 0:有效；1:已取消
    public static final Integer IS_VALID = 0;
    public static final Integer IS_CANCEL= 1;

    //客户业务类型 代采 6
    public static final Integer IS_PURCHASE = 6;
    //客户业务类型 代采 pop
    public static final Integer IS_PURCHASE_POP = 27;

    //业务范围标识 1:管家自营 2:美菜直营 3：美菜直营&代采
    public static final Integer BUSINESS_SCOPE_HOUSEKEEP = 1;
    //业务范围标识 1:管家自营 2:美菜直营 3：美菜直营&代采
    public static final Integer BUSINESS_SCOPE_MC = 2;
    //业务范围标识 1:管家自营 2:美菜直营 3：美菜直营&代采
    public static final Integer BUSINESS_SCOPE_ALL = 3;

    //扩展业务  1直营自营&POP 6管家自营 27pop管家
    public static final List<Integer> BUSINESS_EXTEND_LIST = Arrays.asList(1,27);

}
