package comment.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import VO.CommentVO;
import comment.service.CommentServiceImpl;
import comment.service.ICommentService;

@WebServlet("/insertcomment.do")
public class CommentInsert extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ICommentService commentService = CommentServiceImpl.getInstance();
		
		BufferedReader reader = req.getReader();
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

		int feedNum = jsonObject.get("feedNum").getAsInt();
		String commentContent = jsonObject.get("commentContent").getAsString();
		String memEmail = jsonObject.get("memEmail").getAsString();

		System.out.println(feedNum+"  "+commentContent+"   "+memEmail);
		
		CommentVO cv = new CommentVO(feedNum, commentContent, memEmail);
		
		commentService.insertComment(cv);
		
		resp.setStatus(HttpServletResponse.SC_OK);

	}

}
