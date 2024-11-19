package member.service;

import java.util.List;

import VO.MemberVO;
import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;

public class MemberServiceImpl implements IMemberService {

	private static IMemberService service;
	private IMemberDao dao;

	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}

	public static IMemberService getInstance() {
		if (service == null)
			service = new MemberServiceImpl();
		return service;

	}

	@Override
	public int registerMember(MemberVO mv) {

		return dao.insertMember(mv);
	}

	@Override
	public int modifyMember(MemberVO mv) {

		return dao.updateMember(mv);
	}

	@Override
	public int removeMember(MemberVO mv) {

		return dao.deleteMember(mv);
	}

	@Override
	public boolean checkMember(String memEmail) {

		return dao.checkMember(memEmail);
	}

	@Override
	public MemberVO getMember(String memEmail) {
		return dao.getMember(memEmail);
	}

	@Override
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub
		return dao.getAllMember();
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		// TODO Auto-generated method stub
		return dao.searchMember(mv);
	}

	@Override
	public String findId(MemberVO mv) {
		// TODO Auto-generated method stub
		return dao.findId(mv);
	}

	@Override
	public int findUpdatePass(MemberVO mv) {
		// TODO Auto-generated method stub
		return dao.findUpdatePass(mv);
	}

	@Override
	public List<MemberVO> getTag() {
		
		return dao.getTag();
	}

	@Override
	public void setAtchFileId(long profileId) {
		dao.setAtchFileId(profileId);
	}

}
