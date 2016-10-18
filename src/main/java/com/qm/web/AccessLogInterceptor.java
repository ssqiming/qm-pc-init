package com.qm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qm.service.BusinessLogService;

/**
 * 记录访问日志的拦截器
 * 创建日期：2015年5月8日
 * @author niezhegang
 */
public class AccessLogInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private BusinessLogService busineLogService;
	/**日志记录*/
	private Logger logger = Logger.getLogger(this.getClass());
	
	/** 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 * 创建日期：2015年5月8日
	 * 修改说明：
	 * @author niezhegang
	*/
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		try {
		
			busineLogService.writeRequestAccessLog(request);
		} catch (Exception e) {
			logger.error("保存业务访问日志信息出错 ",e);
		}
		return super.preHandle(request, response, handler);
	}

	public BusinessLogService getBusineLogService() {
		return busineLogService;
	}

	public void setBusineLogService(BusinessLogService busineLogService) {
		this.busineLogService = busineLogService;
	}
	
}
