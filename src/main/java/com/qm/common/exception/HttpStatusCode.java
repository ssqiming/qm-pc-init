package com.qm.common.exception;

/**
 * 定义http错误响应码
 * 创建日期：2014年7月28日
 * @author niezhegang
 */
public enum HttpStatusCode {
	CLIENT_OK_REQUEST(200,"ok!"),
	//http客户端错误响应码(400开头)
	CLIENT_BAD_REQUEST(400,"bad request!"),
	CLIENT_UNAUTHORIZED(401,"need to authenticate!"),
	CLIENT_PAYMENT_REQUIRED(402,"reserved for future use!"),
	CLIENT_PAYMENT_FORBIDDEN(403,"server refuse to execute!"),
	CLIENT_NOT_FOUND(404,"the requseted resource is not found!"),
	CLIENT_METHOD_NOT_ALLOWED(405,"the method specified in the Request-Line is not allowed!"),
	CLIENT_NOT_ACCEPTABLE(406,"server cannot generate the content that client is acceptable!"),
	CLIENT_PROXY_AUTHENTICATION_REQUIRED(407,"the client must first authenticate itself with the proxy!"),
	CLIENT_REQUEST_TIMEOUT(408,"request timeout!"),
	CLIENT_CONFLICT(409,"the request could not be completed due to a conflict with the current state of the resource!"),
	CLIENT_GONE(410,"the requseted resource is no longer available at the server!"),
	CLIENT_LENGTH_REQUIRED(411,"the request cannot be handled without a defined Content-Length!"),
	CLIENT_PRECONDITION_FAILED(412,"the precondition given in one or more of the request-header fields evaluated to false when it was tested on the server !"),
	CLIENT_REQUEST_ENTITY_TOO_LARGE(413,"the request entity is larger than the server is able to process!"),
	CLIENT_REQUEST_URI_TOO_LONG(414,"the Request-URI is longer than the server is willing to interpret!"),
	CLIENT_UNSUPPORTED_MEDIA_TYPE(415,"the entity of the request is in a format not supported by the requested resource for the requested method!"),
	CLIENT_REQUESTED_RANGE_NOT_SATISFIABLE(416,"the server cannot serve the requested byte range!"),
	CLIENT_EXPECTATION_FAILED(417,"the server could not meet the expectation given in the Expect request header!"),
	//http服务端错误响应码
	SERVER_INTERNAL_SERVER_ERROR(500,"an error inside the HTTP server which prevented it from fulfilling the request!"),
	SERVER_NOT_IMPLEMENTED(501,"the HTTP server does not support the functionality needed to fulfill the request!"),
	SERVER_BAD_GATEWAY(502,"the HTTP server received an invalid response from a server it consulted when acting as a proxy or gateway!"),
	SERVER_SERVICE_UNAVAILABLE(503,"the HTTP server is temporarily overloaded, and unable to handle the request!"),
	SERVER_GATEWAY_TIMEOUT(504,"the server did not receive a timely response from the upstream server while acting as a gateway or proxy!"),
	SERVER_HTTP_VERSION_NOT_SUPPORTED(505,"the server does not support  or refuses to support the HTTP protocol version that was used in the request message!"),
	
	//自定义http响应码
	CLIENT_SESSION_OVERDUE(480,"the session is overdue");
	
	/**默认客户端错误响应码*/
	public static final HttpStatusCode DefaultClientErrorCode = CLIENT_OK_REQUEST;
	/**默认服务端错误响应码*/
	public static final HttpStatusCode DefaultServerErrorCode = SERVER_SERVICE_UNAVAILABLE;
	
	private final int statusCode;
	
	private final String description;
	
	HttpStatusCode(int statusCode,String description){
		this.statusCode = statusCode;
		this.description = description;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return statusCode+"："+description;
	}
	
}
