package com.eilikce.osm.core.bo.common;

import java.util.List;
import java.util.Map;

import com.eilikce.osm.core.bo.CommonBo;
import com.eilikce.osm.core.bo.transformable.Commodity;

/**
 * 批量商品对象 封装成功批量插入解析成功的 List<Commodity> , 和批量插入解析失败的 Map<String, Object>
 * 
 * @author Eilik
 *
 */
public class CommodityBatch implements CommonBo {
	boolean parseFlag;
	List<Commodity> successCommodityList;
	List<Map<String, String>> failureCommodityMap;

	public CommodityBatch() {
		super();
		this.parseFlag = true;
	}

	public boolean isParseFlag() {
		return parseFlag;
	}

	public void setParseFlag(boolean parseFlag) {
		this.parseFlag = parseFlag;
	}

	public List<Commodity> getSuccessCommodityList() {
		return successCommodityList;
	}

	public void setSuccessCommodityList(List<Commodity> successCommodityList) {
		this.successCommodityList = successCommodityList;
	}

	public List<Map<String, String>> getFailureCommodityMap() {
		return failureCommodityMap;
	}

	public void setFailureCommodityMap(List<Map<String, String>> failureCommodityMap) {
		this.failureCommodityMap = failureCommodityMap;
	}

	@Override
	public String toString() {
		return "CommodityBatch [parseFlag=" + parseFlag + ", successCommodityList=" + successCommodityList
				+ ", failureCommodityMap=" + failureCommodityMap + "]";
	}

}
