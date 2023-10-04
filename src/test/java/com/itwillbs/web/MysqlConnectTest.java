package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


public class MysqlConnectTest {

//	Test 어노테이션 - jUnit실행하는 어노테이션 
// 			=> Test 전용 라이브러리 (서버 사용하지 않고 실행/테스트를 진행 할 수 있게 해주는 것)
//			메서드 위에 붙여놓으면 Main 메서드 없이 바로 실행 가능 
	
//	@Befor => @Test 전에 실행하는 코드 
//	@After => @Test 실행 후에 실행하는 코드 
	
	/*
	 * @Test public void DB_connectTest() throws Exception { //DB 연결 Test //드라이버 로드
	 * Class.forName("com.mysql.cj.jdbc.Driver");
	 * 
	 * //DB 접속 Connection con = DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/jspdb?useSSL=false&serverTimezone=Asia/Seoul",
	 * "root", "1234");
	 * 
	 * System.out.println("DB접속 완료"); System.out.println(con);
	 * 
	 * }
	 */
	
	@Test	
	public void DB_connectTest(){
		try(Connection con =
				DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb?useSSL=false&serverTimezone=Asia/Seoul", "root", "1234")) {
			//DB 연결 Test
			//드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DB 접속 
			System.out.println("DB접속 완료");
			System.out.println(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
