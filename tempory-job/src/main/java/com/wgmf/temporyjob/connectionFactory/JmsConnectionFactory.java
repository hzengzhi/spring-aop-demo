package com.wgmf.temporyjob.connectionFactory;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsConnectionFactory {
	public static final String user = "system";
	public static final String password = "manager";
	public static final String url = "tcp://192.168.5.43:61616";
	public static final String queueName = "pointTemplateMsgQueue";
	// public static final String queueName = "memberMassMsgQueue";
	public static final String messageBody = "Hello JMS!";
	public static final boolean transacted = false;
	public static final boolean persistent = false;

	public static void main(String[] args) {
		JmsConnectionFactory.sendTojms(new ArrayList<String>(), "456");
	}

	public static void sendTojms(List<String> openids, String mediaId) {
		Connection connection = null;
		Session session = null;

		try {
			// create the connection
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			connection = connectionFactory.createConnection();
			connection.start();

			// create the session
			session = connection.createSession(transacted, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(queueName);

			// create the msg

			MapMessage mapMsg = session.createMapMessage();
			mapMsg.setString("templateType", "pointNotify");
			mapMsg.setString("openId", "oxIF2jnOGHOxbKgiwyzZ9Y6u2WBg");
			mapMsg.setString("first", "测试");
			mapMsg.setString("userPoint", "65");
			mapMsg.setString("notifyType", "dfsdf");
			mapMsg.setString("remark", "测试");
			mapMsg.setString("url",
					"http://wx.wgmf.com/wechat-html/html/cardTicket/cardTicket.html?cfrom=1&state=state");

		
			 

			// create the producer
			MessageProducer producer = session.createProducer(destination);
			producer.send(mapMsg);
			System.out.println("OK");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// close session and connection
				if (session != null) {
					session.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
