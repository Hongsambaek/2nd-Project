package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import VO.MemberVO;
import file.service.AtchFileServiceImpl;
import file.service.IAtchFileService;
import member.service.IMemberService;
import member.service.MemberServiceImpl;

@MultipartConfig
@WebServlet("/login.do")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/member/loginForm.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memEmail = req.getParameter("memEmail");
		String memPass = req.getParameter("memPass");

		// 그냥 로그인버튼 눌러도 실행되도록 설정한 코드이니 마지막에 삭제할 것★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
//		memEmail = "test1";
//		memPass = "test1";
		// 테스트기간 들어가면 필히 삭제할 것★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆

		// 서비스 생성
		IMemberService memService = MemberServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();

		MemberVO mv = memService.getMember(memEmail);

		boolean isAuthenticated = false; // 인증된 사용자 인지 여부

		if (mv != null) {

			if (memPass.equals(mv.getMemPass())) { // 패스워드 일치하는 경우...
				isAuthenticated = true;
			}

		}
		//////////////////////////////////////////////////////////////////////

		if (isAuthenticated) {
			// 세션에 로그인 정보 설정하기
			req.getSession().setAttribute("LOGIN_USER", mv);

			if (mv.getMemProfile() > 0) {
				long atchFileId = mv.getMemProfile();
				String stre = fileService.getStre(atchFileId);
				System.out.println("con\n" + stre + "\n");
				req.getSession().setAttribute("stre", stre);
			}

			// 멤버리스트 생성(정문성)
			List<MemberVO> memList = memService.getAllMember();

			Gson gson = new Gson();
			String jsonMemList = gson.toJson(memList);
			// 세션에 멤버리스트 저장(정문성)
			req.getSession().setAttribute("MEMBER_LIST", jsonMemList);

			System.out.println(mv);

			// 메인 페이지로 이동하기
			resp.sendRedirect(req.getContextPath() + "/mainpage.do");

		} else { // 인증 실패시...
			// 로그인 화면으로 이동
			resp.sendRedirect(req.getContextPath() + "/login.do");

		}
	}
}
