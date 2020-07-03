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
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 员工表
 *
 * @author qinglong.wu
 * @date 2020-06-20 19:07:14
 */
@Data
@TableName("t_staff")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "员工表")
public class Staff extends Model<Staff> {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@ApiModelProperty(value = "")
	private Integer id;
	/**
	 * 编号
	 */
	@ApiModelProperty(value = "编号")
	private String staffNo;
	/**
	 * 名称
	 */
	@ApiModelProperty(value = "名称")
	private String name;
	/**
	 * 年龄
	 */
	@ApiModelProperty(value = "年龄")
	private Integer age;
	/**
	 * 性別
	 */
	@ApiModelProperty(value = "性別")
	private Integer sex;
	/**
	 * 电话
	 */
	@ApiModelProperty(value = "电话")
	private String phone;
	/**
	 * 家庭住址
	 */
	@ApiModelProperty(value = "家庭住址")
	private String adress;
	/**
	 * 系统账号
	 */
	@ApiModelProperty(value = "系统账号")
	private Long userId;
	/**
	 * 角色（0/经销商 1/维修员）
	 */
	@ApiModelProperty(value = "角色（0/经销商 1/维修员）")
	private Integer roleType;
	/**
	 * 区域部门
	 */
	@ApiModelProperty(value = "区域部门")
	private Integer deptId;
	/**
	 * 级别
	 */
	@ApiModelProperty(value = "级别")
	private Integer levelId;
	/**
	 * 入职时间
	 */
	@ApiModelProperty(value = "入职时间")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date entryTime;
	/**
	 * 推荐人
	 */
	@ApiModelProperty(value = "推荐人")
	private String referrer;
	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人")
	private Integer createBy;
	/**
	 * 微信openid
	 */
	@ApiModelProperty(value = "微信openid")
	private String wxOpenid;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	/**
	 * 是否删除
	 */
	@ApiModelProperty(value = "是否删除")
	private Integer isDelete;
}
