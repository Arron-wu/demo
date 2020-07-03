/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: RequestFilter
 * Author:   Arron-wql
 * Date:     2020/6/21 1:15
 * Description: request过滤器将requestBody向后传递
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * request过滤器将requestBody向后传递
 *
 * @author qinglong.wu
 * @create 2020/6/21
 * @Version 1.0.0
 */
public class RequestFilter implements Filter {
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {
		ServletRequest requestWrapper = null;
		if (request instanceof HttpServletRequest) {
			requestWrapper = new RequestWrapper((HttpServletRequest) request);
		}
		//获取请求中的流，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
		// 在chain.doFiler方法中传递新的request对象
		if (requestWrapper == null) {
			chain.doFilter(request, response);
		} else {
			chain.doFilter(requestWrapper, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
