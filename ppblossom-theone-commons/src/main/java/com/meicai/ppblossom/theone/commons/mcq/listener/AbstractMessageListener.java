//package com.meicai.ppblossom.theone.commons.mcq.listener;
//
//import com.alibaba.rocketmq.common.message.MessageExt;
//
//import com.meicai.ppblossom.theone.commons.constants.McqConstants;
//import com.sprucetec.mcq.consumer.MessageListener;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.UnsupportedEncodingException;
//import java.util.List;
//
///**
// * 监听器基础类
// */
//public abstract class AbstractMessageListener implements MessageListener {
//
//    private static final Logger logger = LoggerFactory.getLogger(AbstractMessageListener.class);
//
//    protected abstract String getName();
//
//    @Override
//    public void onMessage(List<MessageExt> messages) throws Exception {
//
//        logger.info(String.format("[%s]Receive message start", getName()));
//
//        for (MessageExt message : messages) {
//
//            execute(message);
//        }
//
//        logger.info(String.format("[%s]Receive message end", getName()));
//    }
//
//    public String transform(MessageExt message) throws UnsupportedEncodingException {
//        logger.info(String.format("[%s]Receive message %s", getName(), message));
//
//        String jsonStr = new String(message.getBody(), McqConstants.UTF_8);
//        logger.info(String.format("[%s]Receive message json string %s", getName(), jsonStr));
//
//
//        return jsonStr;
//    }
//
//    public abstract void execute(MessageExt message) throws Exception;
//}
