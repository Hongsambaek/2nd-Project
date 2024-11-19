package file.dao;

import java.util.List;

import VO.AtchFileDetailVO;
import VO.AtchFileVO;

public interface IAtchFileDao {
	/**
	 * 첨부파일 저장
	 * @param atchFileVO
	 * @return
	 */
	public int insertAtchFile(AtchFileVO atchFileVO);
	
	/**
	 * 첨부파일 세부정보 저장
	 * @param atchFileVO
	 * @return
	 */
	public int insertAtchFileDetail(AtchFileDetailVO atchFileDetailVO);
	
	/**
	 * 첨부파일 목록 조회하기
	 * @param atchFileVO
	 * @return
	 */
	public AtchFileVO getAtchFile(AtchFileVO atchFileVO);
	
	/**
	 * 상세첨부파일 정보 조회하기
	 * @param atchFileDetailVO
	 * @return
	 */
	public AtchFileDetailVO getAtchFileDetail(AtchFileDetailVO atchFileDetailVO);
	
	/**
	 * 상세첨부파일 리스트 조회하기
	 * @return
	 */
	public List<AtchFileDetailVO> getAtchFileDetailList();

	public String getName(long fileId);

	public String getStre(long fileId);
	
	
	
	
	
}
