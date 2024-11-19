package feed.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.AtchFileDetailVO;
import VO.FeedVO;
import feed.service.FeedServiceImpl;
import feed.service.IFeedService;
import file.service.AtchFileServiceImpl;
import file.service.IAtchFileService;

@MultipartConfig
@WebServlet("/feedsearch.do")
public class SearchFeedController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String tag = req.getParameter("tag");
		
		req.setAttribute("search", tag);
				
		req.getRequestDispatcher("/mainpage.do").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
