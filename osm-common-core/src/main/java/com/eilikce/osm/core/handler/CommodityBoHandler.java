package com.eilikce.osm.core.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.eilikce.osm.core.bo.CommodityBo;
import com.eilikce.osm.core.bo.CommodityShow;
import com.eilikce.osm.entity.consumer.CommodityFurther;
import com.eilikce.osm.util.UniqueIdCreater;

public class CommodityBoHandler {
	
	private static Logger logger = Logger.getLogger(CommodityBoHandler.class);
	
	/**
	 * commodityId 生成器
	 * 变量设置
	 * 13毫秒值后6位
	 * 商品名称前后拼接两位随机数取哈希再取正数
	 * @param commodityName
	 * @return commodityId
	 */
	public static String commodityIdCreater(String commodityName) {
		String commodityId = UniqueIdCreater.uniqueIdCreater(commodityName);
		return commodityId;
	}
	
	
	/**
	 * 根据商品生成对应的图片名称
	 * 目前设计全部以 png 格式作为拓展后缀
	 * @param commodityBo
	 * @return
	 */
	public static String CommodityImgName(CommodityBo commodityBo) {
		String commodityImgName = "";
		String imgRule = commodityBo.getImgRule();

		switch (imgRule) {
		case "main":
			commodityImgName = commodityBo.getCommodityId() + "_" + imgRule + ".png";
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
	 * @param commodityBo
	 * @return
	 */
	public static String CommodityImgPath(CommodityBo commodityBo){
		String imgPath = "";
		String imgRule = commodityBo.getImgRule();
		
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
	 * @param commodityBo
	 * @return
	 */
	public static String CommodityImgSystemPath(CommodityBo commodityBo){
		String imgPath = System.getProperty("osm.root") + "image"+ File.separator +"commodity"+ File.separator;
		
		String imgRule = commodityBo.getImgRule();
		
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
	public static List<CommodityShow> commodityGroupBoListTransform(
			List<CommodityFurther> commodityFurtherList) {
		if (null == commodityFurtherList) {
			logger.error("CommodityGroupItemBo的List转换失败，commodityGroupItemList为空");
		}
		List<CommodityShow> commodityShowList = new ArrayList<CommodityShow>();
		for (CommodityFurther cf : commodityFurtherList) {
			CommodityShow bo = new CommodityShow(cf);
			commodityShowList.add(bo);
		}
		return commodityShowList;
	}
}
