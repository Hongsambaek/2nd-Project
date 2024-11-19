package friend.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import VO.FriendVO;
import VO.MemberVO;
import util.MyBatisUtil;

public class FriendDaoImpl implements IFriendDao {

	private static IFriendDao fndDao = new FriendDaoImpl();

	public FriendDaoImpl() {
		fndDao = FriendDaoImpl.getInstance();
	}

	public static IFriendDao getInstance() {
		return fndDao;

	}

	@Override
	public List<FriendVO> getAcceptFriendList(String memEmail) {
		List<FriendVO> frdList = new ArrayList<FriendVO>();
		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {
			frdList = session.selectList("friend.getAcceptFnd", memEmail);
		} catch (PersistenceException ex) {
			ex.printStackTrace();

		} finally {
			session.close();
		}

		return frdList;
	}

	@Override
	public List<FriendVO> getFriendList(String memEmail) {
		List<FriendVO> frdList = new ArrayList<FriendVO>();
		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {
			frdList = session.selectList("fnd.getFnd", memEmail);
		} catch (PersistenceException ex) {
			ex.printStackTrace();

		} finally {
			session.close();
		}

		return frdList;
	}

	@Override
	public List<MemberVO> getMemTagSearch(String memTag) {
		List<MemberVO> memTagList = new ArrayList<MemberVO>();
		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {
			memTagList = session.selectList("friend.searchFriend", memTag);
		} catch (PersistenceException ex) {
			ex.printStackTrace();

		} finally {
			session.close();
		}

		return memTagList;
	}

	@Override
	public int addFriend(FriendVO fv) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.insert("friend.addFriend", fv);

			if (cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException ex) {
			session.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int acceptFriend(FriendVO fv) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.update("friend.acceptFriend", fv);

			if (cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException ex) {
			session.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int rejectFriend(FriendVO fv) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.delete("friend.rejectFriend", fv);

			if (cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException ex) {
			session.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(FriendVO fv) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.delete("friend.deleteFriend", fv);

			if (cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException ex) {
			session.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

}
