/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package passionx3.jkdk.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import passionx3.jkdk.domain.Item;
import passionx3.jkdk.domain.Online;

@Mapper
public interface OnlineMapper {
	@Select("SELECT i.itemId, i.name, i.price, i.likeNum, i.thumbnail1, i.isForSale, o.totalRate, o.pcFile, o.tabletFile, o.phoneFile "
			+ "FROM item i, onlineitem o "
			+ "WHERE i.itemId = o.itemId "
			+ "AND i.name LIKE '%#{keyword}%' "
			+ "AND i.isForSale = 1 "
			+ "AND i.approval = 1")
	List<Online> getOnlineItemsByKeyword(@Param("keyword") String keyword);
	
	@Select("SELECT ITEMID, USERID, NAME, UPLOADDATE, PRICE, LIKENUM, THUMNAIL1, THUMNAIL2, THUMNAIL3, "
			+ "ISFORSALE, DESCRIPTION, APPROVAL, CATEGORYID, THEMEID, PCFILE, TABLEFILE, PHONEFILE"
			+ " FROM ITEM, ONLINEITEM WHERE ITEM.USERID = #{userId} AND ITEM.ITEMID = ONLINEITEM.ITEMID ORDER BY UPLOADDATE")
	List<Online> getOnlineItemListByProducerId(String userId);

}
