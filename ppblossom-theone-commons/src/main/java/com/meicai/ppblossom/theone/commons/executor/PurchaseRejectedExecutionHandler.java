package com.meicai.ppblossom.theone.commons.executor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义拒绝策略
 */
public class PurchaseRejectedExecutionHandler implements RejectedExecutionHandler {
    /**
     * 具体实现
     * @param r
     * @param executor
     */
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            //自定义拒绝策略，线程任务队列满了的情况下，任务等待入线程队列
            executor.getQueue().put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
