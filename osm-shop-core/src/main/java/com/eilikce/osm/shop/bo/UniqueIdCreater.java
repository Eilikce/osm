package com.eilikce.osm.shop.bo;

public class UniqueIdCreater {
	/**
	 * 变量设置
	 * 13毫秒值后6位
	 * 唯一性信息前后拼接两位随机数取哈希再取正数
	 * @param unique_msg	自定义唯一性信息，尽量保证唯一
	 * @return
	 */
	public static String uniqueIdCreater(String unique_msg) {

		int per = (int) (Math.random() * 100);
		int sub = (int) (Math.random() * 100);
		int hashId = (per + unique_msg + sub).hashCode();
		hashId = hashId > 0 ? hashId : hashId * (-1);
		String commodityId = timeMillis6Figures() + "_" + hashId;
		return commodityId;
	}

	/**
	 * 截取当前时间13毫秒值后六位
	 * 
	 * @return
	 */
	private static int timeMillis6Figures() {
		long time = System.currentTimeMillis();
		int timeBefore = (int) (time / 1000000);
		int rtn = (int) (time - (timeBefore * 1000000));
		return rtn;
	}
}
