package pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.PaymentVO;
import pay.service.IPaymentService;
import pay.service.PaymentServiceImpl;

@MultipartConfig
@WebServlet("/deletepayment.do")
public class DeletePaymentController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memEmail = req.getParameter("memEmail");
	
		IPaymentService paymentService = PaymentServiceImpl.getInstance();

		PaymentVO pv = (PaymentVO) paymentService.paymentList();

		req.setAttribute("pv", pv);

		req.getRequestDispatcher("/updatePayment.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int paymentNum = Integer.parseInt(req.getParameter("paymentNum"));


		IPaymentService paymentService = PaymentServiceImpl.getInstance();


		int cnt = paymentService.deletePayment(paymentNum);

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

}
