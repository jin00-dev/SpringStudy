package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	// http://localhost:8088/web/doD
	@RequestMapping(value = "/doD", method = RequestMethod.GET)
	public String doD(Model model, RedirectAttributes rttr) {
		// Model 아무곳이나 다 사용 가능한~  RedirectAttributes redirect 할때만 사용 가능~!!
		logger.debug("doD() 호출");
		
		logger.debug("/doE.jsp 페이지로 이동(view 설정) /doE호출X");
		// return "/doE"; D는 E를 호출할 수 없다. View만 연결 된다. 
		// 가상주소는 다를 수 있으나 View는 같이 쓸 수 있다. 
		// 목적지는 같지만 실행하는 것은 다를 수 있다.
		logger.debug("/doE 주소로 이동 redirect");
		//response.sendRedirect(); 언제썼어요? 회원가입 다 하고 로그인 페이지로 갈 떄 / 주소 바꾸면서 화면도 바꿀때 
		//return "redirect:/doE"; // => 주소 변경O (가상주소 -> 가상주소), 화면 변경 가능
		//redirect로 전달 할 수 있는 영역객체 (session, application)
		//return "forward:/doE"; // 주소변경 X(가상주소 -> 실제주소), 프레임워크에서는 실행 할 일 없음... 자동 매핑해서!
		// BUT 화면 변경 O,영역객체 (session, application,request) 가능한것만 알고 있기

		String dbValue = "DB Value!!";
		model.addAttribute("msg", dbValue);
		
		rttr.addFlashAttribute("msg2", "msgmsg2"); // RedirectAttributes에서 사용 가능한 고유한 기능
		// Flash Memory => 일회성 메모리 / FlashAttribute 잠깐 기억하는..? 새로고침하면 사라짐 
		// view 페이지로 정보 전달/ 메서드 통해서 가기 때문에 다른 주소로 정보 전달할 때 사용 가능 *redirect 할 때만* 
		
		// Q. doD -> doE 이동시 msg="hello" 정보 전달 후 doE메서드에서 정보 받아서 출력
//		return "redirect:/doE?msg=hello"; // 파라메터 전달 후 doE에서 ModelAttribute로 전달 후 logger로 출력
//		return "redirect:/doE?"+dbValue; // 가능한~ 
		// BUT Model 만들어서 전달할 것..! 
		
		return "redirect:/doE"; 
	}
	// http://localhost:8088/web/doE
	@RequestMapping(value = "/doE", method = RequestMethod.GET)
	public void doE(@ModelAttribute("msg") String msg,
					@ModelAttribute("msg2") String msg2) {
		
		logger.debug("doE() 호출");
		
		logger.debug("msg : " + msg);
		logger.debug("msg2 : " + msg2);
	}
	
}


