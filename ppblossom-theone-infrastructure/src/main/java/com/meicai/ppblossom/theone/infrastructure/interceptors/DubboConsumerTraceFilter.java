package com.meicai.ppblossom.theone.infrastructure.interceptors;


import com.alibaba.dubbo.rpc.*;
import com.meicai.ppblossom.theone.commons.constants.BasicConstants;
import com.meicai.ppblossom.theone.commons.utils.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @Author: guohaibin
 * @Date: 2020/6/4
 * @Version 1.0
 */
@Slf4j
public class DubboConsumerTraceFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = MDC.get(BasicConstants.traceId);
        if (StringUtils.isEmpty(traceId)) {
            traceId = UUID.randomUUID().toString();
            log.warn("dubbo invoke no trace,new create:{}", traceId);
        }

        RpcContext.getContext().setAttachment(BasicConstants.traceId, traceId);
        Result result = invoker.invoke(invocation);
        log.info("dubbo consumer req:{}.resp:{}", JacksonUtil.obj2Str(invocation.getArguments()), JacksonUtil.obj2Str(result.getValue()));
        return result;
    }
}
