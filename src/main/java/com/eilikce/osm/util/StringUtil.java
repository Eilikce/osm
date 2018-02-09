package com.eilikce.osm.util;

public class StringUtil {
	
	/**
	 * 将null字符串转化为""
	 * @param str
	 * @return
	 */
	public static String StringNullTransform(String str){
		return str != null ? str : "";
	}
	
	/**
	 * 转化字符串为Integer
	 * 小数化为整数
	 * 无法转换返回null
	 * @param str
	 * @return
	 */
	public static Integer IntegerParse(String str) {
		if (str == null) {
			return null;
		}
		str = str.trim();
		try {
			if(str.contains(".")){
				str = str.substring(0,str.indexOf("."));
			}
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * 转化字符串为Float
	 * 无法转换返回null
	 * @param str
	 * @return
	 */
	public static Float FloatParse(String str) {
		if (str == null) {
			return null;
		}
		str = str.trim();
		try {
			return Float.parseFloat(str);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
}
