package VO;

import java.time.LocalDate;

public class ComplainVO {
	private int comNum;
	private String memEmail;
	private String comTitle;
	private String comContent;
	private LocalDate comDate;
	private String comDyn;
	private String comMenu;
	private String comAns;
	public ComplainVO() { }
	
	public ComplainVO(int comNum, String memEmail, String comTitle, String comContent, LocalDate comDate, String comDyn,
			String comMenu, String comAns) {
		super();
		this.comAns = comAns;
		this.comNum = comNum;
		this.memEmail = memEmail;
		this.comTitle = comTitle;
		this.comContent = comContent;
		this.comDate = comDate;
		this.comDyn = comDyn;
		this.comMenu = comMenu;
	}



	public int getComNum() {
		return comNum;
	}

	public void setComNum(int comNum) {
		this.comNum = comNum;
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

	public String getComDyn() {
		return comDyn;
	}

	public void setComDyn(String comDyn) {
		this.comDyn = comDyn;
	}

	public String getComMenu() {
		return comMenu;
	}

	public void setComMenu(String comMenu) {
		this.comMenu = comMenu;
	}
	public String getComAns() {
		return comAns;
	}
	
	public void setComAns(String comAns) {
		this.comAns = comAns;
	}

}
