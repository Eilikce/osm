package com.eilikce.osm.admin.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eilikce.osm.admin.file.FileManager;
import com.eilikce.osm.admin.poi.PoiUtil;
import com.eilikce.osm.core.bo.common.CommodityBatch;
import com.eilikce.osm.core.bo.common.CommodityGroupItem;
import com.eilikce.osm.core.bo.common.CommodityShow;
import com.eilikce.osm.core.bo.transformable.Commodity;
import com.eilikce.osm.core.bo.transformable.CommodityItem;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.core.handler.OsmIdHandler;
import com.eilikce.osm.core.handler.CommodityGroupHandler;
import com.eilikce.osm.dao.CommodityDao;
import com.eilikce.osm.dao.CommodityGroupDao;
import com.eilikce.osm.dao.CommodityItemDao;
import com.eilikce.osm.entity.consumer.CommodityPo;
import com.eilikce.osm.entity.consumer.CommodityFurtherPo;
import com.eilikce.osm.entity.consumer.CommodityGroupPo;
import com.eilikce.osm.entity.consumer.CommodityGroupItemPo;
import com.eilikce.osm.entity.consumer.CommodityItemPo;
import com.eilikce.osm.util.StringUtil;

@Service
public class ManageServiceImpl implements ManageService{

	private static Logger logger = Logger.getLogger(ManageServiceImpl.class);
	
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private CommodityGroupDao commodityGroupDao;
	@Autowired
	private CommodityItemDao commodityItemDao;
	
	@Override
	public List<Commodity> getCommodityListByPage(int page) {
		List<Commodity> commodityBoList = new ArrayList<Commodity>();
		List<CommodityPo> commodityList = commodityDao.selectCommodityByPage(page);
		commodityBoList = BoTransHandler.entityListToBoList(Commodity.class, commodityList);
		
		return commodityBoList;
	}

	@Override
	public List<CommodityFurtherPo> getCommodityFurtherListByPage(int page, int pageSize) {
		List<CommodityFurtherPo> commodityFurtherList = commodityDao.selectCommodityFurtherByPage(page, pageSize);
		return commodityFurtherList;
	}

	@Override
	public List<CommodityFurtherPo> getCommodityFurtherListByPageSearch(int page, int pageSize, String search) {
		List<CommodityFurtherPo> commodityFurtherList = commodityDao.selectCommodityFurtherByPageSearch(page, pageSize, search);
		return commodityFurtherList;
	}
	
	@Override
	public List<CommodityGroupItem> getAllCommodityGroupList() {
		List<CommodityGroupPo> commodityGroupList = commodityGroupDao.selectAllCommodityGroup();
		List<CommodityGroupItem> groupBoList = CommodityGroupHandler.commodityGroupListTransform0(commodityGroupList);
		return groupBoList;
	}

	@Override
	public List<CommodityItem> getAllCommodityItemList() {
		List<CommodityItem> commodityItemBoList = new ArrayList<CommodityItem>();
		List<CommodityItemPo> commodityItemList = commodityItemDao.selectAllCommodityItem();
//		commodityItemBoList = CommodityItemBoHandler.commodityItemBoListTransform(commodityItemList);
		commodityItemBoList = BoTransHandler.entityListToBoList(CommodityItem.class, commodityItemList);
		return commodityItemBoList;
	}

	@Override
	public List<CommodityItem> getCommodityItemListByGroupId(int groupId) {
		List<CommodityItem> commodityItemBoList = new ArrayList<CommodityItem>();
		List<CommodityItemPo> commodityItemList = commodityItemDao.selectCommodityItemByGroupId(groupId);
//		commodityItemBoList = CommodityItemBoHandler.commodityItemBoListTransform(commodityItemList);
		commodityItemBoList = BoTransHandler.entityListToBoList(CommodityItem.class, commodityItemList);
		return commodityItemBoList;
	}

	@Override
	public CommodityFurtherPo getCommodityFurtherById(String commodityId) {
		CommodityFurtherPo commodityFurther = commodityDao.selectCommodityFurtherById(commodityId);
		return commodityFurther;
	}

	@Override
	public CommodityFurtherPo getCommodityFurtherByBarcode(int barcode) {
		CommodityFurtherPo commodityFurther = commodityDao.selectCommodityFurtherByBarcode(barcode);
		return commodityFurther;
	}

	@Override
	public int addCommodity(Commodity commodityBo) {
		if(!checkCommodity(commodityBo)){
			return 0;
		}
		CommodityPo commodity = commodityBo.transToEntity(CommodityPo.class);
		int insert = commodityDao.insertCommodity(commodity);
		return insert ; 
	}
	
