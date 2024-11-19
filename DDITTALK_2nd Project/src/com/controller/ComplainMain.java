package com.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/complain.do")
public class ComplainMain extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession httpSession = req.getSession();
		
		if(httpSession.getAttribute("LOGIN_USER") != null) {
		MemberVO mv = (MemberVO)httpSession.getAttribute("LOGIN_USER");
		String memEmail = mv.getMemEmail();
		
		IComplainService comService = ComplainServiceImpl.getInstance();

		List<ComplainVO> comList = comService.getMemComplain(memEmail);
		
		req.setAttribute("comList", comList);
		
		req.getRequestDispatcher("views/complain/comMain.jsp").forward(req, resp);
		
		} else {
			
			resp.sendRedirect(req.getContextPath()+"/login.do");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		doGet(req, resp);	
	}
	
}
