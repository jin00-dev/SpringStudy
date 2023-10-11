package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController1 {
	
	
	// mylog 단축키 만들었음. notion에서 확인 가능! 
	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);
	// 이 클래스에서 발생하는 정보를 로그로 출력하는 객체 
	// 로그를 출력한다? 
	// 이제 System.out.println(); 안쓸거야... 

	//http://localhost:8088/web/doA
	// GET 방식으로 /doA 주소를 호출 했을 때 실행하는 메서드 
	@RequestMapping("/doA")
	public void doA() { //메서드 void 일때 사용 되는!!?? 알아서 찾아가요
		logger.info("doA()호출@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"); // System.out.println -> 이제 안쓴다!!! logger쓴다.
		// 컨트롤러의 메서드 리턴타입이 void 일때 자동으로 주소이름.jsp 페이지로 이동하게 된다. 
		// 페이지 이동까지 다 된것..! 
		// 페이지 이동 /WEB-INF/views/doA.jsp
		logger.info("로그출력 ");
		logger.debug("로그출력 2 ");
	
	}
	

	
}
