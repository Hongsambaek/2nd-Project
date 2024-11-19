package pay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.CredditVO;
import VO.PaymentVO;
import pay.service.IPaymentService;
import pay.service.PaymentServiceImpl;

@MultipartConfig
@WebServlet("/pay.do")
public class PayListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String credit = req.getParameter("credit");
		
		
		System.out.println(credit);


		req.setAttribute("credit", credit);
		

		req.getRequestDispatcher("/views/pay/paymentList.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
