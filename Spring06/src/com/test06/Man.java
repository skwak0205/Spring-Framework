package com.test06;

import org.springframework.stereotype.Component;

@Component
public class Man implements Person {

	@Override
	public void classWork() {
		System.out.println("컴퓨터 켜서 유튜브 본다.");
	}

}
