package comment.service;

import java.util.List;

import VO.CommentVO;

public interface ICommentService {

	public List<CommentVO> commentList(); 
	
	public int insertComment(CommentVO cv);
	
	public int updateComment(CommentVO cv);
	
	public int deleteComment(int commentNum);
	
}
