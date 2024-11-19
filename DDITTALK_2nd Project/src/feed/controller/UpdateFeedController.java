package feed.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.AtchFileVO;
import VO.FeedVO;
import feed.service.FeedServiceImpl;
import feed.service.IFeedService;
import file.service.AtchFileServiceImpl;
import file.service.IAtchFileService;

@MultipartConfig
@WebServlet("/feedupdate.do")
public class UpdateFeedController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int feedNum = Integer.parseInt(req.getParameter("feedNum"));
		
		IFeedService feedService = FeedServiceImpl.getInstance();
		
		FeedVO fv = feedService.feedDetail(feedNum);
		
		req.setAttribute("fv", fv);
		
		req.getRequestDispatcher("/feedupdate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int feedNum = Integer.parseInt(req.getParameter("feedNum"));
		String feedContent = req.getParameter("feedContent");
		String feedDisplay = req.getParameter("feedDisplay");
	
        IAtchFileService fileService = AtchFileServiceImpl.getInstance();

        AtchFileVO atchFileVO = fileService.saveAtchFileList(req.getParts());
		
		IFeedService feedService = FeedServiceImpl.getInstance();
		
		FeedVO fv = new FeedVO(feedNum, feedContent,feedDisplay);
		
		 if (atchFileVO != null) { // 새로운 업로드 파일을 선택한 경우
	         fv.setAtchFileId(atchFileVO.getAtchFileId());
	     }
		 
		 int cnt = feedService.feedUpdate(fv);
		 
		 resp.getWriter().print(cnt);
		
		resp.sendRedirect(req.getContextPath() + "/myinformation.do");
	}

}
