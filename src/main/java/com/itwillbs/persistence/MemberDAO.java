package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {

	// 디비 서버 시간정보 조회 기능 
	public String getTime();
	
	
	// 회원가입 기능 
	public void insertMember(MemberVO vo);
	
	//로그인 기능 
	public MemberVO loginMember(MemberVO loginVO);
	
	
	
	
	
	
}
