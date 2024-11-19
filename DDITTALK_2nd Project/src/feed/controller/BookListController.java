//package feed.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//
//import VO.FeedVO;
//import feed.service.FeedServiceImpl;
//import feed.service.IFeedService;
//import oracle.net.aso.g;
//
//@WebServlet("/booklist.do")
//public class BookListController extends HttpServlet{
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		IFeedService feedService = FeedServiceImpl.getInstance();
//		
//		String memEmail = req.getParameter("memEmail");
//		
//		List<FeedVO> bookList = feedService.myBookList(fv);
//		Gson gson = new Gson();
//		JsonObject jsonObject = new JsonObject();
//		
//		jsonObject.add("feedList", gson.toJsonTree(bookList));
//		
//		PrintWriter out = resp.getWriter();
//		out.print(gson.toJson(jsonObject));
//		out.flush();
//		
//	}
//}
