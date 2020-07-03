package com.pig4cloud.pigx.demo.enums;

/**
 * @author qinglong.wu
 */
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

	StaffType(Integer id, String text) {
		this.id = id;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
