package msg.service;

import java.util.List;
import java.util.Map;

import VO.MessageVO;

public interface IMsgService {
	
	public List<MessageVO> getAllMsg(MessageVO mv);
	
	public int sendMsg(MessageVO mv);
	
	public List<MessageVO> recentMsg(MessageVO mv);
}
