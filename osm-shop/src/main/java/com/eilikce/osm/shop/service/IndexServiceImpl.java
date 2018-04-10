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
	public List<CommodityGroupItemBo> getAllCommodityGroup() {

		List<CommodityGroupItemBo> groupBoList = new ArrayList<CommodityGroupItemBo>();
		List<CommodityGroupPo> commodityGroupList = commodityGroupDao.selectAllCommodityGroup();
		groupBoList = CommodityGroupBoHandler.commodityGroupBoListTransform0(commodityGroupList);
		
		logger.info("获取全部大分类列表");
		
		return groupBoList;
	}

	@Override
	public List<CommodityItemBo> getAllCommodityItem() {
		List<CommodityItemBo> commodityItemBoList = new ArrayList<CommodityItemBo>();
		List<CommodityItemPo> commodityItemList = new ArrayList<CommodityItemPo>();
		commodityItemList = commodityItemDao.selectAllCommodityItem();
		commodityItemBoList = BoTransHandler.entityListToBoList(CommodityItemBo.class, commodityItemList);
		
		logger.info("获取全部小分类列表");
		
		return commodityItemBoList;
	}

	@Override
	public List<CommodityGroupItemBo> getAllCommodityGroupAndItem() {
		List<CommodityGroupItemBo> groupAndBoList = new ArrayList<CommodityGroupItemBo>();
		List<CommodityGroupItemPo> groupAndItemList = new ArrayList<CommodityGroupItemPo>();
		groupAndItemList = commodityGroupDao.selectAllCommodityGroupAndItem();
		groupAndBoList = CommodityGroupBoHandler.commodityGroupBoListTransform(groupAndItemList);
		logger.info("获取全部大分类小分类列表");
		
		return groupAndBoList;
	}

}
