package msg.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import VO.MessageVO;
import util.MyBatisUtil;

public class MsgDaoImpl implements IMsgDao {

	private static IMsgDao msgDao = new MsgDaoImpl();

	public MsgDaoImpl() {
		msgDao = MsgDaoImpl.getInstance();
	}

	public static IMsgDao getInstance() {
		return msgDao;

	}
	
	
	@Override
	public List<MessageVO> getMsg(MessageVO mv) {
		List<MessageVO> mvList = new ArrayList<MessageVO>();
		SqlSession session = MyBatisUtil.getSqlSession(true);
		try {
			mvList = session.selectList("message.getMessage", mv);
		} catch (PersistenceException e) {
			 e.printStackTrace();
		}finally {
			session.close();
		}
		return mvList;
	}

	@Override
	public int InsertMsg(MessageVO mv) {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		int cnt = 0;
		try {
			cnt = session.insert("message.sendMessage", mv);
			session.commit();
		} catch (PersistenceException e) {
			 e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<MessageVO>  getRecentMsg(MessageVO mv) {
		List<MessageVO> recentList = new ArrayList<MessageVO>();
		SqlSession session = MyBatisUtil.getSqlSession(true);
		try {
			recentList = session.selectList("message.recentMessage", mv);
		} catch (PersistenceException e) {
			 e.printStackTrace();
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		}
		finally {
			session.close();
		} 
		return recentList;
	}

}

	

