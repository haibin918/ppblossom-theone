package com.meicai.ppblossom.theone.commons.enums;

/**
 * @ClassName ResultCodeEnum
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/15 17:41
 * @Version 1.0
 **/
public enum ResultCodeEnum {

    DEV_EXPTION(-1, "非常感谢你，帮程序员找到一个八阿哥！"),

    SUCCESS(1, "成功"),

    PARAM_NULL_ERROR(2, "%s不能为空"),

    PARAM_ERR(3, "参数错误"),

    PARAM_INCOMPLETE_ERROR(4, "前端入参信息不完整"),

    SYS_ERR(5, "系统异常，请联系客服！"),

    RATE_ERROR(20001, "[%s],格式错误"),

    TICKET_QUERY_ERROR(2019, "Tickets获取失败"),

    LOGIN_ERROR(-1, "登录信息获取失败，请重新登录"),

    CLEAR_HISTORY_WORDS_ERROR(-1, "清空历史搜索词失败"),

    QUERY_HISTORY_WORDS_ERROR(-1, "获取历史搜索词失败"),

    QUERY_ACC_WORDS_ERROR(-1, "获取搜索联想词失败"),

    QUERY_DMALL_GOODS_ERROR(-1, "获取大客户商品失败"),

    ADD_PURCHASE_GOODS_ERROR(-1, "添加清单商品失败"),

    DELETE_ATTENTION_GOODS_ERROR(-1, "移除特别关注失败"),

    DELETE_PURCHASE_GOODS_ERROR(-1, "删除清单商品失败"),

    QUERY_PURCHASE_LIST_ERROR(-1, "获取清单列表失败"),

    QUERY_PURCHASE_GOODS_LIST_ERROR(-1, "获取清单商品列表失败"),

    QUERY_PERSONAL_CENTER_ERROR(-1, "获取个人中心信息失败"),

    QUERY_GOODS_DETAIL_ERROR(-1, "获取商品详情信息失败"),

    QUERY_GOODS_FORMAT_DETAIL_ERROR(-1, "获取对应包规商品失败"),

    QUERY_CONFIG_PARAM_ERROR(-1, "获取变量配置失败"),

    QUERY_FIXPHONE_PARAM_ERROR(-1, "获取电话信息失败"),

    QUERY_MATERIAL_ERROR(-1, "获取素材信息失败"),

    RESERVE_STOCK_APPOINT_ERROR(2001, "下单数据协议不正确！"),

    RESERVE_STOCK_PRICE_ERROR(2002, "下单数据价格不正确！"),

    RESERVE_STOCK_STOCK_ERROR(2003, "下单数据库存不正确！"),

    ROLLBACK_RESERVE_STOCK_ERROR(2004, "回滚预占库存失败！"),
    //签章业务异常码
    SIGNATURE_ERROR_4001(4001, "请先联系销售维护统一信用代码"),
    SIGNATURE_ERROR_4002(4002, "请先联系销售维护统一信用代码有效期"),
    SIGNATURE_ERROR_4003(4003, "当前企业未在电子合同系统进行认证"),
    SIGNATURE_ERROR_4004(4004, "客户最多只能创建5个签章"),
    SIGNATURE_ERROR_4005(4005, "客户仅能创建类型为“公章”和“合同专用章”的签章"),
    SIGNATURE_ERROR_4006(4006, "企业名称最长只允许输入20个字"),
    SIGNATURE_ERROR_4007(4007, "当前企业在电子合同系统处于认证中"),
    SIGNATURE_ERROR_4008(4008, "企业未认证"),
    SIGNATURE_ERROR_4009(4009, "企业认证失败"),
    SIGNATURE_ERROR_4010(4010, "未获取到该企业名称对应的统一信用代码"),
    SIGNATURE_ERROR_4011(4011, "暂无可删除的签章"),
    SIGNATURE_ERROR_4012(4012, "只能删除自己的签章"),
    SIGNATURE_ERROR_4013(4013, "生成电子签章失败，请稍后重试"),
    SIGNATURE_ERROR_4014(4014, "请先联系销售维护营业执照名称"),

    //验证码异常码
    AUTH_CODE_ERROR_5001(5001, "验证码已发送，请不要频繁点击"),
    AUTH_CODE_ERROR_5002(5002, "验证码发送失败，请稍后重新发送"),
    AUTH_CODE_ERROR_5003(5003, "验证码验证失败，请稍后重试"),

    AUTH_CODE_ERROR_5004(5004, "验证码已发送,请查收"),
    AUTH_CODE_ERROR_5005(5005, "验证码已失效,请重新获取"),
    AUTH_CODE_ERROR_5006(5006, "验证码错误"),
    AUTH_CODE_ERROR_5007(5007, "验证码校验成功"),
    AUTH_CODE_ERROR_5008(5008, "订单已超时,请重新下单"),
    AUTH_CODE_ERROR_5009(5009, "此笔订单尚未发送过验证码"),
    AUTH_CODE_ERROR_5010(5010, "发送过于频繁,请稍后再试"),
    AUTH_CODE_ERROR_5011(5011, "订单校验成功"),

    GOODS_NUM_CHECK(2005, "每个商品的数量应该在1到99999范围内!"),
    GOODS_KING_CHECK(2006, "套餐内商品种类应该在2到6之间!"),
    GOODS_IS_ALONE_SALE_CHECK(2007, "套餐内至少包含一个不可单独售卖商品!"),
    PACKAGE_VALID_CHECK(2008, "该客户下已创建五个有效套餐!"),
    SKUID_SKUNAME_CHECK(2009, "ssuId和sku名称不能同时为空!"),
    GROUPID_GROUPNAME_CHECK(3002, "客户id和客户名称不能同时为空!"),
    VALID_PACKAGE_CHECK(3003, "此时商品都是可单独售卖的商品!"),
    SSUID_SAME_CHECK(3004, "此时套餐中存在相同的商品!"),

    RPC_SERVICE_ERROR(3001, "RPC服务调用错误！");

    private int enumValue;

    private String enumName;

    private ResultCodeEnum(int enumValue, String enumName) {
        this.enumValue = enumValue;
        this.enumName = enumName;
    }

    public int getEnumValue() {
        return enumValue;
    }

    public String getEnumName() {
        return enumName;
    }
}
