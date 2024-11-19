package VO;

public class LikeVO {
	private int likeNum;
	private int feedNum;
	private String memEmail;
	private int likeSum;
	
	public LikeVO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * like 객체를 만듬
	 * 
	 * @param feedNum
	 * @param memEmail
	 */
	public LikeVO(int feedNum, String memEmail) {
		this.feedNum = feedNum;
		this.memEmail = memEmail;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
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

	public int getLikeSum() {
		return likeSum;
	}

	public void setLikeSum(int likeSum) {
		this.likeSum = likeSum;
	}

}
