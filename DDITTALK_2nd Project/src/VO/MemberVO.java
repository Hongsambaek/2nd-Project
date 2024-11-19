package VO;

import java.time.LocalDate;

public class MemberVO implements Comparable<MemberVO> {
	private String memEmail;
	private String memName;
	private String memPass;
	private String memTag;

	private String memNickname;
	private String memTel;
	private int memPost;
	private String memAddr;
	private String memSchool;
	private char memDelete = 'N';
	private long memCoin = 0;
	private LocalDate memDate;
	private long memProfile;
	private LocalDate memBirth;
	private String streNm;

	public MemberVO(String memEmail, String memName, String memPass, String memTag, String memNickname, String memTel,
			String memAddr, int memPost, String memSchool, char memDelete, long memCoin, LocalDate memDate,
			long memProfile, LocalDate memBirth) {
		super();
		this.memEmail = memEmail;
		this.memName = memName;
		this.memPass = memPass;
		this.memTag = memTag;
		this.memNickname = memNickname;
		this.memTel = memTel;
		this.memAddr = memAddr;
		this.memPost = memPost;
		this.memSchool = memSchool;
		this.memDelete = memDelete;
		this.memCoin = memCoin;
		this.memDate = memDate;
		this.memProfile = memProfile;
		this.memBirth = memBirth;
	}

	public int getMemPost() {
		return memPost;
	}

	public void setMemPost(int memPost) {
		this.memPost = memPost;
	}

	public MemberVO() {

	}

	/**
	 * 비밀번호 변경시 필요한 요소만 받는다.
	 * 
	 * @param memPass 비밀번호
	 */
	public MemberVO(String memPass) {
		this.memPass = memPass;
	}

	public MemberVO(String memName, String memTel, String memEmail, String memPass, String memTag, String memAddr,
			String memSchool, String memNickname) {
		this.memName = memName;
		this.memTel = memTel;
		this.memEmail = memEmail;
		this.memPass = memPass;
		this.memTag = memPass;
		this.memAddr = memAddr;
		this.memSchool = memSchool;
		this.memNickname = memNickname;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemTag() {
		return memTag;
	}

	public void setMemTag(String memTag) {
		this.memTag = memTag;
	}

	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public String getMemSchool() {
		return memSchool;
	}

	public void setMemSchool(String memSchool) {
		this.memSchool = memSchool;
	}

	public char getMemDelete() {
		return memDelete;
	}

	public void setMemDelete(char memDelete) {
		this.memDelete = memDelete;
	}

	public long getMemCoin() {
		return memCoin;
	}

	public void setMemCoin(long memCoin) {
		this.memCoin = memCoin;
	}

	public LocalDate getMemDate() {
		return memDate;
	}

	public void setMemDate(LocalDate memDate) {
		this.memDate = memDate;
	}

	public long getMemProfile() {
		return memProfile;
	}

	public void setMemProfile(long memProfile) {
		this.memProfile = memProfile;
	}

	public LocalDate getMemBirth() {
		return memBirth;
	}

	public void setMemBirth(LocalDate memBirth) {
		this.memBirth = memBirth;
	}

	@Override
	public String toString() {
		return "MemberVO [memEmail=" + memEmail + ", memName=" + memName + ", memPass=" + memPass + ", memTag=" + memTag
				+ ", memNickname=" + memNickname + ", memTel=" + memTel + ", memAddr=" + memAddr + ", memSchool="
				+ memSchool + ", memDelete=" + memDelete + ", memCoin=" + memCoin + ", memDate=" + memDate
				+ ", memProfile=" + memProfile + ", memBirth=" + memBirth + "]";
	}

	@Override
	public int compareTo(MemberVO o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getStreNm() {
		return streNm;
	}

	public void setStreNm(String streNm) {
		this.streNm = streNm;
	}

}
