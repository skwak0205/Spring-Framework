package com.test01;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		// xml 파일을 읽어서 bean 객체를 생성하여 가지고 있는 ApplicationContext 객체(Spring Container)를 생성
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		Date today = (Date)factory.getBean("today");
		System.out.println(today);
		
		Date start = (Date)factory.getBean("start");
		System.out.println(start);
		
		// 객체 생성 할 때 생성자 호출도 발생
		// 그래서 생성자 호출이 먼저 결과로 뜸
		BeanTest bean = (BeanTest)factory.getBean("beanTest");
	}
}
