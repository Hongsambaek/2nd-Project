package VO;

public class AdVO {
	
	private int feedNum;
	private int adCount;
	private char adVisible;
	
	public AdVO() {

	} 
	/**
	 * 광고 객체를 필드값을 받아 생성한다.
	 * 
	 * @param feedNum		게시글번호(int)
	 * @param adCount		클릭수(int)
	 * @param adVisible		게시글노출('Y' or 'N')
	 */
	public AdVO(int feedNum, int adCount, char adVisible) {
		this.feedNum = feedNum;
		this.adCount = adCount;
		this.adVisible = adVisible;
	}

	public int getFeedNum() {
		return feedNum;
	}
	public void setFeedNum(int feedNum) {
		this.feedNum = feedNum;
	}
	public int getAdCount() {
		return adCount;
	}
	public void setAdCount(int adCount) {
		this.adCount = adCount;
	}
	public char getAdVisible() {
		return adVisible;
	}
	public void setAdVisible(char adVisible) {
		this.adVisible = adVisible;
	}
	
	
	
	
	
	
}
