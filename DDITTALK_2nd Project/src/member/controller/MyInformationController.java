package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import VO.BookmarkVO;
import VO.CommentVO;
import VO.FeedVO;
import VO.FriendVO;
import VO.LikeVO;
import VO.MemberVO;
import comment.service.CommentServiceImpl;
import comment.service.ICommentService;
import feed.service.FeedServiceImpl;
import feed.service.IFeedService;
import file.service.AtchFileServiceImpl;
import file.service.IAtchFileService;
import friend.service.FriendServiceImpl;
import friend.service.IFriendService;
import member.dao.IMemberDao;
import member.service.IMemberService;
import member.service.MemberServiceImpl;

@WebServlet("/myinformation.do")
public class MyInformationController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		if (httpSession.getAttribute("LOGIN_USER") == null) {

			req.getRequestDispatcher("/login.do").forward(req, resp);

		} else {

			req.getRequestDispatcher("/mypage.jsp").forward(req, resp);

			return;

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IFeedService service = FeedServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		ICommentService commentService = CommentServiceImpl.getInstance();
		IMemberService memberService = MemberServiceImpl.getInstance();
		IFriendService friendService = FriendServiceImpl.getInstance();

		List<AtchFileDetailVO> fileList = fileService.getAtchFileDetailList();
		List<FeedVO> feedList = new ArrayList<FeedVO>();
		List<CommentVO> commentList = commentService.commentList();
		List<LikeVO> allLikeList = service.allLikeList();
		List<LikeVO> likeSumList = service.likeSumList();
		List<BookmarkVO> bookMarkList = service.bookMarkList();
		MemberVO mv =(MemberVO)req.getSession().getAttribute("LOGIN_USER");
		List<FriendVO> friendList = friendService.getFriendList(mv.getMemEmail());
		String memEmail = "";
		
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();

		String startParam = req.getParameter("start");
		String endParam = req.getParameter("end");

		int start = 0;
		int end = 0;
		int feedCnt = 0;

		start = Integer.parseInt(startParam);
		end = Integer.parseInt(endParam);
		
		if (req.getParameter("search") != null) {

			String search = req.getParameter("search");
			FeedVO fv = new FeedVO(search, start, end);
			feedList = service.feedSearch(fv);

		} else if (req.getParameter("friend") != null) {

			memEmail = req.getParameter("friend");
			mv = memberService.getMember(memEmail);
			FeedVO fv = new FeedVO(memEmail, start, end);
			feedList = service.friendFeedLoader(fv);

		} else if (req.getParameter("my") != null) {
			end = 10000;
			memEmail = (String) req.getParameter("my");
			FeedVO fv = new FeedVO(memEmail, start, end);
			feedList = service.myFeedLoader(fv);

		} else if (req.getParameter("book") != null) {
			end = 10000;
			memEmail = req.getParameter("book");
			FeedVO fv = new FeedVO(memEmail, start, end);
			feedList = service.bookFeedLoader(fv);

		}

		Collections.sort(feedList);
		Collections.sort(fileList);
		Collections.sort(commentList);
		jsonObject.add("LOGIN_USER", gson.toJsonTree(mv));
		jsonObject.add("bookMarkList", gson.toJsonTree(bookMarkList));
		jsonObject.add("likeSumList", gson.toJsonTree(likeSumList));
		jsonObject.add("allLikeList", gson.toJsonTree(allLikeList));
		jsonObject.add("feedCnt", gson.toJsonTree(feedCnt));
		jsonObject.add("feedList", gson.toJsonTree(feedList));
		jsonObject.add("fileList", gson.toJsonTree(fileList));
		jsonObject.add("commentList", gson.toJsonTree(commentList));
		jsonObject.add("friendList", gson.toJsonTree(friendList));

		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(jsonObject));
		out.flush();

	}

}
