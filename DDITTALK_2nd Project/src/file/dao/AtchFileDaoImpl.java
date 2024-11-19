package file.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import VO.AtchFileDetailVO;
import VO.AtchFileVO;
import util.MyBatisUtil;

public class AtchFileDaoImpl implements IAtchFileDao{
	private static IAtchFileDao fileDao = new AtchFileDaoImpl();
	
	private AtchFileDaoImpl() {
		
	}
	public static IAtchFileDao getInstance() {
		return fileDao;
	}
			
	@Override
	public int insertAtchFile(AtchFileVO atchFileVO) {
		SqlSession session = MyBatisUtil.getSqlSession(false);
		int cnt = 0;
		try {
			cnt = session.insert("atchFile.insertAtchFile", atchFileVO);
			if(cnt > 0) {
				session.commit();
			} 
		} catch (PersistenceException e) {
			 e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int insertAtchFileDetail(AtchFileDetailVO atchFileDetailVO) {
		SqlSession session = MyBatisUtil.getSqlSession(false);
		int cnt = 0;
		try {
			cnt = session.insert("atchFile.insertAtchFileDetail", atchFileDetailVO);
			if(cnt > 0) {
				session.commit();
			} 
		} catch (PersistenceException e) {
			 e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public AtchFileVO getAtchFile(AtchFileVO atchFileVO) {
		AtchFileVO fileVO = null;
		
		SqlSession session = MyBatisUtil.getSqlSession();
		try {
			fileVO = session.selectOne("atchFile.getAtchFile", atchFileVO);
		} catch (PersistenceException e) {
			 e.printStackTrace();
		} finally {
			session.close();
		}
		return fileVO;
	}

	@Override
	public AtchFileDetailVO getAtchFileDetail(AtchFileDetailVO atchFileDetailVO) {
		AtchFileDetailVO fileDetailVO = null;
		
		SqlSession session = MyBatisUtil.getSqlSession();
		try {
			fileDetailVO = session.selectOne("atchFile.getAtchFileDetail",atchFileDetailVO);
		} catch (PersistenceException e) {
			 e.printStackTrace();
		} finally {
			session.close();
		}
		return fileDetailVO;
	}
	@Override
	public List<AtchFileDetailVO> getAtchFileDetailList() {
		
		List<AtchFileDetailVO> fileList = new ArrayList<AtchFileDetailVO>();

		SqlSession session = MyBatisUtil.getSqlSession();
		try {
			fileList = session.selectList("atchFile.getAtchFileDetailList");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return fileList;
	}
	@Override
	public String getName(long fileId) {
		
		Map<String, String> fileName = new HashMap<String, String>();
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		try {
			fileName = session.selectOne("atchFile.getAtchFileDetailList",fileName);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return fileName.get("fileName");
		
	}
	
	@Override
	public String getStre(long fileId) {
		
		String stre = "";
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		try {
			
			stre = session.selectOne("atchFile.getStre", fileId);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return stre;
		
	}
	
}
