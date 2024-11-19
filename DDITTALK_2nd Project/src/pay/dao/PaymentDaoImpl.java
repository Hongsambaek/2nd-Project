package pay.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import VO.MemberVO;
import VO.PaymentVO;
import util.MyBatisUtil;

public class PaymentDaoImpl implements IPaymentDao{

	private static IPaymentDao paymentDao = new PaymentDaoImpl();
	
	private PaymentDaoImpl() {
		
	}
	
	public static IPaymentDao getInstance() {
		return paymentDao;
	}
	

	@Override
	public List<PaymentVO> paymentList() {
		
		List<PaymentVO> paymentList = new ArrayList<PaymentVO>();

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			paymentList = session.selectList("payment.paymentList");

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return paymentList;
	}
	
	@Override
	public List<PaymentVO> memPaymentList(String memEmail) {
		
		List<PaymentVO> paymentList = new ArrayList<PaymentVO>();

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			paymentList = session.selectList("payment.memPaymentList", memEmail);

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return paymentList;
	}
	

	@Override
	public int insertPayment(PaymentVO pv) {

			SqlSession session = MyBatisUtil.getSqlSession();

			int cnt = 0;

			try {

				cnt = session.insert("payment.pay", pv);

				if (cnt > 0) {
					session.commit();
				}

			} catch (PersistenceException ex) {
				session.rollback();
			} finally {
				session.close();
			}
			return cnt;

		}
	@Override
	public int deletePayment(int paymentNum) {

		SqlSession session = MyBatisUtil.getSqlSession();

		int cnt = 0;

		try {
			cnt = session.delete("payment.deletepayment", paymentNum);

			if (cnt > 0) {
				session.commit();
			}

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public PaymentVO getPayment(String memEmail) {
		
		SqlSession session = MyBatisUtil.getSqlSession(true);
		PaymentVO pv = new PaymentVO();
		int credditQty = 0;
		try {
			pv = session.selectOne("payment.getpayment", memEmail);
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return pv;
	
	}
}
