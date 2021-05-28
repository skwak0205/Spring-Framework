package com.test06;

public class BeanFactory {
	Object getBean(String name) {
		if (name.equals("samsong")) {
			return new SamsongTv();
		} else if (name.equals("lz")) {
			return new LzTV();
		}
		
		return null;
	}
}
