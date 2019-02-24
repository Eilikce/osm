package com.eilikce.osm.dao;

import java.util.List;

import com.eilikce.osm.entity.consumer.CommodityPo;
import com.eilikce.osm.entity.consumer.CommodityFurtherPo;
import org.apache.ibatis.annotations.Param;

public interface CommodityDao {
	
	/** 分页取回商品全部信息列表 **/
	List<CommodityPo> selectCommodityByPage(int page);
	
	/** 分页取回商品显示全部信息列表 **/
	List<CommodityFurtherPo> selectCommodityFurtherByPage(@Param("page") int page, @Param("pageSize") int pageSize);
	
	/** 分页取回商品显示全部信息列表 搜索 **/
	List<CommodityFurtherPo> selectCommodityFurtherByPageSearch(@Param("page") int page, @Param("pageSize") int pageSize, String search);
	
	/** 通过commodityId取出商品全部信息 **/
	CommodityFurtherPo selectCommodityFurtherById(String commodityId);

	/** 通过条形码barcode取出商品全部信息 **/
	CommodityFurtherPo selectCommodityFurtherByBarcode(int barcode);
	
	/** 新增一个商品 **/
	int insertCommodity(CommodityPo commodityPo);
	
	/** 批量新增多个商品 **/
	int insertCommodityList(List<CommodityPo> commodityPoList);

	/** 更新一个商品 **/
	int updateCommodity(CommodityPo commodityPo);
	
	/** 获取某一个页数下的商品总条数 **/
	int selectCountByPage(@Param("page") int page, @Param("pageSize") int pageSize);
	
	/** 获取商品总数 **/
	Integer selectCount();

	/** 获取全部商品 **/
	List<CommodityPo> selectAllCommodity();

	/** 获取某个一级二级分类下的所有商品 **/
	List<CommodityPo> selectCommodityByGroupIdItemId(int groupId , int itemId);
	
	/** 根据搜索词 搜索商品 **/
	List<CommodityPo> selectCommodityBySearch(String search);
	
	/** 根据commodityId查询商品 **/
	CommodityPo selectById(String commodityId);
	
	/** 根据id改变上架信息**/
	int selectShelvesById(String commodityId);

	/** 获取特定条形码Barcode商品的个数 **/
	int selectCountByBarcode(int barcode);
	
	/** 根据commodityId改变上架信息**/
	int updateShelvesById(String commodityId , int shelves);
	
	/** 根据commodityId删除一个商品 **/
	int deleteCommodityById(String commodityId);
	
}
