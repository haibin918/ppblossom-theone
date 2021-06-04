package com.meicai.ppblossom.theone.commons.constants;

/**
 * @ClassName McqConstants
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/6 09:53
 * @Version 1.0
 **/
public class McqConstants {

    public static final String UTF_8 = "utf-8";

    public static final String MALL_SPLIT_ORDER_TOPIC = "mall_split_order_topic";
    public static final String MALL_ORDER_CENTER_CONFIRM = "mall_order_center_confirm";

    public static final String MALL_ORDER_CENTER_CANCEL = "mall_order_center_cancel";

    public static final String TP_POC_SPLIT_ORDER_NOTICE = "tp_poc_split_order_notice";

    public static final String MALL_SPLIT_ORDER_TAG = "big_mall";

    public static final String POC_SPLIT_ORDER_TAG = "BIG_MALL";
    //一二级售卖分类
    public static final String PCC_SKU_BIND_SALECLASS_CHANGE_TOPIC = "pcc_sku_bind_saleclass_change";
    public static final String PCC_SKU_BIND_SALECLASS_CHANGE_TAG = "1";
    //价格变化MQ
    public static final String KEYCLIENT_PERIODISM_PRICE_TOPIC = "keyclient_periodism_price";

    //合同状态mcq
    public static final String CONTRACT_STATUS_TOPIC = "ecp_contract_status_notify";
    public static final String CONTRACT_STATUS_TAG = "ppblossom-theone";
    //合同审批状态mcq
    public static final String CONTRACT_APPROVAL_STATUS_TOPIC = "oas_approve_notify";
    //public static final String CONTRACT_APPROVAL_STATUS_TAG = "dmall";

    public static final String DMALL_LIMIT_RC_TOPIC = "dmall_limit_rc";

    public static final String DMALL_LIMIT_EFFECTIVE_TOPIC = "tp_poc_order_effective_notice";

    public static final String DMALL_LIMIT_CANCEL_TOPIC = "tp_poc_order_cancel_notice";

    public static final String DMALL_LIMIT_TAG = "BIG_MALL";

    public static final String DMALL_GROUP_TOPIC = "DMALL_GROUP_INFO_CHANGE";

}
