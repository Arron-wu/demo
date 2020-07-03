/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: PublicApi
 * Author:   Arron-wql
 * Date:     2020/6/26 11:31
 * Description: 公用暴露接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pig4cloud.pigx.admin.api.vo.UserVO;
import com.pig4cloud.pigx.common.core.util.R;
import com.pig4cloud.pigx.common.security.annotation.Inner;
import com.pig4cloud.pigx.demo.entity.Staff;
import com.pig4cloud.pigx.demo.mapper.StaffMapper;
import com.pig4cloud.pigx.demo.service.impl.SnowFlakeService;
import com.pig4cloud.pigx.demo.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 公用暴露接口
 *
 * @author qinglong.wu
 * @create 2020/6/26
 * @Version 1.0.0
 */

@Inner(false)
@RestController
@AllArgsConstructor
@RequestMapping("/public")
@Api(value = "public", tags = "公用暴露测试接口")
public class PublicApi {

	private final StaffService staffService;

	private final StaffMapper staffMapper;

	private final SnowFlakeService snowFlakeService;
	/**
	 * mp条件构造的使用
	 *
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "mp条件构造的使用", notes = "mp条件构造的使用")
	@GetMapping("/testDynamicDS")
	public R testMP() {
		HashMap<String, Object> map = new HashMap<>();
		LambdaQueryWrapper<Staff> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		List<Staff> list = staffMapper.selectList(lambdaQueryWrapper.and(wql -> wql.like(Staff::getName, "杨").gt(Staff::getAge, 20)));
		List<UserVO> userVOS = staffService.selectUserList();
		Map tenant = staffService.selectTenant();
		map.put("staffList", list);
		map.put("userList", tenant);
		map.put("userList", userVOS);
		return R.ok(map);
	}

	/**
	 * Lamda使用
	 *
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "Lamda使用", notes = "Lamda使用")
	@GetMapping("/testLamda")
	public R testLamda() {
		//日期时间API
		//1.获取指定地方的时区
		ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
		//2.获取默认时区
		ZoneId systemDefault = ZoneId.systemDefault();
		System.out.println(shanghaiZoneId + "   " + systemDefault);
		//获取ZonedDateTime
		LocalDateTime now = LocalDateTime.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(now, shanghaiZoneId);
		System.out.println(now + "   " + zonedDateTime);
		//获取localdatetime  localTime  localdate
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("localDateTime : " + localDateTime);
		LocalDateTime plusYears = localDateTime.plusYears(3);
		System.out.println("plusYears : " + plusYears);
		return R.ok();
	}

	//已测
	private Executor executor = Executors.newFixedThreadPool(50);
	@ApiOperation(value = "多线程的使用")
	@RequestMapping(value = "testDuoXC",method = RequestMethod.GET)
	@ResponseBody
	public R testDuoXC() {
//		CompletableFuture<UserPos> future = CompletableFuture.supplyAsync(() -> {
//			UserPos user = new UserPos();
//			long l = 0;
//			user.setPosId(l);
//			user.setUserPosId(l);
//			return user;
//		},executor);
//		CompletableFuture<Long> future2 = CompletableFuture.supplyAsync(() -> {
//			User userFromDB = userService.getById(1);
//			return userFromDB.getUserId();
//		},executor);
//		CompletableFuture<UserPos> f = future.thenCombine(future2, (x, y) ->{
//			x.setUserId(y);
//			return x;
//		});
//		return R.ok(f.join());
		return null;
	}

	//已测
	@ApiOperation(value = "雪花算法")
	@RequestMapping(value = "testDuoSnowFlake",method = RequestMethod.GET)
	@ResponseBody
	public R testDuoSnowFlake() {
		long snowFlakeId = snowFlakeService.snowFlakeId();
		return R.ok(snowFlakeId);
	}


}
