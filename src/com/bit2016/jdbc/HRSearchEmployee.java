package com.bit2016.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HRSearchEmployee {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		try {
			// 1, jdbc 드라이버 로딩(oracle)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2,
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3, Statement 객체 생성
			stmt = conn.createStatement();

			System.out.print("사원 이름 :");
			String scan = sc.nextLine();

			// 4, SQL문 생성

			String sql = "select FIRST_NAME, LAST_NAME, EMAIL, to_char(HIRE_DATE,'YYYY\"년\" MM\"월\" DD\"일\"') "
					+ "from employees " + "WHERE FIRST_NAME LIKE '%" + scan + "%' OR LAST_NAME LIKE '%" + scan + "%'";
			rs = stmt.executeQuery(sql);
			// 5, 데이터 결과 가져오기(ResultSet)

			System.out.println("이름                  	:성                  	:이메일                  	:입사일");
			System.out.println("--------------------------------------------------------------");
			while (rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				String eMail = rs.getString(3);
				String hireDate = rs.getString(4);
				System.out.println(firstName + "    	:" + lastName + "    	:" + eMail + "    	:" + hireDate);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				// 3, 자원 정리
				if (sc != null) {
					sc.close();
				}
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
