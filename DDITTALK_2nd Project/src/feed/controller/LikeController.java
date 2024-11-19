package feed.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.LikeVO;
import feed.service.FeedServiceImpl;
import feed.service.IFeedService;

@WebServlet("/likecontroller.do")
public class LikeController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IFeedService feedService = FeedServiceImpl.getInstance();
		
		int feedNum = Integer.parseInt(req.getParameter("feedNum"));
		String memEmail = (String) req.getParameter("memEmail");
		
		LikeVO lv = new LikeVO(feedNum, memEmail);
		
		int cnt = feedService.likeFinder(lv);
		
		resp.getWriter().print(cnt);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
		
	}

}
