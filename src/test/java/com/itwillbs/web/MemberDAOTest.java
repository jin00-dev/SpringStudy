package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {

	// MemberDAO 객체가 필요함 => 객체를 주입 
	@Inject
	private MemberDAO mdao;

	@Test
	public void DAO_객체테스트() {
		System.out.println("dao 객체정보" + mdao);
	}
	
	@Test
	public void 디비시간정보_조회() {
		System.out.println("시간정보 : " + mdao.getTime()); 
	}
	
//	@Test
	public void 회원가입_테스트() {
		
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		vo.setUsername("관리자");
		vo.setUseremail("email@email");
		// 임시 유저정보 생성 
		// 실제 작업시에는 사용자 입력으로 처리 할 것
		
		mdao.insertMember(vo);
		
	}
	
	@Test
	public void 로그인_테스트() {
		System.out.println("로그인 테스트 시작");
			// 로그인 정보 
			MemberVO loginVO = new MemberVO();
			loginVO.setUserid("admin");
			loginVO.setUserpw("1234");
			
			// 로그인 체크 메서드(DAOImpl)
			MemberVO vo = mdao.loginMember(loginVO);
			
			if(vo == null) {
				System.out.println("로그인 실패");
			}else {
				System.out.println("로그인 성공");
			}
		
		System.out.println("로그인 테스트 끝");
	}
	
	
	
}// MemberDAOTest
