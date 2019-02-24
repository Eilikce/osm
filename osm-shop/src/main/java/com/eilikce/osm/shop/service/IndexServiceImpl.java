package com.eilikce.osm.shop.service;

import java.util.ArrayList;
import java.util.List;

import com.eilikce.osm.entity.consumer.CommodityGroupPo;
import com.eilikce.osm.entity.consumer.CommodityGroupItemPo;
import com.eilikce.osm.entity.consumer.CommodityItemPo;
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
		List<CommodityGroupPo> commodityGroupPoList = commodityGroupDao.selectAllCommodityGroup();
		groupBoList = CommodityGroupHandler.commodityGroupListTransform0(commodityGroupPoList);
		
		LOG.info("获取全部大分类列表");
		
		return groupBoList;
	}

	@Override
	public List<com.eilikce.osm.core.bo.transformable.CommodityItem> getAllCommodityItem() {
		List<com.eilikce.osm.core.bo.transformable.CommodityItem> commodityItemBoList = new ArrayList<com.eilikce.osm.core.bo.transformable.CommodityItem>();
		List<CommodityItemPo> commodityItemPoList = new ArrayList<CommodityItemPo>();
		commodityItemPoList = commodityItemDao.selectAllCommodityItem();
		commodityItemBoList = BoTransHandler.entityListToBoList(com.eilikce.osm.core.bo.transformable.CommodityItem.class, commodityItemPoList);
		
		LOG.info("获取全部小分类列表");
		
		return commodityItemBoList;
	}

	@Override
	public List<com.eilikce.osm.core.bo.common.CommodityGroupItem> getAllCommodityGroupAndItem() {
		List<com.eilikce.osm.core.bo.common.CommodityGroupItem> groupAndBoList = new ArrayList<com.eilikce.osm.core.bo.common.CommodityGroupItem>();
		List<CommodityGroupItemPo> groupAndItemList = new ArrayList<CommodityGroupItemPo>();
		groupAndItemList = commodityGroupDao.selectAllCommodityGroupAndItem();
		groupAndBoList = CommodityGroupHandler.commodityGroupListTransform(groupAndItemList);
		LOG.info("获取全部大分类小分类列表");
		
		return groupAndBoList;
	}

}
