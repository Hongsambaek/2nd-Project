package VO;

public class AtchFileDetailVO implements Comparable<AtchFileDetailVO> {
	private long atchFileId = -1; /* 첨부파일ID */
	private int fileSn = 1; /* 파일순번 */
	private String fileStreCours; /* 파일저장경로 */
	private String streFileNm; /* 저장파일명 */
	private String orignlFileNm; /* 원본파일명 */
	private String fileExtsn; /* 파일확장자 */
	private String fileCn; /* 파일내용 */
	private long fileSize; /* 파일크기 */

	public AtchFileDetailVO(long atchFileId, int fileSn, String fileStreCours, String streFileNm, String orignlFileNm,
			String fileExtsn, String fileCn, long fileSize) {
		super();
		this.atchFileId = atchFileId;
		this.fileSn = fileSn;
		this.fileStreCours = fileStreCours;
		this.streFileNm = streFileNm;
		this.orignlFileNm = orignlFileNm;
		this.fileExtsn = fileExtsn;
		this.fileCn = fileCn;
		this.fileSize = fileSize;
	}

	public AtchFileDetailVO() {
	}

	public long getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}

	public int getFileSn() {
		return fileSn;
	}

	public void setFileSn(int fileSn) {
		this.fileSn = fileSn;
	}

	public String getFileStreCours() {
		return fileStreCours;
	}

	public void setFileStreCours(String fileStreCours) {
		this.fileStreCours = fileStreCours;
	}

	public String getStreFileNm() {
		return streFileNm;
	}

	public void setStreFileNm(String streFileNm) {
		this.streFileNm = streFileNm;
	}

	public String getOrignlFileNm() {
		return orignlFileNm;
	}

	public void setOrignlFileNm(String orignlFileNm) {
		this.orignlFileNm = orignlFileNm;
	}

	public String getFileExtsn() {
		return fileExtsn;
	}

	public void setFileExtsn(String fileExtsn) {
		this.fileExtsn = fileExtsn;
	}

	public String getFileCn() {
		return fileCn;
	}

	public void setFileCn(String fileCn) {
		this.fileCn = fileCn;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "AtchFileDetailVO [atchFileId=" + atchFileId + ", fileSn=" + fileSn + ", fileStreCours=" + fileStreCours
				+ ", streFileNm=" + streFileNm + ", orignlFileNm=" + orignlFileNm + ", fileExtsn=" + fileExtsn
				+ ", fileCn=" + fileCn + ", fileSize=" + fileSize + "]";
	}

	@Override
	public int compareTo(AtchFileDetailVO o) {
		return (Long.compare(this.getAtchFileId(), o.getAtchFileId()) * -1);
	}

}
