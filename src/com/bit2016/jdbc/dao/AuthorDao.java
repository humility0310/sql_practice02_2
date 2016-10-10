package com.bit2016.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.bit2016.jdbc.vo.AuthorVo;

public class AuthorDao {
	public void insert(AuthorVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;

		try {
			// 1, jdbc 드라이버 로딩(oracle)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2,
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(url, "bitdb", "bitdb");

			// 3, statment 준비
			String sql = "insert into book values(?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4, 바인딩
			Long no = 12L;
			String title = "토지12";

			pstmt.setLong(1, no);
			pstmt.setString(2, title);

			int count = pstmt.executeUpdate(sql);
			System.out.println(count);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				// 3, 자원 정리
				if (stmt != null) {
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
