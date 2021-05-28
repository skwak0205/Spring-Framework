package com.test06;

public class LzTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("lz tv power on");
	}

	@Override
	public void powerDown() {
		System.out.println("lz tv power down");
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
