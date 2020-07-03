/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: CustomerVo
 * Author:   Arron-wql
 * Date:     2020/6/20 12:23
 * Description: 顾客视图对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 顾客视图对象
 *
 * @author qinglong.wu
 * @create 2020/6/20
 * @Version 1.0.0
 */
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@ApiModel(value = "顾客表")
public class CustomerVo {
	/**
	 * 编号
	 */
	@ApiModelProperty(value = "编号")
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
	 * 经销商
	 */
	@ApiModelProperty(value = "经销商")
	private String dealerName;
	/**
	 * 优先指派维修员集合
	 */
	@ApiModelProperty(value = "优先指派维护员集合")
	private String prorityNames;
	/**
	 * 微信关联
	 */
	@ApiModelProperty(value = "微信关联")
	private String oppenid;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
}
