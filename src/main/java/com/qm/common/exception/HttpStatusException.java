package com.qm.common.exception;

import org.apache.commons.lang3.StringUtils;
/**
 * 封装http状态码的异常对象
 * 创建日期：2014年7月28日
 * @author niezhegang
 */
public class HttpStatusException extends RuntimeException {
	
	private static final long serialVersionUID = 738679544795562430L;
	/**http错误码*/
	private HttpStatusCode httpStatusCode;
	/**异常的响应格式，默认Json*/
	private ExceptionResponseFormat responseFormat;
	
	private HttpStatusException(Builder builder) {
		super(builder.message, builder.cause);
		setResponseFormat(builder.responseFormat);
		setHttpStatusCode(builder.httpStatusCode);
	}
	public ExceptionResponseFormat getResponseFormat() {
		return responseFormat;
	}
	private void setResponseFormat(
			ExceptionResponseFormat responseFormat) {
		if(responseFormat != null)
			this.responseFormat = responseFormat;
	}
	
	public HttpStatusCode getHttpStatusCode() {
		return httpStatusCode;
	}
	private void setHttpStatusCode(HttpStatusCode httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	@Override
	public String getMessage() {
		String msg = super.getMessage();
		return StringUtils.isBlank(msg) && httpStatusCode != null ?  httpStatusCode.getDescription() : msg;
	}
	/**
	 * HttpStatusException构建器
	 * 创建日期：2014年8月20日
	 * @author niezhegang
	 */
	public static class Builder{
		/**http错误码*/
		private HttpStatusCode httpStatusCode;
		/**异常的响应格式，默认Json*/
		private ExceptionResponseFormat responseFormat = ExceptionResponseFormat.Json;
		/**异常信息*/
		private String message;
		/**异常原因*/
		private Throwable cause;
		
		public Builder httpStatusCode(HttpStatusCode httpStatusCode){
			this.httpStatusCode = httpStatusCode;
			return this;
		}
		
		public Builder responseFormat(ExceptionResponseFormat responseFormat){
			this.responseFormat = responseFormat;
			return this;
		}
		
		public Builder message(String message){
			this.message = message;
			return this;
		}
		
		public Builder cause(Throwable cause){
			this.cause = cause;
			return this;
		}
		/**
		 * 构建一个HttpStatusException对象
		 * @return
		 * 创建日期：2014年8月20日
		 * 修改说明：
		 * @author niezhegang
		 */
		public HttpStatusException build(){
			return new HttpStatusException(this);
		}
		/**
		 * 构建一个默认返回http客户端异常状态码（400）的HttpStatusException对象
		 * @return
		 * 创建日期：2014年8月20日
		 * 修改说明：
		 * @author niezhegang
		 */
		public HttpStatusException buildDefaultClientException(){
			if(this.httpStatusCode == null)
				this.httpStatusCode = HttpStatusCode.DefaultClientErrorCode;
			return new HttpStatusException(this);
		}
		/**
		 * 构建一个默认返回http服务端异常状态码（503）的HttpStatusException对象
		 * @return
		 * 创建日期：2014年8月20日
		 * 修改说明：
		 * @author niezhegang
		 */
		public HttpStatusException buildDefaultServerException(){
			if(this.httpStatusCode == null)
				this.httpStatusCode = HttpStatusCode.DefaultServerErrorCode;
			return new HttpStatusException(this);
		}
	}
}
