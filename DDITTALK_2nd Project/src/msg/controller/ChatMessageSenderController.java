package msg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.MemberVO;
import VO.MessageVO;
import msg.service.IMsgService;
import msg.service.MsgServiceImpl;

@WebServlet("/msg/sender.do")
public class ChatMessageSenderController extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession httpSession = req.getSession();

	  MemberVO mv10 = (MemberVO) httpSession.getAttribute("LOGIN_USER");
		
	  String memEmail = mv10.getMemEmail();
//      String memEmail = "test1"; // 상대방 파라미터 담기
      String memEmail2 = req.getParameter("memEmail2");
      String msgContent = req.getParameter("msgContent");
      
      
      
      
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
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req, resp);
   }
}
