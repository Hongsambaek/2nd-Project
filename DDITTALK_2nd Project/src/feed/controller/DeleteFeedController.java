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

@WebServlet("/feeddelete.do")
public class DeleteFeedController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int feedNum = Integer.parseInt(req.getParameter("feedNum"));
		
		IFeedService feedService = FeedServiceImpl.getInstance();
		
		int fv = feedService.feedDelete(feedNum);
		
		String msg = "";
		
		if(fv > 0) {
			// 게시물 삭제처리 성공...
			msg = "SUCCESS";
		}else {
			// 게시물 삭제 처리 실패...
			msg = "FAIL";
		}
		resp.getWriter().print(msg);
		
	}

}
