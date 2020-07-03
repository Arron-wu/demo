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
import com.pig4cloud.pigx.demo.dto.StaffDto;
import com.pig4cloud.pigx.demo.entity.Staff;
import com.pig4cloud.pigx.demo.service.StaffService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 员工表
 *
 * @author qinglong.wu
 * @date 2020-06-20 19:07:14
 */
@RestController
@AllArgsConstructor
@RequestMapping("/staff")
@Api(value = "staff", tags = "员工管理")
public class StaffController {

	private final StaffService staffService;

	/**
	 * 分页查询
	 *
	 * @param page  分页对象
	 * @param staff 员工表
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page")
	public R getStaffPage(Page page, Staff staff) {
		return R.ok(staffService.selectStaffList(page, staff));
	}


	/**
	 * 通过id查询员工
	 *
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}")
	public R getById(@PathVariable("id") Integer id) {
		return R.ok(staffService.getById(id));
	}

	/**
	 * 新增员工
	 *
	 * @param staffDto 员工表
	 * @return R
	 */
	@ApiOperation(value = "新增员工", notes = "新增员工")
	@SysLog("新增员工")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('demo_staff_add')")
	public R save(@RequestBody StaffDto staffDto) {
		return R.ok(staffService.save(staffDto));
	}

	/**
	 * 修改员工
	 *
	 * @param staff 员工表
	 * @return R
	 */
	@ApiOperation(value = "修改员工", notes = "修改员工表")
	@SysLog("修改员工")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('demo_staff_edit')")
	public R updateById(@RequestBody Staff staff) {
		return R.ok(staffService.updateById(staff));
	}

	/**
	 * 通过id删除员工
	 *
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除员工", notes = "通过id删除员工")
	@SysLog("通过id删除员工")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('demo_staff_del')")
	public R removeById(@PathVariable Integer id) {
		return R.ok(staffService.removeById(id));
	}

}
