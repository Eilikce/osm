package com.eilikce.osm.util;

public class MathUtil {

	/**
	 * Float类型最多保留两位小数
	 * @param num
	 * @return
	 */
	public static Float floatRound2(Float num	){
		if(null == num){
			return null;
		}
		num = (float)(Math.round(num*100))/100;
		return num;
	
	}
	
	/**
	 * 计算两数字差值，返回结果保留两位小数
	 * @param num1	减数
	 * @param num2	被减数
	 * @param salesVolume
	 * @return
	 */
	public static float subtractionRound2(float num1,float num2){
		float num = num2 - num1;
		num = floatRound2(num);
		return num;
	}
	
	/**
	 * 计算两数字乘积，返回结果保留两位小数
	 * @param num1	被乘数
	 * @param num2	乘数
	 * @return
	 */
	public static float multiplcativeRound2(float num1,float num2){
		float num = num1*num2;
		num = floatRound2(num);
		return num;
	}
}
