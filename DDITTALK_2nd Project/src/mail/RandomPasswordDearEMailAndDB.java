package mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.MemberVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;

@WebServlet("/rpdeadb.do")
public class RandomPasswordDearEMailAndDB extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static String MAILID = "ddittalk@naver.com";
	private final static String PASSWORD = "javajava!";

	public RandomPasswordDearEMailAndDB() {
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/member/findPass.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IMemberService memService = MemberServiceImpl.getInstance();
		String to = req.getParameter("to");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String ranPass = RandomStringGenerator.generateRandomString(12);
		MemberVO mv = new MemberVO();

		mv.setMemPass(ranPass);
		mv.setMemEmail(to);
		mv.setMemName(memName);
		mv.setMemTel(memTel);

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.naver.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.naver.com");

		int cnt = memService.findUpdatePass(mv);

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MAILID, PASSWORD);
			}
		});

		String msg = "";

		try {

			if (cnt > 0) {
				msg = "success";

				resp.setContentType("application/json");

				resp.getWriter().print("{\"memPass\": \"" + ranPass + "\"}");

			} else {
				msg = "fail";
			}
			System.out.println(to);
			req.getSession().setAttribute("msg", msg);

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(MAILID));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject("[Subject] Java Mail RanPassTest");

			message.setText("\n비밀번호 랜덤 문자열 생성 결과는 [" + ranPass + "]이니 \n\n로그인 후 내정보에서 변경해주세요");

			Transport.send(message);
			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
