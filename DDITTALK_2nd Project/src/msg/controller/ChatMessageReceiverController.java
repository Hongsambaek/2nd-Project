package msg.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import VO.MemberVO;
import VO.MessageVO;
import msg.service.IMsgService;
import msg.service.MsgServiceImpl;

@WebServlet("/msg/receiver.do")

public class ChatMessageReceiverController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();

		MemberVO mv10 = (MemberVO) httpSession.getAttribute("LOGIN_USER");
			
		String memEmail = mv10.getMemEmail();
		
		String memEmail2 = req.getParameter("memEmail2"); //상대방 파라미터 담기
				
		String lastDate = req.getParameter("lastDate");
		System.out.println("lastDate =>" + lastDate); 
		
		
		MessageVO mv = new MessageVO();
		
		mv.setMemEmail(memEmail);
		mv.setMemEmail2(memEmail2);
	
		if(lastDate != null && !lastDate.equals("") ) {
			String[] parts = lastDate.split("@");
			int year = Integer.parseInt(parts[0]);
			int month = Integer.parseInt(parts[1]);
			int day = Integer.parseInt(parts[2]);
			int hour = Integer.parseInt(parts[3]);
			int minute = Integer.parseInt(parts[4]);
			int second = Integer.parseInt(parts[5]);
			mv.setMsgDate(LocalDateTime.of(year, month, day, hour, minute, second));
		} 
				
		IMsgService msgService = MsgServiceImpl.getInstance();
		
		List<MessageVO> msgList = msgService.getAllMsg(mv);
		
		if(msgList.size() > 0) {
			
//			req.getSession().setAttribute("LAST_MESSAGE_DATE", msgList.get(msgList.size() -1).getMsgDate());
		}
		
		req.setAttribute("msgList", msgList);
		
		
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(msgList);
		
		//req.getRequestDispatcher("views/msg/msg.jsp").forward(req, resp);
		
		resp.setContentType("application/json"); //없어되는데 우리가 친절하게 알려줌 ㅎㅎ
		resp.getWriter().print(jsonData);
		
		

	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      HttpSession httpSession = req.getSession();
		  MemberVO mv10 = (MemberVO) httpSession.getAttribute("LOGIN_USER");
			
		  String memEmail = mv10.getMemEmail();

	      String memEmail2 = req.getParameter("memEmail2");
	      String msgContent = req.getParameter("msgContent");
	      System.out.println("------------------------------------------");
	      System.out.println(memEmail + memEmail2 + msgContent);
	      IMsgService msgService = MsgServiceImpl.getInstance();
	      
	      MessageVO mv = new MessageVO();
	      mv.setMemEmail(memEmail);
	      mv.setMemEmail2(memEmail2);
	      mv.setMsgContent(msgContent);
	      
	      int cnt = msgService.sendMsg(mv);
	      String result = ""; 
	      if(cnt > 0) {
	         result = "success";
	      } else {
	         result = "failed";
	      }
	      

	      resp.setContentType("application/json");
	      resp.getWriter().print("{\"result\": \"" + result + "\"}");
	}
}
