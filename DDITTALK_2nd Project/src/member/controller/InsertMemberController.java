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
@WebServlet("/memberinsert.do")
public class InsertMemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/member/insertForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String check = req.getParameter("check");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String memEmail = req.getParameter("memEmail");
		String memPass = req.getParameter("memPass");
		String memTag = req.getParameter("memTag");
		int memPost = Integer.parseInt(req.getParameter("memPost"));
		String memAdd1 = req.getParameter("memAddr");
		String memAdd2 = req.getParameter("memDetailAddr");
		String memSchool = req.getParameter("memSchool");
		String memNickname = req.getParameter("memNickname");
		String memAddr = memAdd1 + " " + memAdd2;
		IMemberService memService = MemberServiceImpl.getInstance();
		System.out.println(check);
		// 첨부파일 저장하기

		MemberVO mv = new MemberVO();
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemEmail(memEmail);
		mv.setMemPass(memPass);
		mv.setMemTag(memTag);
		mv.setMemPost(memPost);
		mv.setMemAddr(memAddr);
		mv.setMemSchool(memSchool);
		mv.setMemNickname(memNickname);

		int cnt = memService.registerMember(mv);

		String msg = "";

		if (cnt > 0) {
			// 회원정보 등록처리 성공...
			msg = "ok";
		} else {
			// 회원정보 등록처리 실패...
			msg = "FAIL";
		}

		req.getSession().setAttribute("msg", msg);

		resp.sendRedirect(req.getContextPath() + "/login.do");
	}

}