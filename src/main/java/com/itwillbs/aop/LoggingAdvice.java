package com.itwillbs.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// 어드바이스 (보조기능) 
public class LoggingAdvice implements MethodInterceptor {

	//MethodInterceptor? => 메서드를 가로채는..! 왜? 대신 다른거 하려고 
	// 계산하는 동안 다른거 해줄게~! 
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("LoggingAdvice(보조기능) 실행!");
		System.out.println(invocation.getMethod() + "실행"); // 뺏어온 메서드 이름 + 실행
		
		// 주 기능 호출 - 계산기 기능 호출 
		Object obj = invocation.proceed(); 
		
		System.out.println("주 기능 실행 완료");
		System.out.println(invocation.getMethod() + "끝");
		System.out.println("LoggingAdvice(보조기능) 끝!");
		
		return obj;
	}

	
}
