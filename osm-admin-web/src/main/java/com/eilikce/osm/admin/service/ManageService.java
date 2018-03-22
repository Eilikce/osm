package com.eilikce.osm.admin.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.eilikce.osm.core.bo.common.CommodityBatch;
import com.eilikce.osm.core.bo.common.CommodityGroupItemBo;
import com.eilikce.osm.core.bo.common.CommodityShow;
import com.eilikce.osm.core.bo.transformable.CommodityBo;
import com.eilikce.osm.core.bo.transformable.CommodityItemBo;
import com.eilikce.osm.entity.consumer.CommodityFurther;

/**
 * 系统商品管理接口
 * @author Eilik
 *
 */
public interface ManageService {
	
	/** 分页取回商品全部信息列表 默认10条每页 **/
	@Deprecated
	List<CommodityBo> getCommodityListByPage(int page);

	/** 分页取回商品显示全部信息列表 **/
	List<CommodityFurther> getCommodityFurtherListByPage(int page, int pageSize);

	/** 分页取回商品显示全部信息列表 搜索 **/
	List<CommodityFurther> getCommodityFurtherListByPageSearch(int page, int pageSize, String search);
	
	/** 通过commodityId取出商品全部信息 **/
	CommodityFurther getCommodityFurtherById(String commodityId);

	/** 通过条形码barcode取出商品全部信息 **/
	CommodityFurther getCommodityFurtherByBarcode(int barcode);

	/** 通过commodityId取出 商品展示对象 全部信息 **/
	CommodityShow getCommodityShowById(String commodityId);

	/** 通过条形码barcode取出 商品展示对象 全部信息 **/
	CommodityShow getCommodityShowByBarcode(int barcode);
	
	/** 分页取回 商品展示对象 全部信息列表 **/
	List<CommodityShow> getCommodityShowListByPage(int page, int pageSize);

	/** 分页取回 商品展示对象 全部信息列表 搜索 **/
	List<CommodityShow> getCommodityShowListByPageSearch(int page, int pageSize, String search);

	/** 检查数据库中是否有与传入商品列表重复的条形码 **/
	List<Integer> checkBarcodeExsit (List<CommodityBo> commodityBoList);
	
	
	
	/** 获取全部一级分类列表 **/
	List<CommodityGroupItemBo> getAllCommodityGroupList();
	
	/** 获取全部二级分类列表 **/
	List<CommodityItemBo> getAllCommodityItemList();

	/** 通过groupId获取二级分类列表 **/
	List<CommodityItemBo> getCommodityItemListByGroupId(int groupId);
	
	
	
	
	
	/** 新增一个商品 **/
	int addCommodity(CommodityBo commodity);

	/** 批量新增多个个商品 **/
	int addCommodityList(List<CommodityBo> commodityList);
	
	/** 更新一个商品 **/
	int modifyCommodity(CommodityBo commodity);
	
	/** 删除一个商品 **/
	int dropCommodity(String commodityId);

	/** 删除多个商品 根据起止编号**/
	int dropCommodity(int startCommodityId, int endCommodityId);
	
	/** 获取新页的数据条数 **/
	int findCountByPage(int page, int pageSize);
	
	/** 获取总页数 **/
	int findTotalPage(int pageSize);
	
	/** 通过commodityId改变上架信息，返回上架信息 **/
	int changeShelves(String commodityId, int shelves);
	
	/************************** 文件相关 *********************************/
	
	/** 通过xlsx文件获取商品列表，返回批量商品解析对象 **/
	CommodityBatch findCommodityListFromXlsx(MultipartFile mfile);
	
	/** 通过xlsx文件，获取表格行数（包括标题行） **/
	int findCountFromXlsx(MultipartFile mfile);
	
	/** 将MFile文件写出图片文件到系统 **/
	boolean imgWriteFile(MultipartFile mfile,String filePath,String fileName);
	
}
