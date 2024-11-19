package VO;

import java.time.LocalDate;

public class PurchaseVO {
	private int purchaseNum;
	private String memEmail;
	private String comTitle;
	private String comContent;
	private LocalDate comDate;
	private char comDyn = 'N';
	private String comMenu;
	
	public PurchaseVO() {
		
	}
	/**
	 * 문의내역 객체를 필드값으로 받아 생성한다.
	 * 
	 * @param purchaseNum	결재번호(int)
	 * @param memEmail		회원이메일(String)
	 * @param comTitle		문의제목(String)
	 * @param comContent	문의내용(String)
	 * @param comDate		문의날짜(LocalDate)
	 * @param comDyn		문의삭제('Y' or 'N')
	 * @param comMenu		문의유형(String)
	 */
	public PurchaseVO(int purchaseNum, String memEmail, String comTitle, String comContent, LocalDate comDate,
			char comDyn, String comMenu) {
		this.purchaseNum = purchaseNum;
		this.memEmail = memEmail;
		this.comTitle = comTitle;
		this.comContent = comContent;
		this.comDate = comDate;
		this.comDyn = comDyn;
		this.comMenu = comMenu;
	}

	public int getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getComTitle() {
		return comTitle;
	}

	public void setComTitle(String comTitle) {
		this.comTitle = comTitle;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public LocalDate getComDate() {
		return comDate;
	}

	public void setComDate(LocalDate comDate) {
		this.comDate = comDate;
	}

	public char getComDyn() {
		return comDyn;
	}

	public void setComDyn(char comDyn) {
		this.comDyn = comDyn;
	}

	public String getComMenu() {
		return comMenu;
	}

	public void setComMenu(String comMenu) {
		this.comMenu = comMenu;
	}

}
