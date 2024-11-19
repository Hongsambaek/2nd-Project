package member.dao;

import java.util.List;

import VO.MemberVO;

public interface IMemberDao {

	public int insertMember(MemberVO mv);

	public int updateMember(MemberVO mv);

	public int deleteMember(MemberVO mv);

	public boolean checkMember(String memEmail);

	public MemberVO getMember(String memEmail);

	public List<MemberVO> getAllMember();

	public List<MemberVO> searchMember(MemberVO mv);

	public String findId(MemberVO mv);

	public int findUpdatePass(MemberVO mv);

	public List<MemberVO> getTag();

	public void setAtchFileId(long profileId);

}
