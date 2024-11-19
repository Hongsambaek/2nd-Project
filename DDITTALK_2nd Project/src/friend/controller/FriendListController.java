package friend.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import VO.FriendVO;
import VO.MemberVO;
import file.service.AtchFileServiceImpl;
import file.service.IAtchFileService;
import friend.service.FriendServiceImpl;
import friend.service.IFriendService;

@WebServlet("/friendlist.do")
public class FriendListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();

		if (httpSession.getAttribute("LOGIN_USER") == null) {

			req.getRequestDispatcher("/login.do").forward(req, resp);

		} else {

			MemberVO mv = (MemberVO) httpSession.getAttribute("LOGIN_USER");
			String memEmail = mv.getMemEmail();


			IFriendService frdService = FriendServiceImpl.getInstance();
			System.out.println(memEmail);
			List<FriendVO> frdList = frdService.getFriendList(memEmail);
			List<AtchFileDetailVO> fileList = fileService.getAtchFileDetailList();
			
			req.setAttribute("frdList", frdList);
			Gson gson = new Gson();
			JsonObject jsonObject = new JsonObject();
			
			jsonObject.add("friendList", gson.toJsonTree(frdList));
			jsonObject.add("fileList", gson.toJsonTree(fileList));
			
			PrintWriter out = resp.getWriter();
			out.print(jsonObject);
			out.flush();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
