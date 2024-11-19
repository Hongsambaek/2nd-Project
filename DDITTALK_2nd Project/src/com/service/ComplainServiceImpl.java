package com.service;

import java.util.List;

import com.dao.ComplainDaoImpl;
import com.dao.IComplainDao;

import VO.ComplainVO;

public class ComplainServiceImpl implements IComplainService {


	private static ComplainServiceImpl instance;
	private IComplainDao comDao;

	private ComplainServiceImpl() {
		comDao = ComplainDaoImpl.getInstance();
	}

	public static ComplainServiceImpl getInstance() {
		if (instance == null) {
			instance = new ComplainServiceImpl();
		}
		return instance;
	}




	@Override
	public List<ComplainVO> getMemComplain(String memEmail) {

		return comDao.getMemComplain(memEmail);
	}

	@Override
	public ComplainVO getInComplain(int comNum) {
		
		return comDao.getDetailComplain(comNum);
	}

	@Override
	public int insertComplain(ComplainVO cv) {
		int cnt = comDao.registerComplain(cv);
		return cnt;
	}

	@Override
	public List<ComplainVO> getAdComplain(String memEmail) {
		
		return comDao.getAdminComplain(memEmail);
	}

	@Override
	public int deleteComplain(int comNum) {
		
		return comDao.removeComplain(comNum);
	}

	@Override
	public int answerComplain(ComplainVO cv) {
		return comDao.updateComplain(cv);
	}




	


	

}
