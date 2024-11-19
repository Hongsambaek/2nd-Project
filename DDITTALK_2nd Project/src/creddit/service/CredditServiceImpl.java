package creddit.service;

import java.util.List;

import VO.CredditVO;
import creddit.dao.CredditDaoImpl;
import creddit.dao.ICredditDao;

public class CredditServiceImpl implements ICredditService{
	
	private static ICredditService credditService = new CredditServiceImpl();
	
	private ICredditDao credditDao;
	
	private CredditServiceImpl(){
		credditDao = CredditDaoImpl.getInstance();		
	}
	
	public static ICredditService getInstance() {
		
		return credditService;
	}

	@Override
	public List<CredditVO> credditList() {
		return credditDao.credditList();
	}

}
