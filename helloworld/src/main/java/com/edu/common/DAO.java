package com.edu.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAO {
	//Oracle DB 정보
	private String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	private String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private String connectedId = "hr";
	private String connectedPwd = "hr"; 
	
	//공통으로 사용되는 필드
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public DAO() {
		//dbConfig();
	}
	
	//DB에 접속하는 메소드 
	public void connect() {
		//dbConfig();
		try {
			// 1. JDBC Driver 로딩
			Class.forName(jdbcDriver);
			// 2. DB 서버 접속
			conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}

//	private void dbConfig() {
//		String resource = "config/db.properties";
//		Properties properties = new Properties();
//
//		try {
//			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
//			properties.load(new FileInputStream(filePath));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		jdbcDriver = properties.getProperty("driver");
//		oracleUrl = properties.getProperty("url");
//		connectedId = properties.getProperty("id");
//		connectedPwd = properties.getProperty("password");
//	}

	// 4. 자원 해제
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
