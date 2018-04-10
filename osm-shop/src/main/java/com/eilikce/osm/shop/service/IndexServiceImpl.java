package com.eilikce.osm.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.bo.common.CommodityGroupItem;
import com.eilikce.osm.core.bo.transformable.CommodityItem;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.core.handler.CommodityGroupBoHandler;
import com.eilikce.osm.dao.CommodityGroupDao;
import com.eilikce.osm.dao.CommodityItemDao;
import com.eilikce.osm.entity.consumer.CommodityGroupPo;
import com.eilikce.osm.entity.consumer.CommodityGroupItemPo;
import com.eilikce.osm.entity.consumer.CommodityItemPo;

@Service
public class IndexServiceImpl implements IndexService{

	private static Logger logger = Logger.getLogger(IndexServiceImpl.class);
	
	@Autowired
	private CommodityGroupDao commodityGroupDao;
	
	@Autowired
	private CommodityItemDao commodityItemDao;
	
	@Override
	public List<CommodityGroupItem> getAllCommodityGroup() {

		List<CommodityGroupItem> groupBoList = new ArrayList<CommodityGroupItem>();
		List<CommodityGroupPo> commodityGroupList = commodityGroupDao.selectAllCommodityGroup();
		groupBoList = CommodityGroupBoHandler.commodityGroupBoListTransform0(commodityGroupList);
		
		logger.info("获取全部大分类列表");
		
		return groupBoList;
	}

	@Override
	public List<CommodityItem> getAllCommodityItem() {
		List<CommodityItem> commodityItemBoList = new ArrayList<CommodityItem>();
		List<CommodityItemPo> commodityItemList = new ArrayList<CommodityItemPo>();
		commodityItemList = commodityItemDao.selectAllCommodityItem();
		commodityItemBoList = BoTransHandler.entityListToBoList(CommodityItem.class, commodityItemList);
		
		logger.info("获取全部小分类列表");
		
		return commodityItemBoList;
	}

	@Override
	public List<CommodityGroupItem> getAllCommodityGroupAndItem() {
		List<CommodityGroupItem> groupAndBoList = new ArrayList<CommodityGroupItem>();
		List<CommodityGroupItemPo> groupAndItemList = new ArrayList<CommodityGroupItemPo>();
		groupAndItemList = commodityGroupDao.selectAllCommodityGroupAndItem();
		groupAndBoList = CommodityGroupBoHandler.commodityGroupBoListTransform(groupAndItemList);
		logger.info("获取全部大分类小分类列表");
		
		return groupAndBoList;
	}

}
