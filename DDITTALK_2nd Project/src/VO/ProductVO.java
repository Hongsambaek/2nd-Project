package VO;

import java.util.Comparator;

public class ProductVO implements Comparable<ProductVO> {
	private int productNum;
	private String productName;
	private int productPrice;

	public ProductVO() {

	}

	/**
	 * 서비스 및 상품 객체를 필드값으로 받아 생성한다. 
	 * 
	 * @param productNum		상품번호(int)
	 * @param productName		상품이름(String)
	 * @param productPrice		상품가격(int)
	 */
	public ProductVO(int productNum, String productName, int productPrice) {
		super();
		this.productNum = productNum;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public int compareTo(ProductVO o) {
		return Integer.compare(this.getProductNum(), o.getProductNum());
	}

}

class ComparePrice implements Comparator<ProductVO> {

	@Override
	public int compare(ProductVO o1, ProductVO o2) {
		return Integer.compare(o1.getProductPrice(), o2.getProductPrice());
	}

}
