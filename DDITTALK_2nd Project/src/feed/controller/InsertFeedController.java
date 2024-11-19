package feed.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/feedinsert.do")
public class InsertFeedController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 피드등록 코드 생성
		req.setAttribute("FeedInsertCd", "insert");

		// RequestDispatcher객체가 요청을 원하는 위치로 전달하게 함
		RequestDispatcher disp = req.getRequestDispatcher("/views/feed/feedInsert.jsp");
		disp.forward(req, resp);
		return;

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memEmail = req.getParameter("memEmail");
		String feedContent = req.getParameter("feedContent");
		String feedDisplay = req.getParameter("feedDisplay");

		if (feedContent == null) {
			feedContent = "";
		}

		IFeedService feedService = FeedServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();

		AtchFileVO atchFileVO = fileService.saveAtchFileList(req.getParts());

		FeedVO fv = new FeedVO(memEmail, feedContent, feedDisplay);

		long fileId = -1;
		fv.setAtchFileId(fileId);

		if (atchFileVO != null) {
			fv.setAtchFileId(atchFileVO.getAtchFileId());
		}

		int rst = feedService.feedInsert(fv);

		resp.sendRedirect(req.getContextPath() + "/mainpage.do");
		return;
	}

}
