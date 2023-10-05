package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

// @Repository: 스프링이 해당 객체를 DAO로 인식하도록 하는 어노테이션 

@Repository
public class MemberDAOImpl implements MemberDAO{

	// 디비 연결 객체 정보를 주입 받아오겠습니다.
	@Inject 
	private SqlSessionFactory sqlFactory;
	// => 디비 연결정보만 가지고 있음 (연결은 수동으로 해야 함)
	
	@Inject
	private SqlSession sqlsession;
	// => 디비 연결정보 있음 (연결, 해제 자동) 
	
	//memberMapper의 namespace 정보 저장 
	private static final String NAMESPACE
		= "com.itwillbs.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		// 디비 연결
		SqlSession SqlSession = sqlFactory.openSession(); // connection 같은거.../ 수동으로 연결 한 것 
		// sql 작성 + pstmt 객체
		// sql 실행 
		String  time = SqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		
		return time;
	}


	@Override
	public void insertMember(MemberVO vo) {
		// 디비연결 - sqlSession 으로 완료 
		//sql 작성 (mapper에 가서) - memberMapper로 가면 있음
		//sql 실행 (mapper 호출) 
		//sqlsession.insert(sql 구문)
		//sqlsession.insert(sql구문, sql 전달 할 구문)
		sqlsession.insert(NAMESPACE + ".insertMember", vo);
		
	}


	@Override
	public MemberVO loginMember(MemberVO loginVO) {
		
		System.out.println("DAOImpl : loginMember() 실행");
		System.out.println("DAOImpl : 해당 sql구문 실행");
		
		MemberVO resultVO = sqlsession.selectOne(NAMESPACE + ".loginMember", loginVO);
		
		System.out.println("DAOImpl : 결과"+ resultVO);
		return resultVO;
	}

	

	
}//DAOImpl
