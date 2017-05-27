package com.bstek.ureport.utils;

import java.math.BigDecimal;

import com.bstek.ureport.Utils;

/**
 * @author Jacky.gao
 * @since 2017年4月25日
 */
public class ArithUtils {
	/**
	 * @param first
	 * @param second
	 * @return 加法
	 */
	public static Object add(Object first,Object second) {
		BigDecimal a=Utils.toBigDecimal(first);
		BigDecimal b=Utils.toBigDecimal(second);
		return a.add(b).doubleValue();
	}
	/**
	 * @param first
	 * @param second
	 * @return 减法
	 */
	public static Object sub(Object first,Object second) {
		BigDecimal a=Utils.toBigDecimal(first);
		BigDecimal b=Utils.toBigDecimal(second);			
		return a.subtract(b).doubleValue();
	}
	/**
	 * @param first
	 * @param second
	 * @return 乘法
	 */
	public static Object mul(Object first,Object second) {
		BigDecimal a=Utils.toBigDecimal(first);
		BigDecimal b=Utils.toBigDecimal(second);
		return a.multiply(b).doubleValue();
	}
	/**
	 * @param first
	 * @param second
	 * @return 除法
	 */
	public static Object div(Object first,Object second) {
		BigDecimal a=Utils.toBigDecimal(first);
		BigDecimal b=Utils.toBigDecimal(second);
		return a.divide(b,8,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	/**
	 * @param first
	 * @param second
	 * @return complementation 求余
	 */
	public static Object com(Object first,Object second) {
		BigDecimal a=Utils.toBigDecimal(first);
		BigDecimal b=Utils.toBigDecimal(second);
		return a.doubleValue() % b.doubleValue();
	}
}
