package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ComplainServiceImpl;
import com.service.IComplainService;

import VO.ComplainVO;
import VO.MemberVO;

@WebServlet("/comdetail.do")
public class ComplainDetail extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		MemberVO mv85 = (MemberVO)httpSession.getAttribute("LOGIN_USER");
			
		if(mv85.getMemEmail().equals("admin")) {
			
		}
			
		
		int comNum = Integer.valueOf(req.getParameter("comNum"));
		IComplainService comService = ComplainServiceImpl.getInstance();
		
		ComplainVO cv = comService.getInComplain(comNum);
		
		req.setAttribute("cv", cv);
		req.getRequestDispatcher("views/complain/comDetail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String comAns = req.getParameter("comAns");
		int comNum = Integer.valueOf(req.getParameter("comNum"));
		
		ComplainVO cv = new ComplainVO();
		cv.setComAns(comAns);
		cv.setComNum(comNum);
		IComplainService comService = ComplainServiceImpl.getInstance();
		int cnt = comService.answerComplain(cv);
		if(cnt > 0 ) {
			System.out.println("updated answer");
		} else {
			System.out.println("not updated answer ");
		}
		
		resp.sendRedirect(req.getContextPath() + "/comadmin.do");
	}
	
}
