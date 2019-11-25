package com.ruda.s4.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Card {
	
	public void cash() {
		System.out.println("==== 현금 내기 ====");
	}
	
	
	public Object cardCheck(ProceedingJoinPoint join) {  //ProceedingJoinPoint은 메서드를 말함(ex. getBus, getSubway)
		System.out.println("=== 승차 전 카드찍기 ====");
		Object obj = null;
		
		try {
			Object [] args = join.getArgs();
			for(Object object:args) 
			System.out.println(object);{}
			obj = join.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("=== 승차 후 카드찍기 ====");
		return obj;
	}


}
