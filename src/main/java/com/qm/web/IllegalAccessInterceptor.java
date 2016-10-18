package com.qm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qm.common.exception.ExceptionResponseFormat;
import com.qm.common.exception.HttpStatusCode;
import com.qm.common.exception.HttpStatusException;

/**
 * 拦截非法数据请求
 * 每个请求带一个md5编码的请求码参数过来，如果与后台对应不上
 * 则终止该请求访问
 * 创建日期：2015年5月25日
 * @author niezhegang
 */
public class IllegalAccessInterceptor extends HandlerInterceptorAdapter {
	
	private boolean enableFlag = false;
	/**
	 * 功能还未实现，先占个位置
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 * 创建日期：2015年5月25日
	 * 修改说明：
	 * @author niezhegang
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if(enableFlag){
			throw new HttpStatusException.Builder()
						.responseFormat(ExceptionResponseFormat.Json)
						.httpStatusCode(HttpStatusCode.CLIENT_PAYMENT_FORBIDDEN)
						.message("非法请求！")
						.build();
		}
		return super.preHandle(request, response, handler);
	}

	public boolean isEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(boolean enableFlag) {
		this.enableFlag = enableFlag;
	}
	
	

}
