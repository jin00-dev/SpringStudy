package com.itwillbs.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MybatisTest {

	// 디비연결 (DataSource)테스트 완료
	// MyBatis를 사용해서 디비 연결
	
	//이미 생성된 객체를 주입 (의존관계 주입) 
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void sqlFactory_주입확인() {
		System.out.println(sqlFactory);
		System.out.println("의존 객체 주입 완료");
	}
	
	@Test
	public void sqlFactory_디비연결() {
		SqlSession sqlSession  = sqlFactory.openSession(); // 디비 연결 
		System.out.println("디비연결 성공");
		System.out.println(sqlSession);
	}
	
}
