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

package com.pig4cloud.pigx.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pigx.common.core.util.R;
import com.pig4cloud.pigx.common.log.annotation.SysLog;
import com.pig4cloud.pigx.common.security.annotation.Inner;
import com.pig4cloud.pigx.demo.dto.CustomerDto;
import com.pig4cloud.pigx.demo.entity.Customer;
import com.pig4cloud.pigx.demo.service.CustomerService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 顾客表
 *
 * @author qinglong.wu
 * @date 2020-06-19 19:46:29
 */
@RestController
@AllArgsConstructor
@RequestMapping("/customer")
@Api(value = "customer", tags = "顾客表管理")
public class CustomerController {

	private final CustomerService customerService;

	/**
	 * 分页查询
	 *
	 * @param page     分页对象
	 * @param customer 顾客表
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R getCustomerPage(Page page, CustomerDto customer) {
		Page result = customerService.findCustomerPageList(page, customer);//customerService.page(page, Wrappers.query(customer));
		return R.ok(result);
	}


	/**
	 * 通过id查询顾客表
	 *
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}")
	public R getById(@PathVariable("id") Integer id) {
		return R.ok(customerService.getById(id));
	}

	/**
	 * 新增顾客表
	 *
	 * @param customer 顾客表
	 * @return R
	 */
	@ApiOperation(value = "新增顾客表", notes = "新增顾客表")
	@SysLog("新增顾客表")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('demo_customer_add')")
	public R save(@RequestBody Customer customer) {
		return R.ok(customerService.save(customer));
	}

	/**
	 * 修改顾客表
	 *
	 * @param customer 顾客表
	 * @return R
	 */
	@ApiOperation(value = "修改顾客表", notes = "修改顾客表")
	@SysLog("修改顾客表")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('demo_customer_edit')")
	public R updateById(@RequestBody Customer customer) {
		return R.ok(customerService.updateById(customer));
	}

	/**
	 * 通过id删除顾客表
	 *
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除顾客表", notes = "通过id删除顾客表")
	@SysLog("通过id删除顾客表")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('demo_customer_del')")
	public R removeById(@PathVariable Integer id) {
		return R.ok(customerService.removeById(id));
	}

}
