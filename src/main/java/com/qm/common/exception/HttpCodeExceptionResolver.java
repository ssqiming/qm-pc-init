package com.qm.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.qm.common.domain.ResponseResult;
import com.qm.web.utils.JsonViewFactory;

/**
 * spring mvc框架通过HandlerExceptionResolver统一捕获controler层抛出的异常 
 * 我们通过实现HandlerExceptionResolver接口定义处理异常的通用逻辑
 * 该类可统一将带HttpErrorCode的errorCode传递给HttpServletResponse对象
 * 
 * 创建日期：2014年7月28日
 * @author niezhegang
 */
public class HttpCodeExceptionResolver implements
		HandlerExceptionResolver, Ordered {
	/** log4j常量 */
	private static final Logger log = Logger.getLogger(HttpCodeExceptionResolver.class);
	/** 处理器优先级，数值越小优先级越高 */
    private int order;
    /**jsp页面异常处理视图*/
    private String exceptionView;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	public String getExceptionView() {
		return exceptionView;
	}

	public void setExceptionView(String exceptionView) {
		this.exceptionView = exceptionView;
	}
	/**
	 * 异常拦截方法，当控制层的方法出现没有处理的异常时会被当前方法拦截，并记录异常日志，返回带有异常消息的模型视图对象
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 * 创建日期：2014年7月28日
	 * 修改说明：
	 * @author niezhegang
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView retModelAndView = null;
    	//首先记录错误日志
		String msg="系统繁忙，请稍后再试！";
		if(ex instanceof CustomException||ex instanceof IllegalArgumentException){//异常类型为自定义异常、IllegalArgumentException则加载自定义异常消息
			msg = ex.getMessage();
		}
    	log.error(msg, ex);
    	HttpStatusException errorCodeException = null;
    	if(ex instanceof HttpStatusException){
    		errorCodeException = (HttpStatusException) ex;
    	}
    	else{
    		//如果不是封装了httpErrorCode的异常，则封装成响应json格式的默认客户端错误异常对象
    		errorCodeException = new HttpStatusException.Builder()
    								.message(ex.getMessage())
    								.cause(ex).responseFormat(ExceptionResponseFormat.Json)
    								.buildDefaultClientException();
    	}
    	
    	if(ExceptionResponseFormat.Jsp.equals(errorCodeException.getResponseFormat())){
    		retModelAndView = new ModelAndView(exceptionView);
    		retModelAndView.addObject(ExceptionModelObject.EXCEPTION_MODEL_OBJECT_NAME, new ExceptionModelObject(errorCodeException));
    	}
    	else{
    		ResponseResult<Object> responseResult = new ResponseResult<Object>(false, msg);
    		retModelAndView = JsonViewFactory.buildJsonView(responseResult);
    	}
    	response.setStatus(errorCodeException.getHttpStatusCode().getStatusCode());
    	return retModelAndView;
	}

	/**
     * 获取最上层的异常消息
     * 
     * @param e
     * @return
     * @created 2014-5-19
     * @author  huanglj
     */
	private String getLastErrorMessage(Throwable e) {
		if(e == null) {
			return null;
		}
		String message = e.getMessage();
		Throwable cause = e.getCause();
		if(message != null && (cause == null || !message.startsWith(cause.getClass().getName()))) {
			return message;
		}
		return getLastErrorMessage(cause);
	}

}
