package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.MemberVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;

public class DisplayAllMemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 서비스 객체 생성하기
		IMemberService memService = MemberServiceImpl.getInstance();

		List<MemberVO> memList = memService.getAllMember();

		req.setAttribute("memList", memList);

		req.getRequestDispatcher("/views/member/list.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
