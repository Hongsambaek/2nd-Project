package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.MemberVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;

@MultipartConfig
@WebServlet("/findid.do")
public class FindIdController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/member/findId.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");

		IMemberService memService = MemberServiceImpl.getInstance();

		MemberVO mv = new MemberVO();

		mv.setMemName(memName);
		mv.setMemTel(memTel);

		String memEmail = memService.findId(mv);

		String msg = "";

		int cnt = 0;

		if (cnt > 0)
			msg = "ok";
		else
			msg = "fail";

		req.getSession().setAttribute("msg", msg);

		// 서비스객체 얻기

		System.out.println(memEmail);

		// $.ajax
		resp.setContentType("application/json");

		resp.getWriter().print("{\"memEmail\": \"" + memEmail + "\"}");

	}
}
