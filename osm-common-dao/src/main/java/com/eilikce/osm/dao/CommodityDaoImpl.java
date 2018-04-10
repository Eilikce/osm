package com.eilikce.osm.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.entity.consumer.CommodityPo;
import com.eilikce.osm.entity.consumer.CommodityFurtherPo;

@Repository
public class CommodityDaoImpl implements CommodityDao {

	private static final String NAMESPACE = CommodityDaoImpl.class.getPackage().getName() + "." + CommodityDaoImpl.class.getSimpleName() + ".";
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Integer selectCount() {
		Integer count = (Integer)sqlSessionTemplate.selectOne(NAMESPACE + "selectCount");
		return count;
	}

	@Override
	public List<CommodityPo> selectAllCommodity() {
		List<CommodityPo> commodityList = new ArrayList<CommodityPo>();
		commodityList = sqlSessionTemplate.selectList(NAMESPACE + "selectAllCommodity");
		return commodityList;
	}

	@Override
	public List<CommodityPo> selectCommodityByGroupIdItemId(int groupId , int itemId) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("groupId", groupId);
		map.put("itemId", itemId);
		List<CommodityPo> commodityList = new ArrayList<CommodityPo>();
		commodityList = sqlSessionTemplate.selectList(NAMESPACE + "selectByGroupIdItemId" , map);
		return commodityList;
	}

	@Override
	public CommodityPo selectById(String commodityId) {
		CommodityPo commodity = (CommodityPo)sqlSessionTemplate.selectOne(NAMESPACE + "selectById", commodityId);
		return commodity;
	}

	@Override
	public List<CommodityPo> selectCommodityBySearch(String search) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("search", search);
		List<CommodityPo> commodityList = new ArrayList<CommodityPo>();
		commodityList = sqlSessionTemplate.selectList(NAMESPACE + "selectCommodityBySearch" , search);
		return commodityList;
	}

	@Override
	public List<CommodityPo> selectCommodityByPage(int page) {
		int step = page/10;
		List<CommodityPo> commodityList = new ArrayList<CommodityPo>();
		commodityList = sqlSessionTemplate.selectList(NAMESPACE + "selectCommodityByPage" , step);
		return commodityList;
	}

	@Override
	public List<CommodityFurtherPo> selectCommodityFurtherByPage(int page, int pageSize) {
		int step = (page-1)*pageSize;
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("step", step);
		map.put("pageSize", pageSize);
		
		List<CommodityFurtherPo> commodityFurtherList = new ArrayList<CommodityFurtherPo>();
		commodityFurtherList = sqlSessionTemplate.selectList(NAMESPACE + "selectCommodityFurtherByPage" , map);
		return commodityFurtherList;
	}

	@Override
	public List<CommodityFurtherPo> selectCommodityFurtherByPageSearch(int page, int pageSize, String search) {
		int step = (page-1)*pageSize;
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("step", step);
		map.put("pageSize", pageSize);
		map.put("search", search);
		
		List<CommodityFurtherPo> commodityFurtherList = new ArrayList<CommodityFurtherPo>();
		commodityFurtherList = sqlSessionTemplate.selectList(NAMESPACE + "selectCommodityFurtherByPageSearch" , map);
		return commodityFurtherList;
	}

	@Override
	public CommodityFurtherPo selectCommodityFurtherById(String commodityId) {
		CommodityFurtherPo commodityFurther = (CommodityFurtherPo)sqlSessionTemplate.selectOne(NAMESPACE + "selectCommodityFurtherById", commodityId);
		return commodityFurther;
	}

	@Override
	public CommodityFurtherPo selectCommodityFurtherByBarcode(int barcode) {
		CommodityFurtherPo commodityFurther = (CommodityFurtherPo)sqlSessionTemplate.selectOne(NAMESPACE + "selectCommodityFurtherByBarcode", barcode);
		return commodityFurther;
	}

	@Override
	public int insertCommodity(CommodityPo commodity) {
		int insert = sqlSessionTemplate.insert(NAMESPACE + "insertCommodity", commodity);
		return insert;
	}

	@Override
	public int insertCommodityList(List<CommodityPo> commodityList) {
		int insert = sqlSessionTemplate.insert(NAMESPACE + "insertCommodityList", commodityList);
		return insert;
	}

	@Override
	public int updateCommodity(CommodityPo commodity) {
		int update =sqlSessionTemplate.update(NAMESPACE + "updateCommodity", commodity);
		return update;
	}

	@Override
	public int selectCountByPage(int page, int pageSize) {
		int step = (page-1)*pageSize;
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("step", step);
		map.put("pageSize", pageSize);
		
		int count = sqlSessionTemplate.selectOne(NAMESPACE + "selectCountByPage" , map);
		return count;
	}

	@Override
	public int selectShelvesById(String commodityId) {
		int shelves = (int)sqlSessionTemplate.selectOne(NAMESPACE + "selectShelvesById", commodityId);
		return shelves;
	}

	@Override
	public int updateShelvesById(String commodityId, int shelves) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("commodityId", commodityId);
		map.put("shelves", shelves);
		int update =sqlSessionTemplate.update(NAMESPACE + "updateShelvesById", map);
		return update;
	}

	@Override
	public int deleteCommodityById(String commodityId) {
		int delete = sqlSessionTemplate.delete(NAMESPACE + "deleteCommodityById", commodityId);
		return delete;
	}

	@Override
	public int deleteCommodityByStartEndId(int startCommodityId, int endCommodityId) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("startCommodityId", startCommodityId);
		map.put("endCommodityId", endCommodityId);
		int delete = sqlSessionTemplate.delete(NAMESPACE + "deleteCommodityByStartEndId", map);
		return delete;
	}

	@Override
	public int selectCountByBarcode(int barcode) {
		Integer count = (Integer) sqlSessionTemplate.selectOne(NAMESPACE + "selectCountByBarcode", barcode);
		return count;
	}

}
