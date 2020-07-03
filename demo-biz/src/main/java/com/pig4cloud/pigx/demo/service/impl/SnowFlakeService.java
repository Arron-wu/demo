/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: IdGenerateSnowFlake
 * Author:   Arron-wql
 * Date:     2020/6/28 21:28
 * Description: 雪花算法生成住建
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 雪花算法生成住建
 *
 * @author qinglong.wu
 * @create 2020/6/28
 * @Version 1.0.0
 */
@Slf4j
@Component
public class SnowFlakeService {
	private long workId = 0;
	private long dataCenterId = 0;
	private Snowflake snowflake = IdUtil.createSnowflake(workId,dataCenterId);

	@PostConstruct
	public void init()
	{
		try {
			workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
			log.info("当前机器的workId为:{}",workId);
		}catch (Exception e){
			e.printStackTrace();
			log.warn("当前机器的workId获取失败,原因:{}",e);
			workId = NetUtil.getLocalhostStr().hashCode();
		}
	}

	public synchronized long snowFlakeId(){
		return snowflake.nextId();
	}

	public synchronized long snowFlakeId(long workId,long dataCenterId){
		Snowflake snowflake = IdUtil.createSnowflake(workId,dataCenterId);
		return snowflake.nextId();
	}

}
