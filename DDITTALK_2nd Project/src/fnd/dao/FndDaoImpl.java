package fnd.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import VO.FriendVO;
import util.MyBatisUtil;

public class FndDaoImpl implements IFndDao {

	private static IFndDao fndDao = new FndDaoImpl();

	public FndDaoImpl() {
		fndDao = FndDaoImpl.getInstance();
	}

	public static IFndDao getInstance() {
		return fndDao;
	}

	@Override
	public List<FriendVO> getMyFnd(String memEmail) {
		List<FriendVO> fndList = new ArrayList<FriendVO>();
		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			fndList = session.selectList("fnd.getFnd", memEmail);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fndList;
	}

}
