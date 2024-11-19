package fnd.dao;

import java.util.List;

import VO.FriendVO;

public interface IFndDao {

	List<FriendVO> getMyFnd(String memEmail);
	



}
