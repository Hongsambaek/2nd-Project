package friend.service;

import java.util.List;

import VO.FriendVO;
import VO.MemberVO;
import friend.dao.FriendDaoImpl;
import friend.dao.IFriendDao;

public class FriendServiceImpl implements IFriendService {

	private static FriendServiceImpl instance;
	private IFriendDao fndDao;

	private FriendServiceImpl() {
		fndDao = FriendDaoImpl.getInstance();
	}

	public static FriendServiceImpl getInstance() {
		if (instance == null) {
			instance = new FriendServiceImpl();
		}

		return instance;
	}

	@Override
	public List<FriendVO> getAcceptFriendList(String memEmail) {
		return fndDao.getAcceptFriendList(memEmail);
	}

	@Override
	public List<FriendVO> getFriendList(String memTag) {
		return fndDao.getFriendList(memTag);
	}

	@Override
	public List<MemberVO> getMemTagSearch(String memTag) {
		return fndDao.getMemTagSearch(memTag);
	}

	@Override
	public int addFriend(FriendVO fv) {
		return fndDao.addFriend(fv);
	}

	@Override
	public int acceptFriend(FriendVO fv) {
		return fndDao.acceptFriend(fv);
	}

	@Override
	public int rejectFriend(FriendVO fv) {
		return fndDao.rejectFriend(fv);
	}

	@Override
	public int deleteMember(FriendVO fv) {
		return fndDao.deleteMember(fv);
	}

}
