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
	public String doC(/* @ModelAttribute  생략됨+주로 생략 함 */ MemberVO vo) { // 자동으로 저장 된 것..?!
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
		model.addAttribute("DBVO", DBVO);
		
		logger.debug("전달받은 정보를 view 페이지로 전달");
		logger.debug("view 페이지로 이동");
		
		return "itwill";
	}
	
	
	
} //SampleController3
