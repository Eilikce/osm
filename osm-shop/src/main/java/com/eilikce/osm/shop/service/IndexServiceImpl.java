package com.eilikce.osm.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.bo.common.CommodityGroupItemBo;
import com.eilikce.osm.core.bo.transformable.CommodityItemBo;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.core.handler.CommodityGroupBoHandler;
import com.eilikce.osm.dao.CommodityGroupDao;
import com.eilikce.osm.dao.CommodityItemDao;
import com.eilikce.osm.entity.consumer.CommodityGroup;
import com.eilikce.osm.entity.consumer.CommodityGroupItem;
import com.eilikce.osm.entity.consumer.CommodityItem;

@Service
public class IndexServiceImpl implements IndexService{

	private static Logger logger = Logger.getLogger(IndexServiceImpl.class);
	
	@Autowired
	private CommodityGroupDao commodityGroupDao;
	
	@Autowired
	private CommodityItemDao commodityItemDao;
	
	@Override
	public List<CommodityGroupItemBo> getAllCommodityGroup() {

		List<CommodityGroupItemBo> groupBoList = new ArrayList<CommodityGroupItemBo>();
		List<CommodityGroup> commodityGroupList = commodityGroupDao.selectAllCommodityGroup();
		groupBoList = CommodityGroupBoHandler.commodityGroupBoListTransform0(commodityGroupList);
		
		logger.info("获取全部大分类列表");
		
		return groupBoList;
	}

	@Override
	public List<CommodityItemBo> getAllCommodityItem() {
		List<CommodityItemBo> commodityItemBoList = new ArrayList<CommodityItemBo>();
		List<CommodityItem> commodityItemList = new ArrayList<CommodityItem>();
		commodityItemList = commodityItemDao.selectAllCommodityItem();
		commodityItemBoList = BoTransHandler.entityListToBoList(CommodityItemBo.class, commodityItemList);
		
		logger.info("获取全部小分类列表");
		
		return commodityItemBoList;
	}

	@Override
	public List<CommodityGroupItemBo> getAllCommodityGroupAndItem() {
		List<CommodityGroupItemBo> groupAndBoList = new ArrayList<CommodityGroupItemBo>();
		List<CommodityGroupItem> groupAndItemList = new ArrayList<CommodityGroupItem>();
		groupAndItemList = commodityGroupDao.selectAllCommodityGroupAndItem();
		groupAndBoList = CommodityGroupBoHandler.commodityGroupBoListTransform(groupAndItemList);
		logger.info("获取全部大分类小分类列表");
		
		return groupAndBoList;
	}

}
