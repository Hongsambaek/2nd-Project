package pay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.CredditVO;
import VO.PaymentVO;
import creddit.service.CredditServiceImpl;
import creddit.service.ICredditService;
import pay.service.IPaymentService;
import pay.service.PaymentServiceImpl;

@WebServlet("/payinsert.do")
public class InsertPaymentController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ICredditService credditService = CredditServiceImpl.getInstance();
		
		List<CredditVO> credditList = credditService.credditList();
		
		int credditMoney = Integer.parseInt(req.getParameter("credditMoney"));
		
		String memEmail = req.getParameter("memEmail");
		
		int credditQty = 0;
		int credditNum = 0;
		
		for (CredditVO credditVO : credditList) {
			
			if(credditVO.getCredditMoney() == credditMoney) {
				credditQty = credditVO.getCredditQty();
				credditNum = credditVO.getCredditNum();
			}
			
		}

		
		PaymentVO pv = new PaymentVO(credditQty, credditNum, memEmail);
		
//		int credditNum = Integer.parseInt(req.getParameter("credditNum"));
//		String memEmail = req.getParameter("memEmail");
//		int credditQty = Integer.parseInt(req.getParameter("credditQty"));
//		int paymentNum = Integer.parseInt(req.getParameter("paymentNum"));

		IPaymentService paymentService = PaymentServiceImpl.getInstance();

		int cnt = paymentService.insertPayment(pv);

		String msg = "";

		if (cnt > 0) {
			// 회원정보 삭제처리 성공...
			msg = "SUCCESS";
		} else {
			// 회원정보 삭제 처리 실패...
			msg = "FAIL";
		}
		req.getSession().setAttribute("msg", msg);

		resp.sendRedirect(req.getContextPath() + "/mainpage.do");
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
