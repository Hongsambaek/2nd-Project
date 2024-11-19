package pay.service;

import java.util.List;

import VO.PaymentVO;
import pay.dao.IPaymentDao;
import pay.dao.PaymentDaoImpl;

public class PaymentServiceImpl implements IPaymentService{
	
	private static IPaymentService paymentService = new PaymentServiceImpl();
	
	private IPaymentDao paymentDao;
	
	private PaymentServiceImpl(){
		paymentDao = PaymentDaoImpl.getInstance();		
	}
	
	public static IPaymentService getInstance() {
		
		return paymentService;
	}

	@Override
	public List<PaymentVO> paymentList() {
		return paymentDao.paymentList();
	}

	@Override
	public int insertPayment(PaymentVO pv) {
		return paymentDao.insertPayment(pv);
	}

	@Override
	public int deletePayment(int paymentNum) {
		return paymentDao.deletePayment(paymentNum);
	}

	@Override
	public List<PaymentVO> memPaymentList(String memEmail) {
		return paymentDao.memPaymentList(memEmail);
	}

	@Override
	public PaymentVO getPayment(String memEmail) {
		return paymentDao.getPayment(memEmail);
	}

	
}
