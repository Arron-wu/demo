/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: BizException
 * Author:   Arron-wql
 * Date:     2020/6/21 21:46
 * Description: 业务异常类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.exception;

/**
 * 业务异常类
 *
 * @author qinglong.wu
 * @create 2020/6/21
 * @Version 1.0.0
 */
public class BizException extends IllegalStateException {
	public BizException() {
	}

	public BizException(String s) {
		super(s);
	}

	public BizException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public BizException(Throwable throwable) {
		super(throwable);
	}
}
