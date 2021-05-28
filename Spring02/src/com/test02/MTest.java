package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		// bean으로 등록된 2명 출력
		Address hong = (Address) factory.getBean("hong"); // 어떤 타입의 객체와 연결되어 있는 지 모름 / object 타입으로 리턴됨
		System.out.println(hong);
		
		Address kim = (Address) factory.getBean("kim");
		System.out.println(kim);
	}
}
