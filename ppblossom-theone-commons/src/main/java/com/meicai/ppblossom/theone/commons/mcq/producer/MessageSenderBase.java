//package com.meicai.ppblossom.theone.commons.mcq.producer;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.rocketmq.client.exception.MQBrokerException;
//import com.alibaba.rocketmq.client.exception.MQClientException;
//import com.alibaba.rocketmq.client.producer.SendResult;
//import com.alibaba.rocketmq.client.producer.SendStatus;
//import com.alibaba.rocketmq.common.message.Message;
//import com.alibaba.rocketmq.remoting.exception.RemotingException;
//import com.meicai.ppblossom.theone.commons.constants.McqConstants;
//import com.meicai.ppblossom.theone.commons.exception.InvalidParamException;
//import com.sprucetec.mcq.producer.Producer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.annotation.Resource;
//import java.io.UnsupportedEncodingException;
//
//public abstract class MessageSenderBase<T, ID> {
//
//    private static final Logger logger = LoggerFactory.getLogger(MessageSenderBase.class);
//
//    @Resource
//    private Producer producer;
//
//    public boolean send(String topic, String tag, ID id, T object) {
//
//        if (id == null)
//            throw new InvalidParamException(
//                    String.format("[%s]Send message error: %s, message: %s", getName(), "InvalidParamException", "id is null"));
//
//        Message message = null;
//        SendResult sendResult = null;
//        try {
//            String msgId = new String(id.toString());
//            message = new Message(topic, tag, msgId, JSON.toJSONString(object).getBytes(McqConstants.UTF_8));
//            sendResult = producer.send(message);
//            logger.info(String.format("[%s]Send message status: %s, message: %s", getName(), sendResult.getSendStatus(), message));
//        } catch (UnsupportedEncodingException e) {
//            logger.error(String.format("[%s]Send message error: %s, message: %s，errorMessage: %s ", getName(), "UnsupportedEncodingException", message, e.getMessage()), e);
//        } catch (MQClientException e) {
//            logger.error(String.format("[%s]Send message error: %s, message: %s，errorMessage: %s ", getName(), "MQClientException", message, e.getMessage()), e);
//        } catch (RemotingException e) {
//            logger.error(String.format("[%s]Send message error: %s, message: %s，errorMessage: %s ", getName(), "RemotingException", message, e.getMessage()), e);
//        } catch (MQBrokerException e) {
//            logger.error(String.format("[%s]Send message error: %s, message: %s，errorMessage: %s ", getName(), "MQBrokerException", message, e.getMessage()), e);
//        } catch (InterruptedException e) {
//            logger.error(String.format("[%s]Send message error: %s, message: %s，errorMessage: %s ", getName(), "InterruptedException", message, e.getMessage()), e);
//        }
//        return sendResult.getSendStatus().compareTo(SendStatus.SEND_OK) == 0;
//    }
//
//    protected abstract String getName();
//
//}
