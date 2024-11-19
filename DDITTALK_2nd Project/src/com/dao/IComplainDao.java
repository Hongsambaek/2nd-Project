package com.dao;

import java.util.List;

import VO.ComplainVO;

public interface IComplainDao {
	



	public List<ComplainVO> getMemComplain(String memEmail);


	public ComplainVO getDetailComplain(int comNum);


	public int registerComplain(ComplainVO cv);


	public List<ComplainVO> getAdminComplain(String memEmail);


	public int removeComplain(int comNum);


	public int updateComplain(ComplainVO cv);

}
