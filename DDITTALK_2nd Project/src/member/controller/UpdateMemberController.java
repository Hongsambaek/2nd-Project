package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import VO.AtchFileVO;
import VO.MemberVO;
import file.service.AtchFileServiceImpl;
import file.service.IAtchFileService;
import member.service.IMemberService;
import member.service.MemberServiceImpl;

@MultipartConfig
@WebServlet("/updatemember.do")
public class UpdateMemberController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if (httpSession.getAttribute("LOGIN_USER") == null) {
            resp.sendRedirect(req.getContextPath() + "/login.do");
            return;
        }

        IMemberService memService = MemberServiceImpl.getInstance();

        MemberVO mv = (MemberVO) req.getSession().getAttribute("LOGIN_USER");

        req.setAttribute("mv", mv);

        if (mv.getMemProfile() > 0) { // 첨부파일이 존재하는 경우 -1 이상
            IAtchFileService fileService = AtchFileServiceImpl.getInstance();

            AtchFileVO atchFileVO = new AtchFileVO();
            atchFileVO.setAtchFileId(mv.getMemProfile());
            atchFileVO = fileService.getAtchFile(atchFileVO);

            req.setAttribute("atchFileVO", atchFileVO);
        }

        req.getRequestDispatcher("/views/member/updateMember.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String memEmail = req.getParameter("memEmail");
        String memPass = req.getParameter("memPass");
        String memTag = req.getParameter("memTag");
        String memNickname = req.getParameter("memNickname");
        String memTel = req.getParameter("memTel");
        int memPost = Integer.parseInt(req.getParameter("memPost"));
        String memAddr = req.getParameter("memAddr");
        String memSchool = req.getParameter("memSchool");

        IMemberService memService = MemberServiceImpl.getInstance();
        IAtchFileService fileService = AtchFileServiceImpl.getInstance();

        AtchFileVO atchFileVO = fileService.saveAtchFileList(req.getParts());

        MemberVO mv = (MemberVO) req.getSession().getAttribute("LOGIN_USER");

        mv.setMemPass(memPass);
        mv.setMemTag(memTag);
        mv.setMemNickname(memNickname);
        mv.setMemTel(memTel);
        mv.setMemPost(memPost);
        mv.setMemAddr(memAddr);
        mv.setMemSchool(memSchool);
        mv.setMemEmail(memEmail);

        if (atchFileVO != null) { // 새로운 업로드 파일을 선택한 경우
            mv.setMemProfile(atchFileVO.getAtchFileId());
        }

        int cnt = memService.modifyMember(mv);

        String msg = (cnt > 0) ? "ok" : "FAIL";
        
        mv = memService.getMember(memEmail);

        System.out.println(mv.getMemProfile()+"\r\r\r\r");
        
        req.getSession().setAttribute("LOGIN_USER", mv);
        req.getSession().setAttribute("msg", msg);

        resp.sendRedirect(req.getContextPath() + "/mypage.jsp");
    }
}
