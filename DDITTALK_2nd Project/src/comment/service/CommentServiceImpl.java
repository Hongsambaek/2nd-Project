package comment.service;

import java.util.List;

import VO.CommentVO;
import comment.dao.CommentDaoImple;
import comment.dao.ICommentDao;

public class CommentServiceImpl implements ICommentService {

	private static ICommentService commentService = new CommentServiceImpl();
	
	private ICommentDao commentDao;
	
	public CommentServiceImpl() {
		commentDao = CommentDaoImple.getInstance();
	}
	
	public static ICommentService getInstance() {
		return commentService;
	}
	
	@Override
	public List<CommentVO> commentList() {
		return commentDao.commentList();
	}

	@Override
	public int insertComment(CommentVO cv) {
		return commentDao.insertComment(cv);
	}

	@Override
	public int updateComment(CommentVO cv) {
		return commentDao.updateComment(cv);
	}

	@Override
	public int deleteComment(int commentNum) {
		return commentDao.deleteComment(commentNum);
	}

}
