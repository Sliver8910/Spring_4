package com.ruda.s4.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public void car() {
		System.out.println("---- MyCar ----");
		System.out.println("---  운전하기  ---");
		System.out.println("---- MyCar ----");
		
	}
	
	
	public void taxi() {
		System.out.println("---- Taxi ----");
		System.out.println(" 기사님과  대화하기 ");
		System.out.println("---- Taxi ----");
	}
	
	public void getBus(String cardName) {
		System.out.println("---- Bus ----");
		System.out.println("--- 음악듣기 ---");
		System.out.println("---- Bus ----");
	}
	
	public void getSubway(String cardName) {
		System.out.println("---- Subway ----");
		System.out.println("--- 핸드폰 보기 ---");
		System.out.println("---- Subway ----");
	}

}
