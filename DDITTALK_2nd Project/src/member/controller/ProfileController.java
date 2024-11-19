package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.FeedVO;
import feed.service.FeedServiceImpl;
import feed.service.IFeedService;

@WebServlet("/profile.do")
public class ProfileController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		
		String memEmail = (String)httpSession.getAttribute("LOGIN_USER");

		IFeedService service = FeedServiceImpl.getInstance();

		List<FeedVO> feedList = service.memFeedSearch(memEmail);

		req.setAttribute("feedList", feedList);

		req.getRequestDispatcher("/views/feed/profile.jsp").forward(req, resp);


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

}
