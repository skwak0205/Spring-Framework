package com.test06;

public class SamsongTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("samsong tv power on");
	}

	@Override
	public void powerDown() {
		System.out.println("samsong tv power down");
	}

	@Override
	public void volumeUp() {
		System.out.println("samsong tv volume up");
	}

	@Override
	public void volumeDown() {
		System.out.println("samsong tv volume down");
	}

}