	@Override
	public int addCommodityList(List<Commodity> commodityBoList) {
		if(commodityBoList.size()==0){
			logger.info("批量插入Commodity信息为条数 0 ");
			return 0;
		}
		List<CommodityPo> commodityList = BoTransHandler.boListToEntityList(commodityBoList, CommodityPo.class);
		int insert = commodityDao.insertCommodityList(commodityList);
		return insert ; 
	}

	@Override
	public int modifyCommodity(Commodity commodityBo) {
		CommodityPo commodity = commodityBo.transToEntity(CommodityPo.class);
		int update = commodityDao.updateCommodity(commodity);
		return update ; 
	}

	@Override
	public int findCountByPage(int page, int pageSize) {
		int count = commodityDao.selectCountByPage(page, pageSize);
		return count;
	}

	@Override
	public int findTotalPage(int pageSize) {
		int count = commodityDao.selectCount();
		
		//如果商品总数为0，则直接返回总页数为1
		if(count==0){
			return 1;
		}
		
		int totalPageTmp = count/pageSize;
		int remainder = count%pageSize;
		int totalPage = remainder==0?totalPageTmp:totalPageTmp+1;
		return totalPage;
	}

	@Override
	public int changeShelves(String commodityId, int shelves) {
		
		//修改改变上架信息
		int shelvesChange = 1;
		if(shelves==1){
			shelvesChange = 0;
		}
		
		int update = commodityDao.updateShelvesById(commodityId, shelvesChange);
		int shelves_back = -1;//返回-1表示错误
		if(update == 1){
			shelves_back = commodityDao.selectShelvesById(commodityId);
		}else{
			logger.error("上架信息更新错误 , "+"commodityId="+commodityId+", shelves="+shelves);
		}
		return shelves_back;
	}

	@Override
	public CommodityBatch findCommodityListFromXlsx(MultipartFile mfile) {
		CommodityBatch commodityBatch = new CommodityBatch();
		List<Commodity>commodityList = new ArrayList<Commodity>();	//解析成功的List
		List<Map<String,String>> failureCommodityMap = new ArrayList<Map<String,String>>();	//解析失败的Map
		commodityBatch.setSuccessCommodityList(commodityList);
		commodityBatch.setFailureCommodityMap(failureCommodityMap);
		
		List<CommodityGroupItemPo> commodityGroupItemList = commodityGroupDao.selectAllCommodityGroupAndItem();
		List<CommodityGroupItem> commodityGroupBoList = CommodityGroupHandler.commodityGroupListTransform(commodityGroupItemList);
		Map<String,Integer> groupMap = CommodityGroupHandler.commodityGroupListToNameIdMap(commodityGroupBoList);
		
		HashMap<Integer,HashMap<String,CommodityItem>> groupItemMap = CommodityGroupHandler.groupItemTree2(commodityGroupBoList);
		
		List<Map<String,String>>  mapList = PoiUtil.importXlsToListMapStringType(mfile);
		
		if(mapList.size()==0){
			logger.error("文件解析错误");
			commodityBatch.setParseFlag(false);
			return commodityBatch;
		}
		
		for(Map<String,String> map : mapList){
			try{
				String commodityName = ((String) map.get("名称"));
				String commodityDetail = ((String) map.get("详细"));
				
				String groupName = ((String) map.get("一级分类"));
				String itemName = ((String) map.get("二级分类"));
				Integer groupId = groupMap.get(groupName);
				Integer itemId = groupItemMap.get(groupId).get(itemName).getItemId();
				
				Integer barcode = StringUtil.IntegerParse(map.get("条形码"));
				
				Integer number = StringUtil.IntegerParse(map.get("库存"));
				String unit = ((String) map.get("单位"));
				float original = Float.parseFloat(map.get("进价"));
				float price = Float.parseFloat(map.get("售价"));
				
				Integer shelves = null;
				if(((String) map.get("是否上架")).equals("上架")||((String) map.get("是否上架")).equals("下架")){
					shelves = ((String) map.get("是否上架")).equals("上架")?1:0;
				}else{
					failureCommodityMap.add(map);
					logger.error("批量xlsx导入 , 上架信息解析错误 : "+map.toString());
					continue ;
				}
				
				String source = ((String) map.get("进货渠道"));
				String detail = ((String) map.get("备注信息"));
				
				
				String commodityId = OsmIdHandler.commodityIdCreater(commodityName);//创建唯一commodityId
				String imgRule = "main";//图片规则为main
				
				Commodity commodityBo = new Commodity(commodityId, groupId, itemId, barcode, commodityName, commodityDetail, imgRule, number, original, price, unit, source, detail, 0, shelves);
				commodityList.add(commodityBo);
			}catch (Exception e) {
				failureCommodityMap.add(map);
				logger.error("批量xlsx导入解析错误 : "+map.toString(), e);
			}
		}
		
		return commodityBatch;
	}

