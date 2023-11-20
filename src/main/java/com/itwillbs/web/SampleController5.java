package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController5 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController5.class);
	
	
	// http://localhost:8088/web/doF
	// jackson-databind 라이브러리 추가 (기존에 안되던 기본형 데이터 타입이 들어갈 수 있게 함...?)
	// @ResponseBody 있으면 json으로 데이터 받아온다...? 
	@RequestMapping(value = "/doF", method = RequestMethod.GET)
	public @ResponseBody int doF() {
		logger.debug("doF() 호출");
		return 1000;
	}
	
	// http://localhost:8088/web/doF1?userid=admin&userpw=1234
	@RequestMapping(value = "/doF1", method = RequestMethod.GET)
	public @ResponseBody MemberVO doF1(MemberVO vo) {
		logger.debug("doF1() 호출");
		
		return vo;
	}
	// 우리는 컨트롤러를 통해서 조금 더 쉽게 json 데이터를 받아올 수 있다. 
	
	
}//SampleController5
