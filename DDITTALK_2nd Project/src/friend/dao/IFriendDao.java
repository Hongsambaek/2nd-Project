package friend.dao;

import java.util.List;

import VO.FriendVO;
import VO.MemberVO;

public interface IFriendDao {

	public List<FriendVO> getAcceptFriendList(String memEmail);

	public List<FriendVO> getFriendList(String memEmail);

	public List<MemberVO> getMemTagSearch(String memTag);

	public int addFriend(FriendVO fv);

	public int acceptFriend(FriendVO fv);

	public int rejectFriend(FriendVO fv);

	public int deleteMember(FriendVO fv);

}
