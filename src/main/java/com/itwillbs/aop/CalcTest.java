package com.itwillbs.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {

		//직접 불러온 것 
		Calculator c = new Calculator();
		
		c.add(200, 100);
		
		//AOP
		ApplicationContext CTX = new ClassPathXmlApplicationContext("AOPTest.xml");
		
		Calculator c2 = (Calculator) CTX.getBean("proxyCal"); // AOPTest.xml 쪽에서 불러온..? 
		c2.add(100, 200);
		
		
	}

}
