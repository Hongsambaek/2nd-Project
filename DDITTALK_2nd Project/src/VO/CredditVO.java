package VO;

public class CredditVO implements Comparable<CredditVO> {
	private int credditNum;
	private int credditQty;
	private int credditMoney;
	
	public CredditVO() {

	}
	
	/**
	 * 크레띳 객체를 필드값을 받아 생성한다.
	 * 
	 * @param credditNum		크레띳상품번호(int)
	 * @param credditQty		크레띳수량(int)
	 * @param credditMoney		크레띳상품가격(int)
	 */
	public CredditVO(int credditNum, int credditQty, int credditMoney) {
		super();
		this.credditNum = credditNum;
		this.credditQty = credditQty;
		this.credditMoney = credditMoney;
	}

	public int getCredditNum() {
		return credditNum;
	}

	public void setCredditNum(int credditNum) {
		this.credditNum = credditNum;
	}

	public int getCredditQty() {
		return credditQty;
	}

	public void setCredditQty(int credditQty) {
		this.credditQty = credditQty;
	}

	public int getCredditMoney() {
		return credditMoney;
	}

	public void setCredditMoney(int credditMoney) {
		this.credditMoney = credditMoney;
	}

	@Override
	public int compareTo(CredditVO o) {
		return Integer.compare(this.getCredditNum(), o.getCredditNum());
	}

}
