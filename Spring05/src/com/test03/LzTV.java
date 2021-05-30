package com.test03;

import org.springframework.stereotype.Component;

// @Component는 <bean id="lzTV" class="com.test03.LzTV" />와 같음
@Component
public class LzTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("lz tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("lz tv power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("lz tv volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("lz tv volume down");
	}

}
