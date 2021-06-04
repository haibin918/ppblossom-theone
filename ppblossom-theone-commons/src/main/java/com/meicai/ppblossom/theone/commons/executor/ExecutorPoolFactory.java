package com.meicai.ppblossom.theone.commons.executor;

import com.meicai.ppblossom.theone.commons.enums.ExecuteTypeEnum;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池
 */
@Component
public class ExecutorPoolFactory {

    private Map<String,ThreadPoolExecutor> executorMap = new ConcurrentHashMap<>();
    //锁
    private Lock lock = new ReentrantLock();
    /**
     * 线程池入口
     * @param executeType
     * @return
     */
    public ThreadPoolExecutor getExecutor(ExecuteTypeEnum executeType) {
        ThreadPoolExecutor executor = this.executorMap.get(executeType.getType());
        if (null == executor) {
            executor = this.initExecutor(executeType.getType(),executeType.getCoreThreadNumber(),executeType.getMaxThreadNumber(),executeType.getCapacity(),new ThreadPoolExecutor.AbortPolicy());
        }
        return executor;
    }

    /**
     * 线程池入口
     * @param executeType
     * @param handler
     * @return
     */
    public ThreadPoolExecutor getExecutor(ExecuteTypeEnum executeType,RejectedExecutionHandler handler) {
        ThreadPoolExecutor executor = this.executorMap.get(executeType.getType());
        if (null == executor) {
            executor = this.initExecutor(executeType.getType(),executeType.getCoreThreadNumber(),executeType.getMaxThreadNumber(),executeType.getCapacity(),handler);
        }
        return executor;
    }
    /**
     * 获取线程池
     * @param type
     * @param coreThreadNum
     * @param maxThreadNumber
     * @param capacity
     * @return
     */
    private ThreadPoolExecutor initExecutor(String type,int coreThreadNum,int maxThreadNumber,int capacity,RejectedExecutionHandler handler) {
        ThreadPoolExecutor executor;
        try {
            this.lock.lock();
            executor = this.executorMap.get(type);
            if(null == executor) {
                executor = new ThreadPoolExecutor(coreThreadNum,maxThreadNumber,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(capacity),handler);
                this.executorMap.put(type, executor);
            }
        } finally {
            this.lock.unlock();
        }
        return executor;
    }
}
