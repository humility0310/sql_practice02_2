package com.bit2016.jdbc.dao.test;

import com.bit2016.jdbc.dao.AuthorDao;
import com.bit2016.jdbc.vo.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
		// insert 테스트
		insertTest();
	}

	public static void insertTest() {
		AuthorDao dao = new AuthorDao();
		//mock data
		AuthorVo vo1 = new AuthorVo();
		vo1.setName("맹자");
		AuthorVo vo2 = new AuthorVo();
		vo2.setName("장자");
		AuthorVo vo3 = new AuthorVo();
		vo3.setName("공자");

		dao.insert(vo1);
		dao.insert(vo2);
		dao.insert(vo3);
	}

}
