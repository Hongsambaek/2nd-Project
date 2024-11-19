package VO;

public class FeedVO implements Comparable<FeedVO> {
	private int feedNum;
	private long atchFileId;
	private String memEmail;
	private int feedMemNum;
	private String feedContent;
	private String feedDate;
	private String feedDisplay;
	private char feedAdv;
	private char feedDyn;
	private int feedLike;
	private int rnum;
	private String search;
	private int start;
	private int end;

	public FeedVO() {
		
	}
	
	public FeedVO(String memEmail, int start, int end) {
		this.memEmail = memEmail;
		this.start = start;
		this.end = end;
	}
	
	public FeedVO(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public FeedVO(String feedContent, String feedDisplay) {
	    this.feedContent = feedContent;
	    this.feedDisplay = feedDisplay;
	}
	
	public FeedVO(int feedNum, String feedContent, String feedDisplay) {
	    this.feedNum = feedNum;
	    this.feedContent = feedContent;
	    this.feedDisplay = feedDisplay;
	}

	/**
	 * 게시물 객체를 필드값을 받아 생성한다.
	 * 
	 * @param memEmail		회원이메일(String)
	 * @param feedContent	게시물내용(String)
	 * @param feedDisplay	공개범위(String)
	 */
	public FeedVO(String memEmail, String feedContent,
			String feedDisplay) {
		this.memEmail = memEmail;	 
		this.feedContent = feedContent;
		this.feedDisplay = feedDisplay;
	}

	public int getFeedNum() {
		return feedNum;
	}

	public void setFeedNum(int feedNum) {
		this.feedNum = feedNum;
	}

	public long getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public int getFeedMemNum() {
		return feedMemNum;
	}

	public void setFeedMemNum(int feedMemNum) {
		this.feedMemNum = feedMemNum;
	}

	public String getFeedContent() {
		return feedContent;
	}

	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}

	public String getFeedDate() {
		return feedDate;
	}

	public void setFeedDate(String feedDate) {
		this.feedDate = feedDate;
	}

	public String getFeedDisplay() {
		return feedDisplay;
	}

	public void setFeedDisplay(String feedDisplay) {
		this.feedDisplay = feedDisplay;
	}

	public char getFeedAdv() {
		return feedAdv;
	}

	public void setFeedAdv(char feedAdv) {
		this.feedAdv = feedAdv;
	}

	public char getFeedDyn() {
		return feedDyn;
	}

	public void setFeedDyn(char feedDyn) {
		this.feedDyn = feedDyn;
	}

	public int getFeedLike() {
		return feedLike;
	}

	public void setFeedLike(int feedLike) {
		this.feedLike = feedLike;
	}

	@Override
	public int compareTo(FeedVO o) {
		return Integer.compare(this.getFeedNum(), o.getFeedNum()) * -1;
	}
	@Override
	public String toString() {
		return "FeedVO [feedNum=" + feedNum + ", atchFileId=" + atchFileId + ", memEmail=" + memEmail + ", feedMemNum="
				+ feedMemNum + ", feedContent=" + feedContent + ", feedDate=" + feedDate + ", feedDisplay="
				+ feedDisplay + ", feedAdv=" + feedAdv + ", feedDyn=" + feedDyn + ", feedLike=" + feedLike + "]";
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	

}


