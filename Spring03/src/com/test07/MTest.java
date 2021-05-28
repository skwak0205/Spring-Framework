package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		
		/* 결과가
		 * samsong tv 생성!!!
		 * lz tv 생성!!!!
		 * 인 이유
		 * 
		 * 위에서 객체 생성이 이미 되어 있어서
		 * lazy-init='true' 속성을 붙이면 
		 * samsong tv 생성이 안됨
		 */
		
		
		
		TV lz = factory.getBean("lz", TV.class);
		lz.powerOn();
		lz.powerOff();
		lz.volumeUp();
		lz.volumeDown();
		
		TV samsong = factory.getBean("samsong", TV.class);
		samsong.powerOn();
	}
}
