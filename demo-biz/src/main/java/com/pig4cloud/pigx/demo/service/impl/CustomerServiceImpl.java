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

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pigx.demo.dto.CustomerDto;
import com.pig4cloud.pigx.demo.entity.Customer;
import com.pig4cloud.pigx.demo.mapper.CustomerMapper;
import com.pig4cloud.pigx.demo.service.CustomerService;
import org.springframework.stereotype.Service;

/**
 * 顾客表
 *
 * @author qinglong.wu
 * @date 2020-06-19 19:46:29
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

	@Override
	public Page findCustomerPageList(Page page, CustomerDto customer) {
		return page.setRecords(this.baseMapper.findCustomerListByPage(page, customer));
	}
}
