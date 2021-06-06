package passionx3.jkdk.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import passionx3.jkdk.dao.OnlineDao;
import passionx3.jkdk.dao.mybatis.mapper.OnlineMapper;
import passionx3.jkdk.domain.Online;

@Repository
public class MybatisOnlineDao implements OnlineDao {
	
	@Autowired
	private OnlineMapper onlineMapper;

	@Override
	public List<Online> getBestOnlineItemListforHome() throws DataAccessException {
		return onlineMapper.getBestOnlineItemListforHome();
	}

	@Override
	public List<Online> getNewOnlineItemList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<Online> getOnlineItemListByCategory(int categoryId, String keyword, int sortBy) throws DataAccessException {
		
		if (sortBy == 1)
			return onlineMapper.getOnlineItemListByCategoryOrderByUploadDate(categoryId, keyword);
		else if (sortBy == 2)
			return onlineMapper.getOnlineItemListByCategoryOrderByLikeNum(categoryId, keyword);
		else if (sortBy == 3)
			return onlineMapper.getOnlineItemListByCategoryOrderByTotalRate(categoryId, keyword);
		else if (sortBy == 4)
			return onlineMapper.getOnlineItemListByCategoryOrderByPriceLow(categoryId, keyword);
		else // (sortBy == 5)
			return onlineMapper.getOnlineItemListByCategoryOrderByPriceHigh(categoryId, keyword);
	}

	@Override
	public List<Online> getOnlineItemListByTheme(int categoryId, int themeId, String keyword, int sortBy) throws DataAccessException {
		if (sortBy == 1)
			return onlineMapper.getOnlineItemListByThemeOrderByUploadDate(categoryId, themeId, keyword);
		else if (sortBy == 2)
			return onlineMapper.getOnlineItemListByThemeOrderByLikeNum(categoryId, themeId, keyword);
		else if (sortBy == 3)
			return onlineMapper.getOnlineItemListByThemeOrderByTotalRate(categoryId, themeId, keyword);
		else if (sortBy == 4)
			return onlineMapper.getOnlineItemListByThemeOrderByPriceLow(categoryId, themeId, keyword);
		else // (sortBy == 5)
			return onlineMapper.getOnlineItemListByThemeOrderByPriceHigh(categoryId, themeId, keyword);
	}

	@Override
	public List<Online> getOnlineItemsByKeyword(String keyword) throws DataAccessException {
		return onlineMapper.getOnlineItemsByKeyword(keyword);
	}

	@Override
	public List<Online> getOnlineItemListByProducerId(String userId) throws DataAccessException {
		return onlineMapper.getOnlineItemListByProducerId(userId);
	}

	@Override
	public Online getOnlineItemById(int itemId) throws DataAccessException {
		return onlineMapper.getOnlineItemById(itemId);
	}

	@Override
	public int registerOnlineItem(Online onlineItem) throws DataAccessException {
		return onlineMapper.registerOnlineItem(onlineItem);
	}

	@Override
	public void setWatermark(String fileAddr) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Online> getNotApprovedOnlineItems() throws DataAccessException {
		return onlineMapper.getNotApprovedOnlineItems();
	}

	@Override
	public int refuseItem(int itemId) throws DataAccessException {
		return onlineMapper.refuseItem(itemId) ;
	}

	@Override
	public int approveItem(int itemId) {
		return onlineMapper.approveItem(itemId) ;
	}

	@Override
	public List<Integer> getOnlineItemIdByCategoryforSale(int categoryId) throws DataAccessException {
		return onlineMapper.getOnlineItemIdByCategoryforSale(categoryId);
	}

	@Override
	public List<Online> getBestOnlineItemList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Online> getNewOnlineItemListforHome() throws DataAccessException {
		return onlineMapper.getNewOnlineItemListforHome();
	}

	@Override
	public int updateOnlineItemSaleState(int itemId) throws DataAccessException {
		return onlineMapper.updateOnlineItemSaleState(itemId);
	}

	@Override
	public int updateOnlineItem(Online onlineItem) throws DataAccessException {
		return onlineMapper.updateOnlineItem(onlineItem);
	}

	@Override
	public void updateSaleState(int state, int itemId) throws DataAccessException {
		onlineMapper.updateSaleState(state, itemId);
	}
	
	public void updateUploadDate(int itemId, String today) throws DataAccessException {
		onlineMapper.updateUploadDate(itemId, today);

	}
	
}