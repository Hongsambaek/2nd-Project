package friend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import VO.MemberVO;
import friend.service.FriendServiceImpl;
import friend.service.IFriendService;

@WebServlet("/memtagsearch.do")
public class SearchTagController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IFriendService fndService = FriendServiceImpl.getInstance();

		String memTag = req.getParameter("memTag");
		System.out.println(memTag);
		System.out.println("1ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		List<MemberVO> searchList = fndService.getMemTagSearch(memTag);

		Gson gson = new Gson();
		String jsonData = gson.toJson(searchList);

		// req.getRequestDispatcher("views/msg/msg.jsp").forward(req, resp);

		resp.setContentType("application/json"); // 없어되는데 우리가 친절하게 알려줌 ㅎㅎ
		resp.getWriter().print(jsonData);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
