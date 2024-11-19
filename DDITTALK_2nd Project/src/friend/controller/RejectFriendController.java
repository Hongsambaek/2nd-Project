package friend.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.FriendVO;
import friend.service.FriendServiceImpl;
import friend.service.IFriendService;

@WebServlet("/rejectfnd.do")
public class RejectFriendController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IFriendService fndService = FriendServiceImpl.getInstance();

		FriendVO fv = new FriendVO();

		String memEmail2 = req.getParameter("memEmail2");
		String memEmail = req.getParameter("memEmail");
		int friendListNum = Integer.parseInt(req.getParameter("friendListNum"));

		req.setAttribute("fv", fv);

		req.getRequestDispatcher("/views/member/updateForm.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
