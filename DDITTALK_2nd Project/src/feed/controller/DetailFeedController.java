package feed.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.FeedVO;
import feed.service.FeedServiceImpl;
import feed.service.IFeedService;

@WebServlet("/FeedDetail")
public class DetailFeedController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int feedNum = Integer.parseInt(req.getParameter("feedNum"));
		
		IFeedService service = FeedServiceImpl.getInstance();
		
		FeedVO fv = service.feedDetail(feedNum);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
	
}
