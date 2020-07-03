package com.pig4cloud.pigx.demo.utils;

import com.pig4cloud.pigx.demo.enums.StaffType;

/**
 * @author qinglong.wu
 */
public class StaffTypeUtils {

	/**
	 * 判断是不是经销商
	 */
	public static boolean isDealer(Integer payType) {
		return StaffType.ONE.getId().equals(payType);
	}

}
