package com.iwhale.dynamic.util;

import org.apache.commons.lang.ArrayUtils;

import java.util.Set;
import java.util.TreeSet;

/**
 * 数组相关的工具类
 *
 */
public class ArrayUtil {

	/**
	 * 字符串数组转换为Long数组
	 * @param aryStr  字符串数组
	 * @return Long数组
	 */
	public static Long[] convertArray(String[] aryStr) {
		if(ArrayUtils.isEmpty(aryStr)) {
			return ArrayUtils.EMPTY_LONG_OBJECT_ARRAY;
		}
		Long[] aryLong = new Long[aryStr.length];
		for (int i = 0; i < aryStr.length; i++) {
			aryLong[i] = Long.parseLong(aryStr[i]);
		}
		return aryLong;
	}
	
	
	/**
	 * Long数组转换为字符串数组
	 * @param aryLong Long数组
	 * @return 字符串数组
	 */
	public static String[] convertArray(Long[] aryLong) {
		if(ArrayUtils.isEmpty(aryLong))
			return ArrayUtils.EMPTY_STRING_ARRAY;
		String[] aryStr = new String[aryLong.length];
		for (int i = 0; i < aryStr.length; i++) {
			aryStr[i] = String.valueOf(aryStr[i]);
		}
		return aryStr;
	}
	
	/**
	 * 字符串数组去重复
	 * @param arys
	 * @return
	 */
	public static String[] unique(String[] arys) {
		Set<String> set = new TreeSet<String>();//新建一个set集合
        for (String s : arys) {
            set.add(s);
        }
        String[] arr2 = set.toArray(new String[0]);
        return arr2;
	}
}
