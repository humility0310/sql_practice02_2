package com.bit2016.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bit2016.jdbc.vo.AuthorVo;

public class AuthorDao {
	public void insert(AuthorVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			System.out.println("1");
			// 1, jdbc 드라이버 로딩(oracle)
			Class.forName( "oracle.jdbc.driver.OracleDriver" );
			System.out.println("1.5");
			// 2,
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "bitdb", "bitdb");
			System.out.println("2");
			// 3, statment 준비
			String sql = "insert into author values(?, ?)";
			pstmt = conn.prepareStatement(sql);
			System.out.println("3");
			// 4, 바인딩
			System.out.println("4");
			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getName());

			int count = pstmt.executeUpdate();
			System.out.println(count);
			System.out.println("5");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				// 3, 자원 정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
