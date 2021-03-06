
package passionx3.jkdk.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import passionx3.jkdk.domain.BattleSale;

@Mapper
public interface BattleSaleMapper {
	@Select("SELECT * FROM BATTLESALE WHERE openTime = #{openTime}")
	BattleSale getBattleSale(@Param("openTime") String openTime);
	
	@Insert("INSERT INTO BattleSale (battlesaleId, itemId1, itemId2, votes1, votes2, openTime, closeTime) " + 
			"SELECT #{battleSaleId}, #{itemId1}, #{itemId2}, 0, 0,  #{openTime}, #{closeTime} from dual " + 
			"WHERE NOT EXISTS ( SELECT openTime FROM battlesale WHERE opentime = #{openTime})")
	@SelectKey(statement="select battleSaleId_seq.nextval FROM DUAL", keyProperty="battleSaleId", before=true, resultType=int.class)
	int insertBattleSale(@Param("itemId1") int itemId1, @Param("itemId2") int itemId2, @Param("openTime") String openTime, @Param("closeTime") String closeTime);
	
	@Insert("INSERT into vote (userId, battleSaleId, voteId) " + 
			"SELECT #{userId}, #{battleSaleId}, #{voteId} FROM DUAL " + 
			"WHERE NOT EXISTS (SELECT userId FROM VOTE WHERE userId= #{userId}) ")
	@SelectKey(statement="select voteId_seq.nextval FROM DUAL", keyProperty="voteId", before=true, resultType=int.class)
	int insertVote(@Param("battleSaleId") String battleSaleId, @Param("userId") String userId);
	
	@Delete("TRUNCATE TABLE vote ")
	void resetVote();
	
	@Select("SELECT case WHEN votes1 > votes2 THEN itemId1 WHEN votes1 < votes2 THEN itemId2 END AS winner " + 
			"FROM battleSale WHERE rownum = 1 ORDER BY battleSaleId DESC")
	int getWinnerItemId();
	
	@Insert("UPDATE battlesale SET votes1 = votes1 + 1 where battlesaleid = #{battleSaleId}")
	void updateBattleSaleVote1(@Param("battleSaleId") String battleSaleId);
	
	@Insert("UPDATE battlesale SET votes2 = votes2 + 1 where battlesaleid = #{battleSaleId}")
	void updateBattleSaleVote2(@Param("battleSaleId") String battleSaleId);

	@Insert("MERGE INTO onlineitem o " + 
			"USING (SELECT b.itemid1, b.itemid2 FROM  battleSale b WHERE b.closetime <= TO_DATE(#{date}, 'yyyy-MM-dd hh24:mi:ss')) b" + 
			" ON (b.itemid1 = o.itemid and b.itemid2 = o.itemid) " + 
			"WHEN MATCHED THEN UPDATE SET o.salestate = 0")
	void updateNotSale(@Param("date") String date);
}
