package file.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		fileSizeThreshold = 1024*1024*3,
		maxFileSize = 1024*1024*40,
		maxRequestSize = 1024*1024*50)
@WebServlet("/fileup.do")
public class FileUploadController extends HttpServlet {
	
	private static final String UPLOAD_DIR = "uploadImages";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		// Multipart 파싱전 파라미터 정보 가져오기
		System.out.println("Multipart 파싱 전 sender : " + req.getParameter("sender"));

		String uploadPath = req.getServletContext().getRealPath("/") + File.separator + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			String fileName = "";
			for (Part part : req.getParts()) {
				System.out.println(part.getHeader("Content-Disposition"));
//				fileName = getFileName(part);
				
				fileName = part.getSubmittedFileName();
				
				if (fileName != null && !fileName.equals("")) {
					
					part.write(uploadPath + File.separator + fileName);
					
					System.out.println("업로드 처리 완료...");
					System.out.println(uploadPath + File.separator);
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	private String getFileName(Part part) {

		for (String content : part.getHeader("Content-Disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
			}
		}

		return null;
		
	}
}
