package VO;

public class BookmarkVO {
	private int bookmarkNum;
	private int feedNum;
	private String memEmail;
	
	public BookmarkVO() {
		// TODO Auto-generated constructor stub
	}
	
	public BookmarkVO(int feedNum, String memEmail) {
		this.feedNum = feedNum;
		this.memEmail = memEmail;
	}
	public int getBookmarkNum() {
		return bookmarkNum;
	}
	public void setBookmarkNum(int bookmarkNum) {
		this.bookmarkNum = bookmarkNum;
	}
	public int getFeedNum() {
		return feedNum;
	}
	public void setFeedNum(int feedNum) {
		this.feedNum = feedNum;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	
	
}
