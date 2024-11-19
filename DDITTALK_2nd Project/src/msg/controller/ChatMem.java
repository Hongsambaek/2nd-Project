package msg.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import VO.MemberVO;
import VO.MessageVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import msg.service.IMsgService;
import msg.service.MsgServiceImpl;

@WebServlet("/msg/mem.do")
public class ChatMem extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();

		MemberVO mv10 = (MemberVO) httpSession.getAttribute("LOGIN_USER");

		String memEmail = mv10.getMemEmail();

		IMsgService msgService = MsgServiceImpl.getInstance();
		MessageVO mv = new MessageVO();
		String lastDate = req.getParameter("lastDate");
		mv.setMemEmail(memEmail);
		if (lastDate != null && !lastDate.equals("")) {
			String[] parts = lastDate.split("@");
			int year = Integer.parseInt(parts[0]);
			int month = Integer.parseInt(parts[1]);
			int day = Integer.parseInt(parts[2]);
			int hour = Integer.parseInt(parts[3]);
			int minute = Integer.parseInt(parts[4]);
			int second = Integer.parseInt(parts[5]);
			mv.setMsgDate(LocalDateTime.of(year, month, day, hour, minute, second));
		}

		List<MessageVO> recentList = msgService.recentMsg(mv);

		IMemberService memService = MemberServiceImpl.getInstance();

		List<MemberVO> tagList = memService.getTag();

//		req.setAttribute("tagList", tagList);
//		req.setAttribute("recentList", recentList);

		List<JsonObject> jsonResponse = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		for (MessageVO mv5 : recentList) {
			for (MemberVO mm : tagList) {
				if (mv5.getMemEmail2().equals(mm.getMemEmail())) {
					JsonObject jsonObject = new JsonObject();
					jsonObject.addProperty("email", mv5.getMemEmail2());
					jsonObject.addProperty("name", mm.getMemName());
					jsonObject.addProperty("content", mv5.getMsgContent());
					jsonObject.addProperty("date", mv5.getMsgDate().format(formatter));
					jsonResponse.add(jsonObject);

				}
			}
		}

		Gson gson = new Gson();
		String jsonMem = gson.toJson(jsonResponse);

		resp.setContentType("application/json"); // 없어되는데 우리가 친절하게 알려줌 ㅎㅎ
		resp.getWriter().print(jsonMem);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}
}
