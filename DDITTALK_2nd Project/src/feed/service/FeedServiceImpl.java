package feed.service;

import java.util.List;

import VO.BookmarkVO;
import VO.FeedVO;
import VO.LikeVO;
import feed.dao.FeedDaoImpl;
import feed.dao.IFeedDao;

public class FeedServiceImpl implements IFeedService{
	
	private static IFeedService feedService = new FeedServiceImpl();
	
	private IFeedDao feedDao;
	
	private FeedServiceImpl(){
		feedDao = FeedDaoImpl.getInstance();		
	}
	
	public static IFeedService getInstance() {
		
		return feedService;
	}


	@Override
	public int feedInsert(FeedVO fv) {

		int cnt = feedDao.feedInsert(fv);
		
		return cnt;
	}

	@Override
	public int feedUpdate(FeedVO fv) {

		int cnt = feedDao.feedUpdate(fv);
		
		return cnt;
	}

	@Override
	public int feedDelete(int feedNum) {
		
		int cnt = feedDao.feedDelete(feedNum);
		  
		return cnt;
	}

	@Override
	public FeedVO feedDetail(int feedNum) {
		
		return feedDao.feedDetail(feedNum);
	}

	@Override
	public List<FeedVO> feedList() {
		
		return feedDao.feedList();
	}

	@Override
	public List<FeedVO> feedSearch(FeedVO fv) {
		
		return feedDao.feedSearch(fv);
	}

	@Override
	public List<FeedVO> feedLoader(int start, int end) {

		return feedDao.feedLoader(start, end);
	}

	@Override
	public int feedCnt() {
		
		return feedDao.feedCnt();
	}

	@Override
	public int feedSearchCnt(String search) {
		
		return feedDao.feedSearchCnt(search);
	}

	@Override
	public List<FeedVO> memFeedSearch(String memEmail) {
		return feedDao.memFeedSearch(memEmail);
	}
	
	@Override
	public List<LikeVO> likeSumList() {
		return feedDao.likeSumList();
	}

	@Override
	public int likeFinder(LikeVO lv) {
		return feedDao.likeFinder(lv);
	}

	@Override
	public List<LikeVO> allLikeList() {
		return feedDao.allLikeList();
	}

	@Override
	public List<BookmarkVO> bookMarkList() {
		return feedDao.bookMarkList();
	}

	@Override
	public String bookMarkFinder(BookmarkVO bv) {
		return feedDao.bookMarkFinder(bv);
	}

	@Override
	public List<FeedVO> myBookList(FeedVO fv) {
		return feedDao.myBookList(fv);
	}

	@Override
	public List<FeedVO> myFeedList(FeedVO fv) {
		return feedDao.myFeedList(fv);
	}

	@Override
	public List<FeedVO> friendFeedLoader(FeedVO fv) {
		return feedDao.friendFeedLoader(fv);
	}

	@Override
	public List<FeedVO> myFeedLoader(FeedVO fv) {
		return feedDao.myFeedLoader(fv);
	}

	@Override
	public List<FeedVO> bookFeedLoader(FeedVO fv) {
		return feedDao.bookFeedLoader(fv);
	}
	
	

}
