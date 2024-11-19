package msg.dao;

import java.util.List;
import java.util.Map;

import VO.MessageVO;

public interface IMsgDao {
	
    public List<MessageVO> getMsg(MessageVO mv);

	public int InsertMsg(MessageVO mv);

	public List<MessageVO> getRecentMsg(MessageVO mv);
	
}
