package pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.MemberVO;
import VO.PaymentVO;

@WebServlet("/payinfo.do")
public class PayInfoController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
//		MemberVO mv = (MemberVO)httpSession.getAttribute("LOGIN_USER");

		String credditInfo = (String)req.getParameter("creddit");
		
		System.out.println(credditInfo);
		
		String[] cArr = credditInfo.split(" ");
		
		int credditNum = 1;
		
		int credditQty = Integer.parseInt(cArr[0]);
		
		String memEmail = (String) req.getParameter("memEmail");

		int paymentNum = Integer.parseInt(req.getParameter("memEmail"));
		
		PaymentVO pv = new PaymentVO(credditQty,credditNum,memEmail);
		
		httpSession.setAttribute("payInfo", pv);
		
		req.getRequestDispatcher(req.getContextPath()+"/views/pay/paymentList.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
