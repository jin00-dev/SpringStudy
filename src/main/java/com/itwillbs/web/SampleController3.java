package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController3 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);

	// http://localhost:8088/web/doC
	// http://localhost:8088/web/doC?userid=admin&userpw=1234&username=관리자 
	// 도메인 객체에 해당하는 파라메터 정보가 있는 경우 자동으로 파라메터 수집
	// 파라메터 수집 = request.getParameter() + vo.setUserXXX() 
	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public String doC(/* @ModelAttribute  생략됨+주로 생략 함 + 이름이 설정X*/ MemberVO vo) { // 자동으로 저장 된 것..?!
		logger.debug("doC() 호출");						//VO 객체만 생략 하고 다른 것은 써줘야 해!!
		
		logger.debug(""+vo); 
		// VO에 있는 것은 자동으로 VO로 받아와지고, 없는 것은 이전에 했던 방식 @~~String ~~ 으로 
		
		logger.debug("전달받은 정보를 view 페이지로 전달");
		logger.debug("view 페이지로 이동");
		
		return "itwill";
	}
	
	// http://localhost:8088/web/doC1?userid=admin&userpw=1234
	@RequestMapping(value = "/doC1", method = RequestMethod.GET)
	public String doC1(MemberVO vo, Model model) { 
		logger.debug("doC1() 호출");
		logger.debug(""+vo); 

		// DB에서 전달 된 객체 정보 
		MemberVO DBVO = new MemberVO();
		DBVO.setUserid("DB ID");
		DBVO.setUserpw("DB PW");
		
		//모델 객체에 정보를 저장 
//		model.addAttribute("DBVO", DBVO); 이름이 있음,  매개변수 2개, 직관적 + 코드 짠 사람만 알아요 
		//model.addAttribute(DBVO);  이름이 없음, 매개변수 1개 => ${DBVO} 데이터 출력 안됨... ${memberVO}하면 출력 됨 
		// 왜...? 이름 없이 보내면 memberVO가 이름이 된다...? 
		//model.addAttribute(DBVO); => 이름의 정보가 없는 경우 이름의 정보를 자동으로 설정한다. 
		// 이름 저장 안하는걸 주로 쓴다. 왜? 협업시 전달되는 이름을 몰라도 접근 가능(이름이 항상 같음) 코드 통일!
		// 단점은 파라메터 정보와 DB정보를 동시에 보낼 시 덮어쓰기 됨 -> 파라메터 @ModelAttribute 또는 DB데이터에 이름 설정 
		// BUT 주로 파라메터 쪽에 이름 지정해서 보내요 BUT 특수케이스~ 
		// 어떻게? => 전달되는 데이터 타입(DBVO의 타입 MemberVO)의 첫글자를 소문자로 변경(memberVO)해서 이름으로 사용한다.
		model.addAttribute("DBVO", DBVO);
		
		logger.debug("전달받은 정보를 view 페이지로 전달");
		logger.debug("view 페이지로 이동");
		
		return "itwill";
	}
	
	
	
} //SampleController3
