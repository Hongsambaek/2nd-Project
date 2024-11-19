package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ComplainServiceImpl;
import com.service.IComplainService;

import VO.ComplainVO;
import VO.MemberVO;

@MultipartConfig
@WebServlet("/cominsert.do")
public class ComplainInsert extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("views/complain/comWrite.jsp").forward(req, resp);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
		
		String memEmail = mv.getMemEmail();
		String comMenu = req.getParameter("comMenu");
		String comTitle = req.getParameter("comTitle");
		String comContent = req.getParameter("comContent");
		
		IComplainService comService = ComplainServiceImpl.getInstance();
		
		ComplainVO cv = new ComplainVO();
		cv.setMemEmail(memEmail);
		cv.setComMenu(comMenu);
		cv.setComTitle(comTitle);
		cv.setComContent(comContent);
		
		int cnt = comService.insertComplain(cv);
		
		if(cnt > 0) {
			System.out.println("success");
		} else {
			System.out.println("failed");
		}
		resp.sendRedirect(req.getContextPath()+"/complain.do");
	
	}
}
