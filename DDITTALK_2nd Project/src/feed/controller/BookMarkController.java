package feed.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.BookmarkVO;
import VO.LikeVO;
import feed.service.FeedServiceImpl;
import feed.service.IFeedService;

@WebServlet("/bookmarkcontroller.do")
public class BookMarkController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IFeedService feedService = FeedServiceImpl.getInstance();
		
		int feedNum = Integer.parseInt(req.getParameter("feedNum"));
		String memEmail = (String) req.getParameter("memEmail");
		
		BookmarkVO bv = new BookmarkVO(feedNum, memEmail);
		
		String res = feedService.bookMarkFinder(bv);
		
		resp.getWriter().print(res);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
		
	}

}
