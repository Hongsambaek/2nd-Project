package VO;

public class ReportVO {

	private int reportNum;
	private String reportMenu;
	private int feemNum;
	
	
	/**
	 * 신고 내역 객체를 필드값으로 받아 생성한다.
	 * @param reportNum		신고번호(int)
	 * @param reportMenu	유형(String)
	 * @param feemNum		번호(int)
	 */
	public ReportVO(int reportNum, String reportMenu, int feemNum) {
		super();
		this.reportNum = reportNum;
		this.reportMenu = reportMenu;
		this.feemNum = feemNum;
	}

	public int getReportNum() {
		return reportNum;
	}

	public void setReportNum(int reportNum) {
		this.reportNum = reportNum;
	}

	public String getReportMenu() {
		return reportMenu;
	}

	public void setReportMenu(String reportMenu) {
		this.reportMenu = reportMenu;
	}

	public int getFeemNum() {
		return feemNum;
	}

	public void setFeemNum(int feemNum) {
		this.feemNum = feemNum;
	}

}
