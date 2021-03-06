package passionx3.jkdk.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import passionx3.jkdk.domain.*;

public interface jkdkFacade {
	
	void closeFunding(int itemId, Date closingTime);
	
	Account getAccount(String userId);

	Account getAccount(String userId, String password);

	int insertAccount(Account account);  	
	
	int updateAccount(Account account);	
	
	int removeAccount(String userId);     

	int existingUser(String userId);	
	
	int updateLike(int itemId, String userId);
	
	int approveItem(int itemId);
	
	int refuseItem(int itemId);
	
	Review getReview(int reviewId);
	
	String getReviewIdByLineItmeId(int lineItemId);
	
	int insertReview (Review review);

	int updateReview (Review review);
	
	int deleteReview (int reviewId);
		
	List<Review> getReviewsByItemId(int itemId);
	
	Online getOnlineItemById(int itemId);
	
	Funding getFundingItemById(int itemId); 

	List<Online> getOnlineItemsByKeyword(String keyword);

	List<Funding> getFundingItemsByKeyword(String keyword);
	
	List<Online> getOnlineItemListByCategory(int cateogryId, int themeId, int device, String keyword, int sortBy, int start, int end);

	int getCountOfOnlineItemListByCategory(int categoryId, int themeId, String keyword, int start, int end);
	
	List<Funding> getFundingItemList(int themeId, String keyword, int sortBy, int start, int end);
	
	int getCountOfFundingItemList(int themeId, String keyword, int start, int end);

	List<Online> getBestOnlineItemListforHome();
	
	TimeSale getTimeSale();
	
	void insertTimeSale();
	
	BattleSale getBattleSale(String openTime) ;
	
	int insertVote(String battleId, String userId);
	
	void updateBattleSaleVote1(String battleSaleId);
	
	void updateBattleSaleVote2(String battleSaleId);
	
	void resetVote();
	
	int getWinnerItemId();
	
	void insertBattleSale();
	
	List<Theme> getAllThemes();

	List<Category> getAllCategories();

	int registerFundingItem(Funding funding);

	List<Online> getNotApprovedOnlineItems();

	List<Funding> getNotApprovedFundingItems();

	Map<String, List<Order>> getLineItemsByUserId(String userId) throws ParseException;

	List<Online> getOnlineItemListByProducerId(String userId);

	List<Funding> getFundingItemListByProducerId(String userId);

	int registerOnlineItem(Online online);

	int updateOnlineItem(Online online);
	
	int insertOrder(Order order);
	
	int insertFundOrder(FundOrder fundOrder);

	Order getOrderByOrderId(int orderId);
	
	FundOrder getFundOrderByOrderId(int orderId);

	List<Online> getNewOnlineItemListforHome();

	List<Funding> getNewFundingItemListforHome();
	
	String getCategoryNameByCategoryId(int categoryId);
	
	int updateOnlineItemSaleState(int itemId);
	
	Category getCategoryByCategoryId(int categoryId);
	
	void updateSaleState(int state, int itemId);
	
	void updateNotSale(String date);
	
	UserLike plusLike(UserLike userLike);
	
	UserLike minusLike(UserLike userLike);
	
	UserLike getUserLike(int itemId, String userId);
	
	void setWaterMark(Item item);
}
