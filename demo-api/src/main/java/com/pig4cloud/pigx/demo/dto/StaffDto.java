/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: StaffDto
 * Author:   Arron-wql
 * Date:     2020/6/21 0:25
 * Description: 员工数据传输对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工数据传输对象
 *
 * @author qinglong.wu
 * @create 2020/6/21
 * @Version 1.0.0
 */
@Data
@ApiModel("员工数据传输对象")
public class StaffDto implements Serializable {
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
	private Integer userId;
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
	 * 是否删除
	 */
	@ApiModelProperty(value = "是否删除")
	private Integer isDelete;
	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	private String username;
	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
	private String password;
}
