<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	��������${applicationScope.counter }
	<br/>
	cookie:${cookie.username.value }
	<br/>
	${sessionScope.username}
	<br/>
	${sessionScope.tip }
	<br/>
	<s:text name="succTip">
		<s:param>${sessionScope.username}</s:param>
	</s:text><br/>
	<s:property value="tip"/>
</body>
</html>