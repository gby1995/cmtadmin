package com.altra.common.util.page;

import java.util.List;

/**
 * 验证工具类
 * 
 * @author baitao
 * @date 2016.7.6
 */
public class ValidateUtil {

	/**
	 * 判断对象是否是空或者空字符串
	 * 
	 * @param object
	 * @return boolean
	 */
	public static boolean isNullAndIsStr(Object obj) {
		if (obj != null && !"".equals(obj) && !"null".equals(obj)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 判断集合对象是否是空或者size大于0
	 * 
	 * @param object
	 * @return boolean
	 */
	public static boolean isNullAndSize(List<?> objs) {
		if (objs != null && objs.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 判断数组是否是空或者size大于0
	 * 
	 * @param object
	 * @return boolean
	 */
	public static boolean isNullAndSize(String[] objs) {
		if (objs != null && objs.length > 0) {
			return true;
		} else {
			return false;
		}
	}
	 
}
