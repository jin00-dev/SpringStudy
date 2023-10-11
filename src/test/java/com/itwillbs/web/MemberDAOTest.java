package com.itwillbs.web;

import java.util.List;

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

//	@Test
	public void DAO_객체테스트() {
		System.out.println("dao 객체정보" + mdao);
	}
	
//	@Test
	public void 디비시간정보_조회() {
		System.out.println("시간정보 : " + mdao.getTime()); 
	}
	
//	@Test
	public void 회원가입_테스트() {
		
		MemberVO vo = new MemberVO();
		vo.setUserid("Test5");
		vo.setUserpw("1234");
		vo.setUsername("테스트5");
		vo.setUseremail("email@email");
		// 임시 유저정보 생성 
		// 실제 작업시에는 사용자 입력으로 처리 할 것
		
		mdao.insertMember(vo);
		
	}
	
//	@Test
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
//	@Test
	public void 로그인_테스트2() {
		System.out.println("로그인 테스트2 시작");
		
		
		// 로그인 체크 메서드(DAOImpl)
		MemberVO vo = mdao.loginMember("admin","1234");
		
		if(vo == null) {
			System.out.println("로그인 실패");
		}else {
			System.out.println("로그인 성공");
		}
		
		System.out.println("로그인 테스트2 끝");
	}
	
//	@Test
	public void 회원정보조회_테스트() {
		System.out.println("T : 회원정보 조회시작");
		
		String sessionUserid = "admin"; // 테스트용, 진짜 세션 X 이름만 session~~ 
		
		MemberVO vo = mdao.getMember(sessionUserid);
		
		System.out.println("T : " + vo);
		
		
		System.out.println("T : 회원정보 조회끝");
	}
	
//	@Test
	public void 회원정보_수정_테스트() {
		//id = admin pw = 1234 사용자 정보 수정 => name을 '아이티윌 관리자'로 변경 + updatedate 변경
		System.out.println("회원정보 수정 시작");
		MemberVO changeVO = new MemberVO();
		changeVO.setUserid("admin");
		changeVO.setUserpw("1234");
		changeVO.setUsername("아이티윌 관리자");
		
		mdao.changeMember(changeVO);
		
		System.out.println("회원정보 수정 끝");
	}
	
//	@Test
	public void 회원정보_삭제_테스트() {
		//id=admin pw=1234 회원정보 삭제 
		// 아이디 비밀번호 같을 때 삭제 -> 회원탈퇴 완료
		// 다른경우 삭제 X => 회원정보 오류로 인한 탈퇴실패
		
		MemberVO delVO = new MemberVO();
		delVO.setUserid("admin");
		delVO.setUserpw("1234");
		
		int result = mdao.deleteMember(delVO);
		
		if(result == 1) {
			System.out.println("회원탈퇴 완료");
		}else {
			System.out.println("회원정보 오류로 인한 탈퇴실패");
		}
	}
	
	@Test
	public void 회원목록조회_테스트() {
		System.out.println("T : 목록조회");
		
		// 콘솔창에 회원 정보 출력 
		List<MemberVO> memberList = mdao.getMemberList();
		
		System.out.println(memberList);
		
	}
	
	
	
	
	
}// MemberDAOTest
