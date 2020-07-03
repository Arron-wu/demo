/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.pig4cloud.pigx.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 顾客表
 *
 * @author qinglong.wu
 * @date 2020-06-19 19:46:29
 */
@Data
@TableName("t_customer")
@EqualsAndHashCode(callSuper = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@ApiModel(value = "顾客表")
public class Customer extends Model<Customer> {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@ApiModelProperty(value = "")
	private Integer id;
	/**
	 * 名字
	 */
	@ApiModelProperty(value = "名字")
	private String cName;
	/**
	 * 年龄
	 */
	@ApiModelProperty(value = "年龄")
	private Integer cAge;
	/**
	 * 性别
	 */
	@ApiModelProperty(value = "性别")
	private String cSex;
	/**
	 * 电话
	 */
	@ApiModelProperty(value = "电话")
	private String cPhone;
	/**
	 * 住址
	 */
	@ApiModelProperty(value = "住址")
	private String address;
	/**
	 * 经销商
	 */
	@ApiModelProperty(value = "经销商")
	private String dealerId;
	/**
	 * 优先指派维护员集合
	 */
	@ApiModelProperty(value = "优先指派维护员集合")
	private String prorityIds;
	/**
	 * 微信关联
	 */
	@ApiModelProperty(value = "微信关联")
	private String oppenid;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;
}
