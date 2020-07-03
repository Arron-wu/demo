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

package com.pig4cloud.pigx.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pigx.admin.api.entity.SysUser;
import com.pig4cloud.pigx.admin.api.vo.UserVO;
import com.pig4cloud.pigx.demo.dto.CustomerDto;
import com.pig4cloud.pigx.demo.entity.Staff;
import com.pig4cloud.pigx.demo.entity.User;
import com.pig4cloud.pigx.demo.vo.StaffVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 员工表
 *
 * @author qinglong.wu
 * @date 2020-06-20 19:07:14
 */
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {

	@DS("#last")
	List<UserVO> selectUserList(String dsName);

	@DS("#last")
	Map selectTenant(String dsName);

	List<StaffVo> selectStaffList(Page page, @Param("staff") Staff staff);
}
