package file.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import VO.AtchFileDetailVO;
import VO.AtchFileVO;
import file.dao.AtchFileDaoImpl;
import file.dao.IAtchFileDao;

public class AtchFileServiceImpl implements IAtchFileService {
	private static final String UPLOAD_DIR = "upload_files";
	private static IAtchFileService fileService = new AtchFileServiceImpl();
	private static IAtchFileDao fileDao;

	public static IAtchFileService getInstance() {
		return fileService;
	}

	public AtchFileServiceImpl() {
		fileDao = AtchFileDaoImpl.getInstance();
	}

	@Override
	public AtchFileVO saveAtchFileList(Collection<Part> parts) {
		String uploadPath = "";
		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			uploadPath = "D:\\A_TeachingMaterial\\04_MiddelProject\\workspace\\DDITTALK\\WebContent\\images\\uploadImages";
		} else {
			uploadPath = "/Users/jeongmunseong/Desktop/mp/workspace/DDITTALK/WebContent/images/uploadImages";

		}
		// if(name.equals(박병준))
//		uploadPath = "E:\\A_TeachingMaterial\\04_MiddelProject\\DDITTALK\\WebContent\\images";

		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		AtchFileVO atchFileVO = null;
		boolean isFirstFile = true; // 첫번째 파일 여부
		for (Part part : parts) {

			String fileName = part.getSubmittedFileName();

			if (fileName != null && !fileName.equals("")) {
				if (isFirstFile) { // 첫번째 업로드 파일인지 chk
					isFirstFile = false;
					atchFileVO = new AtchFileVO();
					fileDao.insertAtchFile(atchFileVO); // atch_file에 insert
				}

				// 확장자 추출
				String fileExtension = fileName.lastIndexOf(".") < 0 ? ""
						: fileName.substring(fileName.lastIndexOf(".") + 1);

				long fileSize = part.getSize();
				String saveFileName = UUID.randomUUID().toString().replace("-", "") + "." + fileExtension;
				String saveFilePath = uploadPath + "/" + saveFileName;

				// 업로드파일 저장하기
				try {
					part.write(saveFilePath);
				} catch (IOException e) {
					e.printStackTrace();
				}
				AtchFileDetailVO atchFileDetailVO = new AtchFileDetailVO();

				atchFileDetailVO.setAtchFileId(atchFileVO.getAtchFileId());
				atchFileDetailVO.setStreFileNm(saveFileName);
				atchFileDetailVO.setFileSize(fileSize);
				atchFileDetailVO.setOrignlFileNm(fileName);
				atchFileDetailVO.setFileStreCours(saveFilePath);
				atchFileDetailVO.setFileExtsn(fileExtension);

				fileDao.insertAtchFileDetail(atchFileDetailVO); // 파일 세부정보 저장

				try {
					part.delete();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return atchFileVO;
	}

	@Override
	public AtchFileVO getAtchFile(AtchFileVO fileVO) {
		// TODO Auto-generated method stub
		return fileDao.getAtchFile(fileVO);
	}

	@Override
	public AtchFileDetailVO getAtchFileDetail(AtchFileDetailVO atchFileDetailVO) {
		// TODO Auto-generated method stub
		return fileDao.getAtchFileDetail(atchFileDetailVO);
	}

//	public static void main(String[] args) {
//		new AtchFileServiceImpl().daoTest();
//	}
	@Override
	public List<AtchFileDetailVO> getAtchFileDetailList() {

		return fileDao.getAtchFileDetailList();
	}

	@Override
	public String getName(long fileId) {
		return fileDao.getName(fileId);
	}
	
	@Override
	public String getStre(long fileId) {
		return fileDao.getStre(fileId);
	}
}
