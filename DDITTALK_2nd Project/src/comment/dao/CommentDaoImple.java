package comment.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import VO.CommentVO;
import util.MyBatisUtil;

public class CommentDaoImple implements ICommentDao {

	private static ICommentDao commentDao = new CommentDaoImple();


	private CommentDaoImple() {
		
	}

	public static ICommentDao getInstance() {
		return commentDao;
	}

	@Override
	public List<CommentVO> commentList() {
		
		SqlSession session = MyBatisUtil.getSqlSession();

		List<CommentVO> commentList = new ArrayList<CommentVO>();

		try {

			commentList = session.selectList("comment.getAllComment");

		} catch (PersistenceException e) {

			e.printStackTrace();

		} finally {
			
			session.close();

		}

		return commentList;
	}

	@Override
	public int insertComment(CommentVO cv) {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);

		int rst = 0;

		try {
			rst = session.insert("comment.insertComment", cv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rst;
	}

	@Override
	public int updateComment(CommentVO cv) {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);

		int rst = 0;

		try {
			rst = session.update("comment.updateComment", cv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rst;
	}

	@Override
	public int deleteComment(int commentNum) {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);
		
		int rst = 0;
		
		try {
			rst = session.update("comment.deleteComment", commentNum);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rst;
	}

}
