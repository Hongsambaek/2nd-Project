package feed.dao;

import java.util.List;

import VO.BookmarkVO;
import VO.FeedVO;
import VO.LikeVO;
import VO.MemberVO;

public interface IFeedDao {


	public int feedInsert(FeedVO fv);
	
	public int feedUpdate(FeedVO fv);
	
	public int feedDelete(int feedNum);
	
	public FeedVO feedDetail(int feedNum);
	
	public List<FeedVO> feedList();
	
	public int feedCnt();
	
	public List<FeedVO> feedSearch(FeedVO fv);
	
	public int feedSearchCnt(String search);
	
	public List<FeedVO> feedLoader(int start, int end);

	public List<FeedVO> memFeedSearch(String memEmail);

	public List<LikeVO> likeSumList();

	public int likeFinder(LikeVO lv);

	public List<LikeVO> allLikeList();

	public String bookMarkFinder(BookmarkVO bv);

	public List<BookmarkVO> bookMarkList();

	public List<FeedVO> myBookList(FeedVO fv);

	public List<FeedVO> myFeedList(FeedVO fv);

	public List<FeedVO> friendFeedLoader(FeedVO fv);

	public List<FeedVO> myFeedLoader(FeedVO fv);

	public List<FeedVO> bookFeedLoader(FeedVO fv);
	
}
