package com.itwillbs.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)

public class DataSourceTest {
	
	// 디비 연결 정보 필요함 = 의존관계 
	// DataSourceTest와 디비 연결 정보간의 의존관계 
	// root-context.xml에 있는 DataSource 객체 정보를 가져오겠다(의존성 주입) 
//	@Inject
	@Autowired
	private DataSource ds; 
	
	@Test
	public void ds연결테스트() {
//		System.out.println("테스트 실행");
		System.out.println(ds);
		try {
			Connection con = ds.getConnection();
			System.out.println("디비연결성공");
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
