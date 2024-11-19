package VO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MessageVO implements Comparable<MessageVO> {
	private int msgNum;
	private String memEmail;
	private String memEmail2;
	private String msgContent;
	private long fileId;
	private LocalDateTime msgDate;

	public MessageVO() {

	}
	/**
	 * 메시지 객체를 필드값으로 입력받아 생성한다.
	 * 
	 * @param msgNum		메시지 번호(int)
	 * @param memEmail		보낸 회원이메일(String)
	 * @param memEmail2		받는 회원이메일(String)
	 * @param msgContent	메시지 내용(String)
	 * @param fileId		파일아이디(long)
	 * @param msgDate		전송시간(LocalDate)
	 */
	public MessageVO(int msgNum, String memEmail, String memEmail2, String msgContent, long fileId, LocalDateTime msgDate) {
		super();
		this.msgNum = msgNum;
		this.memEmail = memEmail;
		this.memEmail2 = memEmail2;
		this.msgContent = msgContent;
		this.fileId = fileId;
		this.msgDate = msgDate;
	}

	public int getMsgNum() {
		return msgNum;
	}

	public void setMsgNum(int msgNum) {
		this.msgNum = msgNum;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemEmail2() {
		return memEmail2;
	}

	public void setMemEmail2(String memEmail2) {
		this.memEmail2 = memEmail2;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	

	public LocalDateTime getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(LocalDateTime msgDate) {
		this.msgDate = msgDate;
	}
	@Override
	public String toString() {
		return "MessageVO [msgNum=" + msgNum + ", memEmail=" + memEmail + ", memEmail2=" + memEmail2 + ", msgContent="
				+ msgContent + ", fileId=" + fileId + ", msgDate=" + msgDate + "]";
	}
	
	@Override
	public int compareTo(MessageVO o) {
		return this.getMsgDate().compareTo(o.getMsgDate());
	}

}
