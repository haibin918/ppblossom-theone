package com.meicai.ppblossom.theone.infrastructure.interceptors;

import com.alibaba.dubbo.rpc.*;

import com.meicai.ppblossom.theone.commons.constants.BasicConstants;
import com.meicai.ppblossom.theone.commons.utils.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

/**
 * @Author: guohaibin
 * @Date: 2020/6/4
 * @Version 1.0
 */
@Slf4j
public class DubboProviderTraceFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = RpcContext.getContext().getAttachment(BasicConstants.traceId);
        if (!StringUtils.isEmpty(traceId)) {
            MDC.put(BasicConstants.traceId, traceId);
        }
        Result result = invoker.invoke(invocation);
        log.info("dubbo provider req:{}.resp:{}", JacksonUtil.obj2Str(invocation.getArguments()), JacksonUtil.obj2Str(result.getValue()));
        return result;
    }
}
