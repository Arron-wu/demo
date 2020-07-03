/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: CustomerDto
 * Author:   Arron-wql
 * Date:     2020/6/20 12:13
 * Description: 用户查询对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 顾客数据传输对象
 *
 * @author qinglong.wu
 * @create 2020/6/20
 * @Version 1.0.0
 */
@Data
@ApiModel("顾客数据传输对象")
public class CustomerDto {

	@ApiModelProperty(value = "名字")
	private String cName;

	@ApiModelProperty(value = "电话")
	private String cPhone;

	@ApiModelProperty(value = "经销商")
	private String dealerName;

	@ApiModelProperty(value = "开始时间")
	private Data startTime;

	@ApiModelProperty(value = "结束时间")
	private Data endTime;

}
