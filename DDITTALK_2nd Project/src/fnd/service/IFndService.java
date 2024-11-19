package fnd.service;

import java.util.List;

import VO.FriendVO;

public interface IFndService {
	
	public List<FriendVO> getFnd(String memEmail);
 
}
