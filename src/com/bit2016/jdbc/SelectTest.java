package com.bit2016.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1, jdbc 드라이버 로딩(oracle)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2,
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3, Statement 객체 생성
			stmt = conn.createStatement();

			// 4, SQL문 생성
			String sql = "select employee_id, first_name, salary from employees";
			rs = stmt.executeQuery(sql);

			// 5, 데이터 결과 가져오기(ResultSet)
			while (rs.next()) {
				Long employeeId = rs.getLong(1);
				String firstName = rs.getString(2);
				Integer salary = rs.getInt(3);

				System.out.println(employeeId + ":" + firstName + ":" + salary);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				// 3, 자원 정리
				if (rs != null) {
					rs.close();
				}
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