	@Override
	public int findCountFromXlsx(MultipartFile mfile) {
		int count = PoiUtil.importXlsCount(mfile);
		return count;
	}

	@Override
	public int dropCommodity(String commodityId) {
		int delete = commodityDao.deleteCommodityById(commodityId);
		return delete;
	}

	@Override
	public CommodityShow getCommodityShowById(String commodityId) {
		CommodityFurtherPo commodityFurther = getCommodityFurtherById(commodityId);
		CommodityShow commodityShow = null ;
		if(commodityFurther==null){
			logger.info("commodityId为 "+commodityId+" 的商品不存在");
		}else{
			commodityShow = new CommodityShow(commodityFurther);
		}
		
		return commodityShow;
	}

	@Override
	public CommodityShow getCommodityShowByBarcode(int barcode) {
		CommodityFurtherPo commodityFurther = getCommodityFurtherByBarcode(barcode);
		CommodityShow commodityShow = null ;
		if(commodityFurther==null){
			logger.info("条形码barcode为 "+barcode+" 的商品不存在");
		}else{
			commodityShow = new CommodityShow(commodityFurther);
		}
		
		return commodityShow;
	}

	@Override
	public List<CommodityShow> getCommodityShowListByPage(int page, int pageSize) {
		List<CommodityFurtherPo> commodityFurtherList = getCommodityFurtherListByPage(page, pageSize);
		List<CommodityShow> commodityShowList = new ArrayList<CommodityShow>();
		
		for(CommodityFurtherPo cf : commodityFurtherList){
			CommodityShow commodityShow = new CommodityShow(cf);
			commodityShowList.add(commodityShow);
		}
		
		return commodityShowList;
	}

	@Override
	public List<CommodityShow> getCommodityShowListByPageSearch(int page, int pageSize, String search) {
		List<CommodityFurtherPo> commodityFurtherList = getCommodityFurtherListByPageSearch(page, pageSize, search);
		List<CommodityShow> commodityShowList = new ArrayList<CommodityShow>();
		
		for(CommodityFurtherPo cf : commodityFurtherList){
			CommodityShow commodityShow = new CommodityShow(cf);
			commodityShowList.add(commodityShow);
		}
		
		return commodityShowList;
	}

	@Override
	public boolean imgWriteFile(MultipartFile mfile, String filePath, String fileName) {
		boolean flag = false;
		try {
			InputStream inputStream = mfile.getInputStream();
			flag = FileManager.WriteFile(inputStream, filePath, fileName);
			return flag;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public List<Integer> checkBarcodeExsit(List<Commodity> commodityBoList) {
		List<Integer> listBarcode = new ArrayList<Integer>();
		for(Commodity c : commodityBoList){
			Integer barcode = c.getBarcode();
			if(barcode==null){
				continue;
			}
			int count = commodityDao.selectCountByBarcode(barcode);
			if(count!=0){
				listBarcode.add(barcode);
			}
		}
		return listBarcode;
	}
	
	/**
	 * 校验商品非空性
	 * 数字校验null，字符串校验""
	 * 不校验属性：id，barcode，commodity_detail，source，detail，create_date
	 * @param commodityBo
	 * @return
	 */
	private boolean checkCommodity(Commodity commodityBo){
		
		if("".equals(commodityBo.getCommodityId())){
			logger.error(commodityBo.getCommodityId()+"为空");
			return false;
		}
		if(null == commodityBo.getGroupId()){
			logger.error(commodityBo.getGroupId()+"为空");
			return false;
		}
		if(null == commodityBo.getItemId()){
			logger.error(commodityBo.getItemId()+"为空");
			return false;
		}
		if("".equals(commodityBo.getCommodityName())){
			logger.error(commodityBo.getCommodityName()+"为空");
			return false;
		}
		if("".equals(commodityBo.getImgRule())){
			logger.error(commodityBo.getImgRule()+"为空");
			return false;
		}
		if(null == commodityBo.getNumber()){
			logger.error(commodityBo.getNumber()+"为空");
			return false;
		}
		if(null == commodityBo.getOriginal()){
			logger.error(commodityBo.getOriginal()+"为空");
			return false;
		}
		if(null == commodityBo.getCommodityId()){
			logger.error(commodityBo.getCommodityId()+"为空");
			return false;
		}
		if("".equals(commodityBo.getUnit())){
			logger.error(commodityBo.getUnit()+"为空");
			return false;
		}
		if(null == commodityBo.getSalesVolume()){
			logger.error(commodityBo.getSalesVolume()+"为空");
			return false;
		}
		if(null == commodityBo.getShelves()){
			logger.error(commodityBo.getShelves()+"为空");
			return false;
		}
		
		return true;
	}
}
