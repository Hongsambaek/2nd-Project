package VO;

public class CommentVO implements Comparable<CommentVO> {

	private int commentNum;
	private int feedNum;
	private String commentContent;
	private String commentUpdate;
	private String commentDate;
	private String commentDlyn;
	private String memEmail;
	
	public CommentVO() {

	}

	/**
	 * 답글 객체를 필드값을 입력받아 생성한다.
	 * 
	 * @param feedNum			게시글번호(int)
	 * @param commentCont		답글내용(String)
	 */
	public CommentVO(int feedNum, String commentContent, String memEmail) {
		super();
		this.feedNum = feedNum;
		this.commentContent = commentContent;
		this.memEmail = memEmail;
	}

	
	
	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getFeedNum() {
		return feedNum;
	}

	public void setFeedNum(int feedNum) {
		this.feedNum = feedNum;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String isCommentUpdate() {
		return commentUpdate;
	}

	public void setCommentUpdate(String commentUpdate) {
		this.commentUpdate = commentUpdate;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentDlyn() {
		return commentDlyn;
	}

	public void setCommentDlyn(String commentDlyn) {
		this.commentDlyn = commentDlyn;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	@Override
	public int compareTo(CommentVO o) {
		return this.getCommentDate().compareTo(o.getCommentDate());
	}

}
