package fnd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.FriendVO;
import fnd.service.FndServiceImpl;
import fnd.service.IFndService;

@WebServlet("/fndlist.do")
public class fndList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession httpSession = req.getSession();
//		if (httpSession.getAttribute("LOGIN_USER") != null) {
//			String memEmail = req.getParameter("memEmail");
//			IFndService fndService = FndServiceImpl.getInstance();
//			List<FriendVO> fndList = fndService.getFnd(memEmail);
//			
//			List<FriendVO> fndList2 = new ArrayList<FriendVO>();
//			FriendVO fv2 = new FriendVO();
//			for(FriendVO fv : fndList) {
//				int i = 0;
//				if(!(memEmail.equals(fv.getMemEmail()))) {
//					fv2.setMemEmail2(fv.getMemEmail());
//					fndList2.set(i, fv2);
//				}
//				if(!(memEmail.equals(fv.getMemEmail2()))) {
//					fv2.setMemEmail2(fv.getMemEmail2());
//					fndList2.set(i, fv2);
//				} i++;
//			}
//			for(FriendVO fv3 : fndList2) {
//				System.out.println(fv3.toString());
//			}
//			req.setAttribute("fndList", fndList);
//			req.getRequestDispatcher("views/friend/fndList.jsp").forward(req, resp);
//
//			
//		} else {
//			resp.sendRedirect(req.getContextPath() + "/login.do");
//		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	}
}
