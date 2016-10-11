package com.bit2016.jdbc.dao.test;

import java.util.List;

import com.bit2016.jdbc.dao.AuthorDao;
import com.bit2016.jdbc.vo.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
		// insert 테스트
//		insertTest();

		// deleteTest
		// deleteTest();

		//updateTest
		updateTest();
		
		// getList test
		getListTest();
	}

	public static void getListTest() {
		AuthorDao dao = new AuthorDao();
		List<AuthorVo> list = dao.getList();
		System.out.println("=================================================");
		for (AuthorVo vo : list) {
			// System.out.println(vo.getNo()+":"+vo.getName());
			System.out.println(vo);
		}
	}

	public static void updateTest(){
		AuthorVo vo = new AuthorVo();
		vo.setNo(3l);
		vo.setName("김영조");
		
		new AuthorDao().update(vo);
		
	}
	
	public static void insertTest(String name) {

	}

	public static void deleteTest() {
		AuthorDao dao = new AuthorDao();
		dao.delete(1l);
		dao.delete(2l);
		dao.delete(3l);
		dao.delete(4l);
	}

	public static void insertTest() {
		AuthorDao dao = new AuthorDao();
		// mock data
		AuthorVo vo1 = new AuthorVo();
		vo1.setName("맹자");
		dao.insert(vo1);

		AuthorVo vo2 = new AuthorVo();
		vo2.setName("장자");
		dao.insert(vo2);

		AuthorVo vo3 = new AuthorVo();
		vo3.setName("순자");
		dao.insert(vo3);

	}
}
