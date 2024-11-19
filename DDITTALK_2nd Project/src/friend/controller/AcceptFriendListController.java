package friend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import VO.FriendVO;
import VO.MemberVO;
import friend.service.FriendServiceImpl;
import friend.service.IFriendService;

@WebServlet("/acceptfndlist.do")
public class AcceptFriendListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		MemberVO mv981 = (MemberVO) httpSession.getAttribute("LOGIN_USER");
		String memEmail = mv981.getMemEmail();

		IFriendService fndService = FriendServiceImpl.getInstance();

		List<FriendVO> acceptList = fndService.getAcceptFriendList(memEmail);

		Gson gson = new Gson();
		String jsonData = gson.toJson(acceptList);

		// req.getRequestDispatcher("views/msg/msg.jsp").forward(req, resp);

		resp.setContentType("application/json"); // 없어되는데 우리가 친절하게 알려줌 ㅎㅎ
		resp.getWriter().print(jsonData);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memEmail2 = req.getParameter("memEmail");
		HttpSession httpSession = req.getSession();

		MemberVO mv981 = (MemberVO) httpSession.getAttribute("LOGIN_USER");

		String memEmail = mv981.getMemEmail();
		IFriendService friendService = FriendServiceImpl.getInstance();
		FriendVO fv = new FriendVO();
		fv.setMemEmail(memEmail2);
		fv.setMemEmail2(memEmail);
		friendService.acceptFriend(fv);

	}
}
