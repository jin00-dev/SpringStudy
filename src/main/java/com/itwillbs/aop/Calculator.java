package com.itwillbs.aop;

// 계산기 => 받아서 결과만 보게 하는 것~? = Target 클래스  
public class Calculator {

	public void add(int a, int b) {
		System.out.println("결과 : " + (a + b));
	}
	
}
