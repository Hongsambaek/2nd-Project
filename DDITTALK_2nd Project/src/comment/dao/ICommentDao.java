package comment.dao;

import java.util.List;

import VO.CommentVO;

public interface ICommentDao {

	public List<CommentVO> commentList(); 
	
	public int insertComment(CommentVO cv);
	
	public int updateComment(CommentVO cv);
	
	public int deleteComment(int commentNum);
	
}
