package com.service;

import java.util.List;

import VO.ComplainVO;

public interface IComplainService {
	
	public List<ComplainVO> getAdComplain(String memEmail);
	
	public List<ComplainVO> getMemComplain(String memEmail);
	
	public ComplainVO getInComplain(int comNum);
	
	public int insertComplain(ComplainVO cv);

	public int deleteComplain(int comNum);
	
	public int answerComplain(ComplainVO cv);
}
