package fnd.service;

import java.util.List;

import VO.FriendVO;
import fnd.dao.FndDaoImpl;
import fnd.dao.IFndDao;

public class FndServiceImpl implements IFndService {


	private static FndServiceImpl instance;
	private IFndDao fndDao;

	private FndServiceImpl() {
		fndDao = FndDaoImpl.getInstance();
	}

	public static FndServiceImpl getInstance() {
		if (instance == null) {
			instance = new FndServiceImpl();
		}
		return instance;
	}

	@Override
	public List<FriendVO> getFnd(String memEmail) {
		
		return fndDao.getMyFnd(memEmail);
	}




	

	


	

}
