package com.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;


import VO.ComplainVO;
import VO.MemberVO;
import util.MyBatisUtil;

public class ComplainDaoImpl implements IComplainDao {

	private static IComplainDao comDao = new ComplainDaoImpl();

	public ComplainDaoImpl() {
		comDao = ComplainDaoImpl.getInstance();
	}

	public static IComplainDao getInstance() {
		return comDao;

	}

	@Override
	public List<ComplainVO> getMemComplain(String memEmail) {
		List<ComplainVO> cv = new ArrayList<ComplainVO>();
		SqlSession session = MyBatisUtil.getSqlSession(true);
		
		try {
			cv = session.selectList("complain.getMemComplain", memEmail);
		} catch (PersistenceException e) {
			 e.printStackTrace();
		} finally {
			session.close();
		}
		return cv;
	}

	@Override
	public ComplainVO getDetailComplain(int comNum) {
		ComplainVO cv = new ComplainVO();
		SqlSession session = MyBatisUtil.getSqlSession(true);
		try {
			cv = session.selectOne("complain.getDetailComplain", comNum);
		} catch (PersistenceException e) {
			 e.printStackTrace();
		} finally {
			session.close();
		}
		return cv;
	}

	@Override
	public int registerComplain(ComplainVO cv) {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		int cnt = 0;
		try {
			cnt = session.insert("complain.insertComplain", cv);
			session.commit();
		} catch (PersistenceException e) {
			 e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<ComplainVO> getAdminComplain(String memEmail) {
		List<ComplainVO> comList = new ArrayList<ComplainVO>();
		SqlSession session = MyBatisUtil.getSqlSession(true);
		
		try {
			
			comList = session.selectList("complain.getAdminComplain", memEmail);
			
		} catch (PersistenceException e) {
			 e.printStackTrace();
		} finally {
			session.close();
		}
		return comList;
	}

	@Override
	public int removeComplain(int comNum) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.delete("complain.removeComplain", comNum);
			if(cnt > 0 ) {
				session.commit();
			}
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateComplain(ComplainVO cv) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.update("complain.answerComplain", cv);
			if(cnt > 0 ) session.commit();
		} catch (PersistenceException e) {
			session.rollback();
			 e.printStackTrace();
		} finally {
			session.close();
		} return cnt;
	}

	
	

}

	

