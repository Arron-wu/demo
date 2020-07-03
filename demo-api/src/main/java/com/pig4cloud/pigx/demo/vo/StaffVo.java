/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: StaffVo
 * Author:   Arron-wql
 * Date:     2020/7/2 19:06
 * Description: 员工视图类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 员工视图类
 *
 * @author qinglong.wu
 * @create 2020/7/2
 * @Version 1.0.0
 */
@Data
@ApiModel(value = "员工视图")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class StaffVo {
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
	/**
	 * 等级名称
	 */
	@ApiModelProperty(value = "等级名称")
	private String  levelName;
	/**
	 * 部门名称
	 */
	@ApiModelProperty(value = "部门名称")
	private String  deptName;
	/**
	 * 创建人名称
	 */
	@ApiModelProperty(value = "创建人名称")
	private String  creater;
}
