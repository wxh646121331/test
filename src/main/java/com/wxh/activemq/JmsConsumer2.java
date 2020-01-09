package com.wxh.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.io.IOException;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/12/31
 * @time: 上午9:51
 */
public class JmsConsumer2 {
    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    public static final String QUEUE_NAME = "my_queue";
    public static void main(String[] args) throws JMSException {
        System.out.println("我是2号消息者");
    // 1 创建连接工场，按照给定的url地址，采用默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 2 通过连接工场，获得连接connection并启动
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 3 创建会话session，两个参数：事务和签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4 创建目的地（队列或主题）
        Queue queue = session.createQueue(QUEUE_NAME);
        // 5 创建消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);
        /**
         * 同步阻塞方式消费消息
        while (true){
//            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            TextMessage textMessage = (TextMessage) messageConsumer.receive(3000L);
            if(null != textMessage){
                System.out.println("消费内容：" + textMessage);
            }else {
                break;
            }
        }
        messageConsumer.close();
        session.close();
        connection.close();
         */

        /**
         * 通过监听的方式消费消息
         */

        messageConsumer.setMessageListener((x) ->{
            if(null != x && x instanceof TextMessage){
                TextMessage textMessage = (TextMessage) x;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
