package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(
//		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
//		)
// => 스프링 JUnit을 사용해서 테스트 하겠다.  / 컨트롤러 제외 나머지 테스트용 

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(
//		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
//		)
// => 스프링 MVC에서 JUnit 사용해서 테스트 하겠다. (=Web/Controller 테스트) 컨트롤러 테스트용 

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		)
public class ControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(ControllerTest.class);
	
	@Inject // 웹 애플리케이션 프로젝트 정보를 가져온다.
	private WebApplicationContext webAppCTX;
	// 웹 테스트를 처리 할 수 있는 객체 
	private MockMvc mockMvc;
	// 웹 테스트 도구 
	
//	@Before 테스트 수행 전에 무조건 실행하는 메서드 (준비작업) 
	@Before 
	public void setUP() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webAppCTX).build();
		logger.debug("setUP 완료. 테스트 객체 준비 완료");
	}
	
	@Test
	public void testDoA() throws Exception {
		logger.debug("testDoA() 호출");
		
		//SampleController1 - /doA 주소 호출
//		mockMvc.perform(MockMvcRequestBuilders.get("/doA")); // 요청정보 중 get 방식으로 /doA를 호출해라..?
		mockMvc.perform(MockMvcRequestBuilders.get("/doB1"));
	}

}//ControllerTest 
