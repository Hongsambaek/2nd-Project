package pay.service;

import java.util.List;

import VO.PaymentVO;

public interface IPaymentService {
	
	public List<PaymentVO> paymentList();
	
	public int insertPayment(PaymentVO pv);

	public int deletePayment(int paymentNum);
	
	public PaymentVO getPayment(String memEmail);
	
	List<PaymentVO> memPaymentList(String memEmail);
}
