package file.service;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import VO.AtchFileDetailVO;
import VO.AtchFileVO;

public interface IAtchFileService {
	/**
	 * 첨부파일목록을 저장하기 위한 메서드
	 * @param parts Part객체를 담은 컬렉션
	 * @return atchFileId를 담은 AtchFileVO객체
	 */
	public AtchFileVO saveAtchFileList(Collection<Part> parts);
	
	/**
	 * 첨부파일 목록을 조회하기 위한 메서드
	 * @param fileVO 첨부파일 목록을 담은 AtchFileVO객체
	 * @return 첨부파일 목록을 담은 AtchFileVO객체
	 */
	public AtchFileVO getAtchFile(AtchFileVO fileVO);
	
	/**
	 * 첨부파일 상세정보를 조회하기 위한 메서드(다운로드 처리시 사용)
	 * @param atchFileDetailVO atchFileId 및 fileSn을 담은 객체
	 * @return 상세정보를 담은 AtchFileDetailVO 객체
	 */
	public AtchFileDetailVO getAtchFileDetail(AtchFileDetailVO atchFileDetailVO);
	
	/**
	 * 첨부파일 상세정보 리스트를 가져오기 위한 메서드
	 * @return
	 */
	public List<AtchFileDetailVO> getAtchFileDetailList();
	
	public String getName(long fileId);
	
	public String getStre(long fileId);
}
