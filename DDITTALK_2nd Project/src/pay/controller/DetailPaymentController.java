package pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.PaymentVO;
import pay.service.IPaymentService;
import pay.service.PaymentServiceImpl;



public class DetailPaymentController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memEmail = req.getParameter("memEmail");

		IPaymentService paymentService = PaymentServiceImpl.getInstance();

		PaymentVO pv1 = paymentService.getPayment(memEmail);

		req.setAttribute("pv1", pv1);

		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
}
