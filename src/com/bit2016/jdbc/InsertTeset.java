package com.bit2016.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTeset {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			// 1, jdbc 드라이버 로딩(oracle)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2,
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(url, "bitdb", "bitdb");

			// 3, statment 생성
			stmt = conn.createStatement();

			// 4, SQL실행
			Long no = 10L;
			String title = "토지10";
			String date = "sysdate";
			String state = "대여가능";
			Long authorNo = 1L;

			String sql = "INSERT INTO BOOK VALUES (" + no + ", '" + title + "', " + date + ", '" + state + "', "
					+ authorNo + ")";

			int count = stmt.executeUpdate(sql);
			System.out.println(count);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				// 3, 자원 정리
				if (stmt != null) {
					stmt.close();
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
