/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: RequestWrapper
 * Author:   Arron-wql
 * Date:     2020/6/21 1:11
 * Description: 解决requestBody数据丢失问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.config;

import com.pig4cloud.pigx.common.core.util.HttpUtil;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * 解决requestBody数据丢失问题
 *
 * @author qinglong.wu
 * @create 2020/6/21
 * @Version 1.0.0
 */
public class RequestWrapper extends HttpServletRequestWrapper {
	private final byte[] body;

	public RequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		body = HttpUtil.getBodyString(request).getBytes(Charset.forName("UTF-8"));
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {

		final ByteArrayInputStream bais = new ByteArrayInputStream(body);

		return new ServletInputStream() {

			@Override
			public int read() throws IOException {
				return bais.read();
			}

			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener readListener) {

			}
		};
	}
}



