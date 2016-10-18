<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>出错啦</title>
	<link rel="stylesheet" href="${contextPath}/resources/css/main.css" />
</head>
<body>
<%-- <p>exceptionClassName: ${exceptionModel.exceptionClassName}</p>
<br />
<p>stacktrace: ${exceptionModel.stacktrace}</p>
<br />
<p>message: ${exceptionModel.message}</p>
<br />
<p>cause: ${exceptionModel.cause}</p> --%>
<p>响应码: <%=response.getStatus()%></p>
<p>错误信息: ${exceptionModel.message}</p>
<br /><br /><br />
<center>
<a href="${contextPath}/">返回首页</a>
</center>
</body>
</html>
