package com.meicai.ppblossom.theone.commons.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SystemConstants
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/12 18:04
 * @Version 1.0
 **/
public class SystemConstants {

    public static final String SYSTEM_NAME = "ppblossom-theone";

    public static final Integer SYSTEM_CHANNEL = 1;//大客户渠道 1

    //短信配置
    public static final String SMS_APP_KEY = "aYsU2SoA7f2aNr09"; //短信系统APP KEY
    public static final String SMS_TEMPLATE = "DMALL_COMMON_MESSAGE"; //短信模板

    // 协议审核类型 审核类型 1创建审核 2编辑审核
    public static final Integer APPOINT_VERIFY_TYPE_ONE = 1;
    public static final Integer APPOINT_VERIFY_TYPE_TWO = 2;

    // 审核状态 1待审核 2 通过  3 审核不通过
    public static final Integer VERIFY_STATUS_ONE = 1;
    public static final Integer VERIFY_STATUS_TWO = 2;
    public static final Integer VERIFY_STATUS_THREE = 3;


    // 协议状态 1待生效 2生效中 3已过期 4 作废
    public static final Integer APPOINT_STATUE_ONE = 1;
    public static final Integer APPOINT_STATUE_TWO = 2;
    public static final Integer APPOINT_STATUE_THREE = 3;
    public static final Integer APPOINT_STATUE_FOUR = 4;


    // 审核内容 1,全部-未驳回  2,全部-驳回
    public static final String VERIFY_CONTENT_ONE = "1,全部-未驳回";
    public static final String VERIFY_CONTENT_TWO = "2,全部-驳回";

    // 纳税人类型1:一般纳税人 2:小规模 taxpayerType
    public static final Integer TAXPAYER_TYPE_ONE  = 1;
    public static final Integer TAXPAYER_TYPE_TWO  = 2;

    // 发票种类 1 专票 2 普票
    public static final Integer INVOICE_TYPE_ONE  = 1;
    public static final Integer INVOICE_TYPE_TWO  = 2;

    // 是否接受零税点 1 接受 2 不接受
    public static final Integer IS_ACCEPT_ZERO_TAX  = 1;
    public static final Integer NOT_ACCEPT_ZERO_TAX = 2;


    //宁波瓜瓜农业科技有限公司和北京瓜瓜农业科技有限公司的统一信用代码map
    public static final Map<String, String> COMPANY_RECODE_MAP = new HashMap<String, String>(){
        {
            put("宁波瓜瓜农业科技有限公司", "91330200MA282H486E");
            put("北京瓜瓜农业科技有限公司", "91110108358351964G");
        }
    };
}
