package pay.dao;

import java.util.List;

import VO.MemberVO;
import VO.PaymentVO;

public interface IPaymentDao {

	public List<PaymentVO> paymentList();
	
	public int insertPayment(PaymentVO pv);

	public int deletePayment(int paymentNum);
	
	public PaymentVO getPayment(String memEmail);

	List<PaymentVO> memPaymentList(String memEmail);
}
