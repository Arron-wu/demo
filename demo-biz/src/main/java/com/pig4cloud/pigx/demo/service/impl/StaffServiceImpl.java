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
package com.pig4cloud.pigx.demo.service.impl;

import cn.hutool.core.text.StrBuilder;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.codingapi.tx.annotation.TxTransaction;
import com.pig4cloud.pigx.admin.api.dto.UserDTO;
import com.pig4cloud.pigx.admin.api.feign.RemoteUserService;
import com.pig4cloud.pigx.admin.api.vo.UserVO;
import com.pig4cloud.pigx.common.core.constant.SecurityConstants;
import com.pig4cloud.pigx.common.security.service.PigxUser;
import com.pig4cloud.pigx.common.security.util.SecurityUtils;
import com.pig4cloud.pigx.demo.dto.StaffDto;
import com.pig4cloud.pigx.demo.entity.Staff;
import com.pig4cloud.pigx.demo.mapper.StaffMapper;
import com.pig4cloud.pigx.demo.service.StaffService;
import com.pig4cloud.pigx.common.core.util.RandomUtil;
import com.pig4cloud.pigx.demo.utils.StringUtils;
import com.pig4cloud.pigx.demo.vo.StaffVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 员工表
 *
 * @author qinglong.wu
 * @date 2020-06-20 19:07:14
 */
@Service
@RequiredArgsConstructor
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

	private final RemoteUserService remoteUserService;

//	private final RemoteDeptService remoteDeptService;

	@Override
	@TxTransaction(isStart = true)
	@Transactional(rollbackFor = Exception.class)
	public boolean save(StaffDto staffDto) {
		PigxUser currentUser = SecurityUtils.getUser();
		Staff staff = new Staff();
		BeanUtils.copyProperties(staffDto, staff);
		staff.setCreateTime(new Date());
		staff.setIsDelete(0);
		staff.setCreateBy(currentUser.getId());
		staff.setStaffNo(RandomUtil.getRandom(12));
		UserDTO userDto = createUserDto(staffDto);
		//如果是经销商的话，调取用户服务自动创建系统用户接口并返回用户id
		String user_id = remoteUserService.user(userDto);
		staff.setUserId(StringUtils.strToLong(user_id));
		return SqlHelper.retBool(this.baseMapper.insert(staff));
	}

	@Override
	public Page selectStaffList(Page page, Staff staff) {
		List<StaffVo> staffList = baseMapper.selectStaffList(page, staff);
		//塞入部门名称和创建人名称
		StrBuilder deptIds = new StrBuilder();
		StrBuilder userIds = new StrBuilder();
		staffList.stream().forEach(m->{
			deptIds.append(m.getDeptId()+",");
			userIds.append(m.getUserId()+",");
		});
		String deptIdss = deptIds.toString().substring(0, deptIds.toString().length() - 1);
		String userIdss = userIds.toString().substring(0, userIds.toString().length() - 1);
		List<Object> userNames = remoteUserService.userNames(userIdss, SecurityConstants.FROM_IN);
//		List<Object> deptNames = remoteDeptService.deptNames(deptIdss);
		page.setRecords(staffList);
		return page;
	}

	@Override
	public List<UserVO> selectUserList() {
		return baseMapper.selectUserList("pigxx_core");
	}

	@Override
	public Map selectTenant() {
		return baseMapper.selectTenant("pigxx_core");
	}

	public UserDTO createUserDto(StaffDto staffDto) {
		UserDTO userDTO = new UserDTO();
		userDTO.setLockFlag("9");
		userDTO.setPhone(staffDto.getPhone());
		userDTO.setDeptId(staffDto.getDeptId());
		userDTO.setUsername(vertify(staffDto.getUsername()));
		userDTO.setPassword(staffDto.getPassword());
		return userDTO;
	}

	public String vertify(String userName) {
		if (userName.length()<3) return userName+userName.substring(0,userName.length()-1);
		if (userName.length()>20) return userName.substring(0,19);
		return userName;
	}

}
