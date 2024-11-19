package msg.service;

import java.util.List;
import java.util.Map;

import VO.MessageVO;
import msg.dao.IMsgDao;
import msg.dao.MsgDaoImpl;

public class MsgServiceImpl implements IMsgService {


	private static MsgServiceImpl instance;
	private IMsgDao msgDao;

	private MsgServiceImpl() {
		msgDao = MsgDaoImpl.getInstance();
	}

	public static MsgServiceImpl getInstance() {
		if (instance == null) {
			instance = new MsgServiceImpl();
		}
		return instance;
	}

	@Override
	public List<MessageVO> getAllMsg(MessageVO mv) {
		
		return msgDao.getMsg(mv);
	}

	@Override
	public int sendMsg(MessageVO mv) {
		return msgDao.InsertMsg(mv);
	}

	@Override
	public List<MessageVO> recentMsg(MessageVO mv) {
		return msgDao.getRecentMsg(mv);
	}






	

}
