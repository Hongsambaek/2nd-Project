package creddit.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import VO.CredditVO;
import util.MyBatisUtil;

public class CredditDaoImpl implements ICredditDao{
	
	private static ICredditDao credditDao = new CredditDaoImpl();
	
	private CredditDaoImpl() {
		
	}
	
	public static ICredditDao getInstance() {
		return credditDao;
	}
	

	public List<CredditVO> credditList() {
		
		List<CredditVO> credditList = new ArrayList<CredditVO>();

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			credditList = session.selectList("creddit.credditList");

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return credditList;
	}
}
