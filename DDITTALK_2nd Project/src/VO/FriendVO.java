package VO;

public class FriendVO {

	private String memEmail;
	private String memTag1;
	private String memEmail2;
	private String memTag2;
	private String fndDyn;
	private int friendListNum;

	public FriendVO(String memEmail, String memTag1, String memEmail2, String memTag2, String fndDyn) {
		super();
		this.memEmail = memEmail;
		this.memTag1 = memTag1;
		this.memEmail2 = memEmail2;
		this.memTag2 = memTag2;
		this.fndDyn = fndDyn;
	}

	@Override
	public String toString() {
		return "FriendVO [memEmail1=" + memEmail + ", memTag1=" + memTag1 + ", memEmail2=" + memEmail2 + ", memTag2="
				+ memTag2 + ", fndDyn=" + fndDyn + "]";
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemTag1() {
		return memTag1;
	}

	public void setMemTag1(String memTag1) {
		this.memTag1 = memTag1;
	}

	public String getMemEmail2() {
		return memEmail2;
	}

	public void setMemEmail2(String memEmail2) {
		this.memEmail2 = memEmail2;
	}

	public String getMemTag2() {
		return memTag2;
	}

	public void setMemTag2(String memTag2) {
		this.memTag2 = memTag2;
	}

	public String getFndDyn() {
		return fndDyn;
	}

	public void setFndDyn(String fndDyn) {
		this.fndDyn = fndDyn;
	}

	public FriendVO() {
		// TODO Auto-generated constructor stub
	}

	public int getFriendListNum() {
		return friendListNum;
	}

	public void setFriendListNum(int friendListNum) {
		this.friendListNum = friendListNum;
	}

}
