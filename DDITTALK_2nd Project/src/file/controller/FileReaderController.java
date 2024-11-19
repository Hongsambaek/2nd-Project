package file.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.service.AtchFileServiceImpl;
import file.service.IAtchFileService;

@WebServlet("/filereader.do")
public class FileReaderController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		long fileId = Long.parseLong(req.getParameter("fileId"));
		
		String fileName = fileService.getName(fileId);
		
		resp.getWriter().print(fileName);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
