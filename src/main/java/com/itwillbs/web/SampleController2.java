package com.itwillbs.web;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController2 {

	// mylog
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	//http://localhost:8088/web/doB
	
	@RequestMapping("/doB")
	public int doB() { // return 이 int!!! 할 수 없어요... 지금은 기본 형 타입 리턴 불가 
		
		logger.debug("doB() 호출 - int 리턴 불가");		
		
		return 0; 
	}

	//http://localhost:8088/web/doB1
	// ** 컨트롤러의 메서드 리턴 타입이 String 일때 리턴 문자.jsp 페이지로 이동 = 문자를 바꾸면 다른 jsp로 연결 가능
	// 이동하는 View 페이지를 연결 하는 방법을 Void와 String 으로 나눌 수 있다 
	// 주소 = View 페이지 같을때 Void 사용, 주소!= View 페이지 다를때 String 사용 
//	@RequestMapping("/doB1") 안적어도 디폴트 Get..!! 
//	@RequestMapping(value = "매핑주소", method = "전달방식(GET, POST)")
//	@RequestMapping(value = "/doB1", method = RequestMethod.GET) 하지만 우리는 이걸 쓸거에요 
//	스프링 4.3 이후 가능 
	@GetMapping(value = "/doB1") // RequestMapping을 GET 방식으로 할거 라는 의미~!
	public String doB1() {  
		
		logger.debug("doB1() 호출");		
		
		return "ITWILL"; 
	}
	
	//http://localhost:8088/web/doB2
	//http://localhost:8088/web/doB2?id=admin
	
//	@ModelAttribute : 자동으로 파라메터 수집 + 자동으로 request.setAttribute를 수행 
//                    => 컨트롤러에 생성된 정보 (파라메터로 전달 받은 정보) 를 뷰 페이지에 자동 전달
	@RequestMapping(value = "/doB2", method = RequestMethod.GET)
	public String doB2(@ModelAttribute("id") String id) {
		logger.debug("doB2() - get 방식 호출");
		
		
		logger.debug("전달정보(파라메터) id : " + id); // request,response 없음 
		
		logger.debug("WEB-INF/views/itwill.jsp 페이지로 이동");
		return "itwill"; 
	}// void 일때도 똑같이 정보 전달 가능하다
	
	//http://localhost:8088/web/doB3?id=admin&pass=1234
	// => itwill.jsp 뷰 페이지에 사용자의 정보 (id,pass) 출력
	
	@RequestMapping(value = "/doB3", method = RequestMethod.GET)
	public String doB3(@ModelAttribute("id") String id, @ModelAttribute("pass") String pass) {
		logger.debug("doB3() - get 방식 호출");

		logger.debug("id, pass 정보 저장 -> view페이지로 전달");
		logger.debug("iwill.jsp 페이지로 이동");

		return "itwill";
	}
	
	//http://localhost:8088/web/doB4?id=admin&pass=1234
	// view 에서 parm 또는 requestgetParameter 만 보여 => @RequestParam = request.getParameter() 역할 수행 
	@RequestMapping(value = "/doB4", method = RequestMethod.GET)
	public String doB4(@RequestParam("id") String id,
					   @RequestParam("pass") String pass) {
		logger.debug("doB4() - get 방식 호출");

		logger.debug("id : "+ id);
		logger.debug("pass : "+ pass);
		
		logger.debug("iwill.jsp 페이지로 이동");
		return "itwill";
	}
	
	//http://localhost:8088/web/doB5?ids=admin&ids=itwill
	// 체크박스 눌러서 보낼 때 이렇게 데이터가 갔어요
	@RequestMapping(value = "/doB5", method = RequestMethod.GET)
	public String doB5(@RequestParam("ids") /*String[]*/ ArrayList ids) { // 일반 배열, ArrayList 모두 가능
		logger.debug("doB5() - get 방식 호출");

//		logger.debug("ids : " + ids[0]);
//		logger.debug("ids : " + ids[1]); 일반 배열 출력
		logger.debug("ids : " + ids);
		logger.debug("ids : " + ids.get(0)); // ArrayList 출력

		logger.debug("iwill.jsp 페이지로 이동");
		return "itwill";
	}
	
	
	
	
	
	
}//SampleController2
