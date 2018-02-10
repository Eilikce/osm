package com.eilikce.osm.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.dao.CommodityDao;
import com.eilikce.osm.entity.consumer.Commodity;
import com.eilikce.osm.shop.bo.consumer.CommodityShow;

@Service
public class ShoppingServiceImpl implements ShoppingService{

	private static Logger logger = Logger.getLogger(ShoppingServiceImpl.class);
	
	@Autowired
	private CommodityDao commodityDao;
	
	@Override
	public List<CommodityShow> getCommodityByGroupIdItemId(int groupId , int itemId) {
		List<Commodity> commodityList = new ArrayList<Commodity>();
		commodityList = commodityDao.selectCommodityByGroupIdItemId(groupId,itemId);
		
		List<CommodityShow> commodityShowList = new ArrayList<CommodityShow>();
		for(Commodity c : commodityList){
			commodityShowList.add(new CommodityShow(c));
		}
		
		logger.info("根据itemId:" + itemId + "，获取全部商品列表");
		
		return commodityShowList;
	}

	@Override
	public List<CommodityShow> getCommodityByGroupId(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommodityShow> getCommodityBySearch(String search) {
		List<Commodity> commodityList = new ArrayList<Commodity>();
		commodityList = commodityDao.selectCommodityBySearch(search);
		
		List<CommodityShow> commodityShowList = new ArrayList<CommodityShow>();
		for(Commodity c : commodityList){
			commodityShowList.add(new CommodityShow(c));
		}
		
		logger.info("根据搜索词:" + search + "，获取检索商品列表");
		return commodityShowList;
	}

}
