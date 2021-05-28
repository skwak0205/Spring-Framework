package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		// MessageBean Null = new MessageBean(); - 사용 측에서 객체 생성하여 사용 (예전)
		MessageBean Null = (MessageBean) factory.getBean("null");
		Null.sayHello();
		
		MessageBean apple = (MessageBean) factory.getBean("apple");
		apple.sayHello();
		
		MessageBean mango = (MessageBean) factory.getBean("mango");
		mango.sayHello();
		
		MessageBean banana = (MessageBean) factory.getBean("banana");
		banana.sayHello();
	}
}
