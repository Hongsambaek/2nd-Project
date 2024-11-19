package friend.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.FriendVO;
import VO.MemberVO;
import friend.service.FriendServiceImpl;
import friend.service.IFriendService;

@WebServlet("/insertfnd.do")
public class InsertFriendController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		if (httpSession.getAttribute("LOGIN_USER") == null) {
			resp.sendRedirect(req.getContextPath() + "/login.do");
			return;
		}

		MemberVO mv = (MemberVO) httpSession.getAttribute("LOGIN_USER");
		String memEmail = mv.getMemEmail();
		String memTag = mv.getMemTag();
		String memEmail2 = req.getParameter("memEmail2");
		String memTag2 = req.getParameter("memTag2");

		FriendVO fv = new FriendVO();
		fv.setMemEmail(memEmail);
		fv.setMemTag1(memTag);
		fv.setMemEmail2(memEmail2);
		fv.setMemTag2(memTag2);

		System.out.println(fv.toString());

		System.out.println(fv.getMemEmail());
		System.out.println(fv.getMemEmail2());
		IFriendService fndService = FriendServiceImpl.getInstance();

		int cnt = fndService.addFriend(fv);

		String msg = "";

		if (cnt > 0) {
			// 회원정보 등록처리 성공...
			msg = "ok";
		} else {
			// 회원정보 등록처리 실패...
			msg = "FAIL";
		}

		req.getSession().setAttribute("msg", msg);

		// 포워딩 처리하기...
		// req.getRequestDispatcher("/member/list.do").forward(req, resp);

		// redirect(리다이렉트) 처리하기..
		resp.sendRedirect(req.getContextPath() + "/mainpage.do");
	}

}
