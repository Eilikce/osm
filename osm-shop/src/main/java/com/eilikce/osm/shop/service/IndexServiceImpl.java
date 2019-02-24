package com.eilikce.osm.shop.service;

import java.util.ArrayList;
import java.util.List;

import com.eilikce.osm.entity.consumer.CommodityGroup;
import com.eilikce.osm.entity.consumer.CommodityGroupItem;
import com.eilikce.osm.entity.consumer.CommodityItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.core.handler.CommodityGroupHandler;
import com.eilikce.osm.dao.CommodityGroupDao;
import com.eilikce.osm.dao.CommodityItemDao;

@Service
public class IndexServiceImpl implements IndexService{

	private static final Logger LOG = LoggerFactory.getLogger(IndexServiceImpl.class);
	
	@Autowired
	private CommodityGroupDao commodityGroupDao;
	
	@Autowired
	private CommodityItemDao commodityItemDao;
	
	@Override
	public List<com.eilikce.osm.core.bo.common.CommodityGroupItem> getAllCommodityGroup() {

		List<com.eilikce.osm.core.bo.common.CommodityGroupItem> groupBoList = new ArrayList<com.eilikce.osm.core.bo.common.CommodityGroupItem>();
		List<CommodityGroup> commodityGroupList = commodityGroupDao.selectAllCommodityGroup();
		groupBoList = CommodityGroupHandler.commodityGroupListTransform0(commodityGroupList);
		
		LOG.info("获取全部大分类列表");
		
		return groupBoList;
	}

	@Override
	public List<com.eilikce.osm.core.bo.transformable.CommodityItem> getAllCommodityItem() {
		List<com.eilikce.osm.core.bo.transformable.CommodityItem> commodityItemBoList = new ArrayList<com.eilikce.osm.core.bo.transformable.CommodityItem>();
		List<CommodityItem> commodityItemList = new ArrayList<CommodityItem>();
		commodityItemList = commodityItemDao.selectAllCommodityItem();
		commodityItemBoList = BoTransHandler.entityListToBoList(com.eilikce.osm.core.bo.transformable.CommodityItem.class, commodityItemList);
		
		LOG.info("获取全部小分类列表");
		
		return commodityItemBoList;
	}

	@Override
	public List<com.eilikce.osm.core.bo.common.CommodityGroupItem> getAllCommodityGroupAndItem() {
		List<com.eilikce.osm.core.bo.common.CommodityGroupItem> groupAndBoList = new ArrayList<com.eilikce.osm.core.bo.common.CommodityGroupItem>();
		List<CommodityGroupItem> groupAndItemList = new ArrayList<CommodityGroupItem>();
		groupAndItemList = commodityGroupDao.selectAllCommodityGroupAndItem();
		groupAndBoList = CommodityGroupHandler.commodityGroupListTransform(groupAndItemList);
		LOG.info("获取全部大分类小分类列表");
		
		return groupAndBoList;
	}

}
