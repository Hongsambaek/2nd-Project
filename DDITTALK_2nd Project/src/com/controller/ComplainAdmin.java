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

@WebServlet("/comadmin.do")
public class ComplainAdmin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		HttpSession httpSession = req.getSession();
		MemberVO mv = (MemberVO)httpSession.getAttribute("LOGIN_USER");
		String memEmail = mv.getMemEmail();
		
		if(memEmail.equals("admin")) {
			memEmail = req.getParameter("memEmail");
		}
		
		System.out.println("mail : " + memEmail);
		IComplainService comService = ComplainServiceImpl.getInstance();	
		List<ComplainVO> comList = comService.getAdComplain(memEmail);
		req.setAttribute("comList", comList);
	
		req.getRequestDispatcher("views/complain/comAdmin.jsp").forward(req, resp);
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
