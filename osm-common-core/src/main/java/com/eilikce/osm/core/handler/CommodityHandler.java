package com.eilikce.osm.core.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eilikce.osm.core.bo.common.CommodityShow;
import com.eilikce.osm.core.bo.transformable.Commodity;
import com.eilikce.osm.entity.consumer.CommodityFurther;

public class CommodityHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(CommodityHandler.class);
	
	/**
	 * 根据商品生成对应的图片名称
	 * 目前设计全部以 png 格式作为拓展后缀
	 * @param commodity
	 * @return
	 */
	public static String CommodityImgName(Commodity commodity) {
		String commodityImgName = "";
		String imgRule = commodity.getImgRule();

		switch (imgRule) {
		case "main":
			commodityImgName = commodity.getCommodityId() + "_" + imgRule + ".png";
			break;

		default:
			break;
		}

		return commodityImgName;
	}
	
	/**
	 * 根据商品commodityId和商品imgRule生成对应的图片名称
	 * 目前设计全部以 png 格式作为拓展后缀
	 * @param commodityId
	 * @param imgRule
	 * @return
	 */
	public static String CommodityImgName(String commodityId,String imgRule) {
		String commodityImgName = "";
		
		switch (imgRule) {
		case "main":
			commodityImgName = commodityId + "_" + imgRule + ".png";
			break;
			
		default:
			break;
		}
		
		return commodityImgName;
	}
	
	/**
	 * 根据商品生成对应的图片路径
	 * @param commodity
	 * @return
	 */
	public static String CommodityImgPath(Commodity commodity){
		String imgPath = "";
		String imgRule = commodity.getImgRule();
		
		switch (imgRule) {
		case "main":
			imgPath = imgRule;
			break;

		default:
			imgPath = imgRule;
			break;
		}
		
		return imgPath;
	}
	
	/**
	 * 根据商品imgRule生成对应的图片路径
	 * @param imgRule
	 * @return
	 */
	public static String CommodityImgPath(String imgRule){
		String imgPath = "";
		
		switch (imgRule) {
		case "main":
			imgPath = imgRule;
			break;
			
		default:
			imgPath = imgRule;
			break;
		}
		
		return imgPath;
	}
	
	
	/**
	 * 根据商品生成对应的图片 系统路径
	 * @param commodity
	 * @return
	 */
	public static String CommodityImgSystemPath(Commodity commodity){
		String imgPath = System.getProperty("osm.root") + "image"+ File.separator +"commodity"+ File.separator;
		
		String imgRule = commodity.getImgRule();
		
		switch (imgRule) {
		case "main":
			imgPath += imgRule;
			break;

		default:
			imgPath += imgRule;
			break;
		}
		return imgPath;
	}
	
	
	/**
	 * 将CommodityFurther的List转换为CommodityShow的List
	 * 
	 * @param commodityFurtherList
	 * @return
	 */
	public static List<CommodityShow> commodityGroupListTransform(
			List<CommodityFurther> commodityFurtherList) {
		if (null == commodityFurtherList) {
			LOG.error("CommodityGroupItem的List转换失败，commodityGroupItemList为空");
		}
		List<CommodityShow> commodityShowList = new ArrayList<CommodityShow>();
		for (CommodityFurther cf : commodityFurtherList) {
			CommodityShow bo = new CommodityShow(cf);
			commodityShowList.add(bo);
		}
		return commodityShowList;
	}
}
