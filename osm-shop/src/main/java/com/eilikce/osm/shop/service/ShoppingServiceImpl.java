package com.eilikce.osm.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.bo.common.CommodityShow;
import com.eilikce.osm.dao.CommodityDao;
import com.eilikce.osm.entity.consumer.CommodityPo;

@Service
public class ShoppingServiceImpl implements ShoppingService{

	private static final Logger LOG = LoggerFactory.getLogger(ShoppingServiceImpl.class);
	
	@Autowired
	private CommodityDao commodityDao;
	
	@Override
	public List<CommodityShow> getCommodityByGroupIdItemId(int groupId , int itemId) {
		List<CommodityPo> commodityList = new ArrayList<CommodityPo>();
		commodityList = commodityDao.selectCommodityByGroupIdItemId(groupId,itemId);
		
		List<CommodityShow> commodityShowList = new ArrayList<CommodityShow>();
		for(CommodityPo c : commodityList){
			commodityShowList.add(new CommodityShow(c));
		}
		
		LOG.info("根据itemId:" + itemId + "，获取全部商品列表");
		
		return commodityShowList;
	}

	@Override
	public List<CommodityShow> getCommodityByGroupId(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommodityShow> getCommodityBySearch(String search) {
		List<CommodityPo> commodityList = new ArrayList<CommodityPo>();
		commodityList = commodityDao.selectCommodityBySearch(search);
		
		List<CommodityShow> commodityShowList = new ArrayList<CommodityShow>();
		for(CommodityPo c : commodityList){
			commodityShowList.add(new CommodityShow(c));
		}
		
		LOG.info("根据搜索词:" + search + "，获取检索商品列表");
		return commodityShowList;
	}

}
