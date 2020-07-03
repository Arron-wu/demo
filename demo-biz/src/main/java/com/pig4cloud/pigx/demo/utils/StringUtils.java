package com.pig4cloud.pigx.demo.utils;

import io.swagger.models.auth.In;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 *
 * @author haiyang.li
 */
public class StringUtils {

	public static final String CHARSET_UTF_8 = "UTF-8";

	public static final String CHARSET_ISO_8859_1 = "ISO-8859-1";

	public static final String DOT = ".";

	public static final String COMMA = ",";

	public static final String REGEX_NUM = "(-|\\+)?(\\d+)?(\\.\\d+)?$";

	/**
	 * 记录真实堆栈信息
	 */
	public static String stackMsg(Exception e) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		return stringWriter.getBuffer().toString();
	}

	/**
	 * 集合拼接成字符串
	 */
	public static String join(Collection collection, String separator) {
		return org.apache.commons.lang.StringUtils.join(collection, separator);
	}

	/**
	 * 集合拼接成字符串
	 */
	public static String join(Collection collection) {
		return join(collection, COMMA);
	}


	/**
	 * oracle nvl 函数
	 */
	public static String nvl(Object obj) {
		return obj != null ? obj.toString() : "";
	}

	public static String add(Object obj, String add) {
		return obj == null ? add : obj.toString() + add;
	}

	/**
	 * 字符是否为中文
	 */
	private static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}

	/**
	 * 字符串是否有中文
	 */
	public static boolean isChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 字符串转Double
	 */
	public static Double strToDou(List<String> testStr) {
		//去除空格
		double count = 0;
		if (testStr.size() == 0) {
			return count;
		}
		for (String str : testStr) {
			boolean flag = hasText(str);
			if (flag) {
				count = count + Double.valueOf(str);
			}
		}
		return count;
	}

	public static boolean hasText(String str) {
		return str != null && str.trim().length() > 0;
	}


	/**
	 * 字符串转Long
	 */
	public static Long strToLong(String str) {
		long count = 0;
		boolean flag = hasText(str);
		if (flag) {
			count = count + Long.valueOf(str);
		}
		return count;
	}

	/**
	 * 字符串转int
	 */
	public static int strToInt(String str) {
		int count = 0;
		boolean flag = hasText(str);
		if (flag) {
			count = count + Integer.parseInt(str);
		}
		return count;
	}

}
