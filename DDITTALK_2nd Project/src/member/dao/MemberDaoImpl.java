package member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import VO.MemberVO;
import util.MyBatisUtil;

public class MemberDaoImpl implements IMemberDao {

	private static IMemberDao memDao = new MemberDaoImpl();

	private MemberDaoImpl() {

	}

	public static IMemberDao getInstance() {

		return memDao;
	}

	@Override
	public int insertMember(MemberVO mv) {

		SqlSession session = MyBatisUtil.getSqlSession();

		int cnt = 0;

		try {

			cnt = session.insert("member.insertMember", mv);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			session.rollback();
		} finally {
			session.close();
		}
		return cnt;

	}

	@Override
	public int deleteMember(MemberVO mv) {

		SqlSession session = MyBatisUtil.getSqlSession();

		int cnt = 0;

		try {

			session.delete("member.deleteMember", mv);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();

		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {

		SqlSession session = MyBatisUtil.getSqlSession();

		int cnt = 0;

		try {
			cnt = session.update("member.updateMember", mv);

			if (cnt > 0) {
				session.commit();
			}

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public boolean checkMember(String memEmail) {

		boolean isExist = false;

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			int cnt = session.selectOne("member.checkMember", memEmail);
			System.out.println(cnt);
			if (cnt > 0) {
				isExist = true;
			}

		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return isExist;
	}

	@Override
	public MemberVO getMember(String memEmail) {
		MemberVO mv = null;
		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {
			mv = session.selectOne("member.getMember", memEmail);
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return mv;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {
			memList = session.selectList("member.selectAllMember");
		} catch (PersistenceException ex) {
			ex.printStackTrace();

		} finally {
			session.close();
		}

		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {
			memList = session.selectList("member.searchMember", mv);
		} catch (PersistenceException ex) {
			ex.printStackTrace();

		} finally {
			session.close();
		}

		return memList;
	}

	@Override
	public String findId(MemberVO mv) {
		SqlSession session = MyBatisUtil.getSqlSession();

		String memEmail = "";

		try {
			memEmail = session.selectOne("member.findIdMember", mv);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return memEmail;
	}

	@Override
	public int findUpdatePass(MemberVO mv) {
		SqlSession session = MyBatisUtil.getSqlSession();

		int cnt = 0;

		try {
			cnt = session.update("member.findUpdatePass", mv);

			if (cnt > 0) {
				session.commit();
			}

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public List<MemberVO> getTag() {
		List<MemberVO> tagList = new ArrayList<MemberVO>();
		SqlSession session = MyBatisUtil.getSqlSession(true);
		try {
			tagList = session.selectList("member.getTag");
		} catch (PersistenceException ex) {
			ex.printStackTrace();

		} finally {
			session.close();
		}

		return tagList;
		
	}

	@Override
	public void setAtchFileId(long profileId) {
		List<MemberVO> tagList = new ArrayList<MemberVO>();
		SqlSession session = MyBatisUtil.getSqlSession(true);
		try {
			tagList = session.selectList("member.getTag");
		} catch (PersistenceException ex) {
			ex.printStackTrace();

		} finally {
			session.close();
		}
	}

}
