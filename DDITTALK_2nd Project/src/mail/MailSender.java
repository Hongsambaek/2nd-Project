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

@WebServlet("/mailsender.do")
public class MailSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String MAILID = "ddittalk@naver.com"; // naver mail주소 입력
	private final static String PASSWORD = "javajava!"; // mail 비밀번호 입력

	public MailSender() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(1);
		Properties prop = new Properties();
		
		prop.put("mail.smtp.host", "smtp.naver.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.naver.com");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MAILID, PASSWORD);
			}
		});

		String to = request.getParameter("to");
		String vNum = request.getParameter("num");

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(MAILID));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject("[Subject] Java Mail Test");

			message.setText("\nSimple mail test.. your Validate Number is [" + vNum + "]\n\nPlease enter this number");

			Transport.send(message);
			System.out.println("message sent successfully...");
			response.getWriter().print(1);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
