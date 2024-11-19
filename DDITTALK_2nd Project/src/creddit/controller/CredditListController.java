package creddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.CredditVO;
import creddit.service.CredditServiceImpl;
import creddit.service.ICredditService;

@MultipartConfig
@WebServlet("/creddit.do")
public class CredditListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ICredditService credditService = CredditServiceImpl.getInstance();
		
		List<CredditVO> creList = credditService.credditList();
	
		req.setAttribute("creList", creList);
		
		
		req.getRequestDispatcher("/views/creddit/credditList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String credditQty = req.getParameter("credditQty");
		System.out.println(credditQty);
		
		resp.sendRedirect(req.getContextPath()+"/pay.do");
	}

}
