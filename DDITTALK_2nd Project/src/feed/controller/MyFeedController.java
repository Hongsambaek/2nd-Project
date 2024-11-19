package feed.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import VO.AtchFileDetailVO;
import VO.CommentVO;
import VO.FeedVO;
import VO.FriendVO;
import VO.MemberVO;
import comment.service.CommentServiceImpl;
import comment.service.ICommentService;
import feed.service.FeedServiceImpl;
import feed.service.IFeedService;
import file.service.AtchFileServiceImpl;
import file.service.IAtchFileService;
import fnd.service.FndServiceImpl;
import fnd.service.IFndService;

@WebServlet("/myfeed.do")
public class MyFeedController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		if (httpSession.getAttribute("LOGIN_USER") == null) {

			req.getRequestDispatcher("/login.do").forward(req, resp);

		} else {

			MemberVO mv = (MemberVO) httpSession.getAttribute("LOGIN_USER");
			String memEmail = mv.getMemEmail();

			IFndService fndService = FndServiceImpl.getInstance();
			List<FriendVO> fndList = fndService.getFnd(memEmail);
			System.out.println(fndList.toString());
			req.setAttribute("fndList", fndList);

			req.getRequestDispatcher("/main.jsp").forward(req, resp);

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IFeedService service = FeedServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		ICommentService commentService = CommentServiceImpl.getInstance();
		HttpSession httpSession = req.getSession();
		Gson gson = new Gson();
		String memEmail = "";
		MemberVO mv = (MemberVO) httpSession.getAttribute("LOGIN_USER");

		if (req.getAttribute("memEmail") != null) {
			memEmail = (String) req.getAttribute("memEmail");
		} else {
			memEmail = mv.getMemEmail();
		}

		List<AtchFileDetailVO> fileList = fileService.getAtchFileDetailList();
		List<FeedVO> feedList = service.memFeedSearch(memEmail);
		List<CommentVO> commentList = commentService.commentList();
		JsonObject jsonObject = new JsonObject();

		System.out.println(commentList.toString());

		Collections.sort(feedList);
		Collections.sort(fileList);

		jsonObject.add("feedList", gson.toJsonTree(feedList));
		jsonObject.add("fileList", gson.toJsonTree(fileList));
		jsonObject.add("commentList", gson.toJsonTree(commentList));

		resp.setContentType("application/json"); // 없어되는데 우리가 친절하게 알려줌 ㅎㅎ
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(jsonObject));
		out.flush();

//		req.getRequestDispatcher("/main.jsp").forward(req, resp);
//		return;
	}
}
