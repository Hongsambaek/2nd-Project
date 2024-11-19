package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.MemberVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;

@MultipartConfig
//@WebServlet("/findpass.do")
public class FindPassController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/member/findPass.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memEmail = req.getParameter("memEmail");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");

		IMemberService memService = MemberServiceImpl.getInstance();

		MemberVO mv = new MemberVO();
		mv.setMemName(memEmail);
		mv.setMemName(memName);
		mv.setMemTel(memTel);

		int cnt = memService.findUpdatePass(mv);

		String msg = "";

		if (cnt > 0) {
			msg = "ok";
			req.getRequestDispatcher("/rpdeadb.do");

			resp.setContentType("application/json");

			resp.getWriter().print("{\"memPass\": \"" + cnt + "\"}");

		} else
			msg = "fail";

		req.getSession().setAttribute("msg", msg);

		// 서비스객체 얻기

		// $.ajax

	}
}
