package member.service;

import java.util.List;

import VO.MemberVO;

public interface IMemberService {

	public int registerMember(MemberVO mv);

	public int modifyMember(MemberVO mv);

	public int removeMember(MemberVO mv);

	public boolean checkMember(String memEmail);

	public MemberVO getMember(String memEmail);

	public List<MemberVO> getAllMember();

	public List<MemberVO> searchMember(MemberVO mv);

	public String findId(MemberVO mv);

	public int findUpdatePass(MemberVO mv);
	
	public List<MemberVO> getTag();
	
	public void setAtchFileId(long profileId);

}
