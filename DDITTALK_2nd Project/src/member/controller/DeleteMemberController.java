package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.MemberVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;

@MultipartConfig
@WebServlet("/deletemember.do")
public class DeleteMemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		if (httpSession.getAttribute("LOGIN_USER") == null) {
			resp.sendRedirect(req.getContextPath() + "/login.do");
		}

		String memEmail = req.getParameter("memEmail");
		String memPass = req.getParameter("memPass");

		MemberVO mv = new MemberVO();

		mv.setMemEmail(memEmail);
		mv.setMemPass(memPass);

		IMemberService memService = MemberServiceImpl.getInstance();

		int cnt = memService.removeMember(mv);

		String msg = "";

		if (cnt > 0) {
			// 회원정보 삭제처리 성공...
			msg = "ok";
		} else {
			// 회원정보 삭제처리 실패...
			msg = "FAIL";
		}

		req.setAttribute("msg", msg);

		req.getSession().setAttribute("msg", msg);

		resp.sendRedirect(req.getContextPath() + "/login.do");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
