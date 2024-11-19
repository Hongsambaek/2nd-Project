package friend.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.FriendVO;
import file.service.AtchFileServiceImpl;
import file.service.IAtchFileService;
import friend.service.FriendServiceImpl;
import friend.service.IFriendService;

@WebServlet("/deletefnd.do")
public class DeleteFriendController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		IAtchFileService fileService = AtchFileServiceImpl.getInstance();

		if (httpSession.getAttribute("LOGIN_USER") == null) {

			req.getRequestDispatcher("/login.do").forward(req, resp);

		} else {

			String memEmail = req.getParameter("memEmail");
			String memEmail2 = req.getParameter("memEmail2");
			int friendListNum = Integer.parseInt(req.getParameter("friendListNum"));

			FriendVO fv = new FriendVO();

			fv.setMemEmail(memEmail2);
			fv.setMemEmail2(memEmail2);
			fv.setFriendListNum(friendListNum);

			IFriendService fndService = FriendServiceImpl.getInstance();

			int cnt = fndService.deleteMember(fv);
			String msg = "";

			if (cnt > 0) {
				// 회원정보 삭제처리 성공...
				msg = "SUCCESS";
			} else {
				// 회원정보 삭제처리 실패...
				msg = "FAIL";
			}

			req.setAttribute("msg", msg);

			req.getSession().setAttribute("msg", msg);

			req.getRequestDispatcher("/.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
