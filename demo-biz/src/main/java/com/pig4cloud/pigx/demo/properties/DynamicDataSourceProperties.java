/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: DynamicDataSourceProperties
 * Author:   Arron-wql
 * Date:     2020/6/26 17:12
 * Description: 多数据源
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 多数据源
 *
 * @author qinglong.wu
 * @create 2020/6/26
 * @Version 1.0.0
 */
@ConfigurationProperties(prefix = "dynamic")
public class DynamicDataSourceProperties {
	private Map<String, DataSourceProperties> datasource = new LinkedHashMap<>();

	public Map<String, DataSourceProperties> getDatasource() {
		return datasource;
	}

	public void setDatasource(Map<String, DataSourceProperties> datasource) {
		this.datasource = datasource;
	}
}


