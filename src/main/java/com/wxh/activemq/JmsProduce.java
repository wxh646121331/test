//package com.wxh.activemq;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//
//import javax.jms.Connection;
//import javax.jms.JMSException;
//import javax.jms.MessageProducer;
//import javax.jms.Queue;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//
///**
// * @description:
// * @author: wuxinhong
// * @date: 2019/12/31
// * @time: 上午9:27
// */
//public class JmsProduce {
//    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
//    public static final String QUEUE_NAME = "my_queue";
//    public static void main(String[] args) throws JMSException {
//        // 1 创建连接工场，按照给定的url地址，采用默认用户名和密码
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
//        // 2 通过连接工场，获得连接connection并启动
//        Connection connection = activeMQConnectionFactory.createConnection();
//        connection.start();
//        // 3 创建会话session，两个参数：事务和签收
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        // 4 创建目的地（队列或主题）
//        Queue queue = session.createQueue(QUEUE_NAME);
//        // 5 创建消息生产者
//        MessageProducer messageProducer = session.createProducer(queue);
//        // 6 通过消息生产者生产消息发送到队列
//        for(int i=0; i<6; i++){
//            // 7 创建消息
//            TextMessage textMessage = session.createTextMessage("msg----------"+i);
//            // 8 发送消息
//            messageProducer.send(textMessage);
//        }
//        // 9 关闭资源
//        messageProducer.close();
//        session.close();
//        connection.close();
//        System.out.println("消息发送到MQ完成");
//    }
//}
