package feed.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import com.oracle.webservices.internal.api.message.ReadOnlyPropertyException;

import VO.BookmarkVO;
import VO.FeedVO;
import VO.LikeVO;
import util.MyBatisUtil;

public class FeedDaoImpl implements IFeedDao {

	private static IFeedDao feedDao = new FeedDaoImpl();

	private FeedDaoImpl() {

	}

	public static IFeedDao getInstance() {
		return feedDao;
	}

	@Override
	public int feedInsert(FeedVO fv) {

		SqlSession session = MyBatisUtil.getSqlSession();

		int cnt = 0;

		try {
			cnt = session.insert("feed.feedInsert", fv);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			session.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int feedUpdate(FeedVO fv) {

		SqlSession session = MyBatisUtil.getSqlSession();

		int cnt = 0;

		try {
			cnt = session.update("feed.feedUpdate", fv);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			session.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int feedDelete(int feedNum) {

		SqlSession session = MyBatisUtil.getSqlSession();

		int cnt = 0;

		try {
			cnt = session.delete("feed.feedDelete", feedNum);

			if (cnt > 0) {
				session.commit();
			}

		} catch (PersistenceException ex) {
			session.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public FeedVO feedDetail(int feedNum) {

		FeedVO fv = null;

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			fv = session.selectOne("feed.feedDetail", feedNum);

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return fv;
	}

	@Override
	public List<FeedVO> feedList() {

		List<FeedVO> feedList = new ArrayList<FeedVO>();

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			feedList = session.selectList("feed.feedList");

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return feedList;
	}

	@Override
	public List<FeedVO> feedSearch(FeedVO fv) {

		List<FeedVO> feedList = new ArrayList<FeedVO>();

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			feedList = session.selectList("feed.feedSearch", fv);

		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return feedList;
	}

	@Override
	public List<FeedVO> feedLoader(int start, int end) {

		List<FeedVO> feedList = new ArrayList<FeedVO>();

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {
			Map<String, Integer> param = new HashMap<String, Integer>();
			param.put("start", start);
			param.put("end", end);

			feedList = session.selectList("feed.openFeedList", param);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return feedList;
	}
	
	@Override
	public List<FeedVO> friendFeedLoader(FeedVO fv) {

		List<FeedVO> feedList = new ArrayList<FeedVO>();

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			feedList = session.selectList("feed.friendFeedList", fv);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return feedList;
	}
	
	@Override
	public List<FeedVO> myFeedLoader(FeedVO fv) {

		List<FeedVO> feedList = new ArrayList<FeedVO>();

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			feedList = session.selectList("feed.myFeedList", fv);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return feedList;
	}

	@Override
	public int feedCnt() {

		SqlSession session = MyBatisUtil.getSqlSession(true);

		int cnt = 0;

		try {

			cnt = session.selectOne("feed.feedCounter");

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int feedSearchCnt(String search) {

		SqlSession session = MyBatisUtil.getSqlSession(true);

		int cnt = 0;

		try {

			cnt = session.selectOne("feed.feedSearchCounter", search);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public List<FeedVO> memFeedSearch(String memEmail) {

		List<FeedVO> feedList = new ArrayList<FeedVO>();

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			feedList = session.selectList("feed.memFeedLoader", memEmail);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return feedList;
	}

	@Override
	public List<LikeVO> likeSumList() {
		List<LikeVO> list = new ArrayList<LikeVO>();

		SqlSession session = MyBatisUtil.getSqlSession();

		try {

			list = session.selectList("feed.likeSumList");

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	@Override
	public List<LikeVO> allLikeList() {
		List<LikeVO> list = new ArrayList<LikeVO>();
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		try {
			
			list = session.selectList("feed.allLikeList");
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int likeFinder(LikeVO lv) {
		int cnt = 0;

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			cnt = session.selectOne("feed.likeFinder", lv);

			if (cnt > 0) {
				cnt = session.delete("feed.unlike", lv);
				cnt = -1;
			} else {
				cnt = session.insert("feed.like", lv);
				cnt = 1;
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public String bookMarkFinder(BookmarkVO bv) {
		String res = "";

		SqlSession session = MyBatisUtil.getSqlSession(true);

		try {

			int cnt = session.selectOne("feed.bookMarkFinder", bv);

			if (cnt > 0) {
				cnt = session.delete("feed.unmarking", bv);
				res = "Unmarked";
			} else {
				cnt = session.insert("feed.marking", bv);
				res = "Marked";
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	@Override
	public List<BookmarkVO> bookMarkList() {
		List<BookmarkVO> list = new ArrayList<BookmarkVO>();
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
	    try {
			
	    	list = session.selectList("feed.bookmarkList");
	    	
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<FeedVO> myBookList(FeedVO fv) {
		List<FeedVO> list = new ArrayList<FeedVO>();
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		try {
			
			list = session.selectList("feed.myBookList", fv);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<FeedVO> myFeedList(FeedVO fv) {
		List<FeedVO> list = new ArrayList<FeedVO>();
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		try {
			list = session.selectList("feed.myFeedList", fv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
				
		return list;
	}

	@Override
	public List<FeedVO> bookFeedLoader(FeedVO fv) {
		List<FeedVO> list = new ArrayList<FeedVO>();
		
		SqlSession session = MyBatisUtil.getSqlSession();
		
		try {
			list = session.selectList("feed.bookFeedList", fv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

}
