package com.pig4cloud.pigx.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.tools.Tool;
import java.util.Arrays;

/**
 * @author qinglong.wu
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StaffType {

	/**
	 * 经销商
	 */
	ONE(1, "经销商"),

	/**
	 * 维修员
	 */
	TWO(2, "维修员");


	/**
	 * 码表id
	 */
	private Integer id;

	/**
	 * 码表值说明
	 */
	private String text;

	/**
	 * 根据id返回对应的text
	 * @param id
	 * @return
	 */
	public static String getText(Integer id){
		if (id!=null){
			StaffType[] staffTypes = StaffType.values();
			for (StaffType staffType: staffTypes) {
				if (id == staffType.getId()) {
					return staffType.getText();
				}
			}
		}
		return null;
	}

}
