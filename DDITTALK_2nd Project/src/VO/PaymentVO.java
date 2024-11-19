package VO;

public class PaymentVO {
	private int credditQty;
	private int credditNum;
	private String memEmail;
	private int paymentNum;

	public PaymentVO() {

	}

	/**
	 * 코인구매 내역 객체를 필드값으로 받아 생성한다.
	 * 
	 * @param credditQty 코인수량(int)
	 * @param credditNum 코인상품번호(int)
	 * @param memEmail   회원이메일(String)
	 */
	public PaymentVO(int credditQty, int credditNum, String memEmail) {
		
		this.credditQty = credditQty;
		this.credditNum = credditNum;
		this.memEmail = memEmail;
	}
	public PaymentVO(int credditQty, int credditNum, String memEmail, int paymentNum) {
		super();
		this.credditQty = credditQty;
		this.credditNum = credditNum;
		this.memEmail = memEmail;
		this.paymentNum = paymentNum;
	}

	public int getCredditQty() {
		return credditQty;
	}

	public void setCredditQty(int credditQty) {
		this.credditQty = credditQty;
	}

	public int getPaymentNum() {
		return paymentNum;
	}

	public void setPaymentNum(int paymentNum) {
		this.paymentNum = paymentNum;
	}

	public int getCredditNum() {
		return credditNum;
	}

	public void setCredditNum(int credditNum) {
		this.credditNum = credditNum;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

}
