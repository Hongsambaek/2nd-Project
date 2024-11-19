package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ComplainServiceImpl;
import com.service.IComplainService;

import VO.ComplainVO;

@WebServlet("/comdelete.do")
public class ComplainDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String memEmail = "admin@ddit.talk";
		int comNum = Integer.valueOf(req.getParameter("comNum"));
		IComplainService comService = ComplainServiceImpl.getInstance();	
		int cnt = comService.deleteComplain(comNum);
		String msg = "";
		if(cnt > 0) {
			msg = "complete";
		} 
		req.getSession().setAttribute("msg", msg);
	
		resp.sendRedirect(req.getContextPath()+"/comadmin.do");	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
}
