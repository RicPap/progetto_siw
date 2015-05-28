<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>A warm welcome in ActivityTask</title>
</head>
<body>
	<f:view>
		<h1>ActivityTask</h1>
			<div>If you still don't have an account, register now!
			<a href='<c:url value="/faces/newMember.jsp" />'>Create a new user</a>
			</div>
			<div>If you have an account, please sign in.
			<a href='<c:url value="/faces/logIn.jsp" />'>Sign in</a>
			</div>
	</f:view>
</body>
</html>

