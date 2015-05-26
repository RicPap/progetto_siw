<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Log in member</title>
</head>
<body>
<f:view>
<h:form>
    <div>Email: <h:inputText value="#{memberController.email}"/>
	</div>
	<div>Password: <h:inputSecret value="#{memberController.password}"/>
	<div><h:outputText value="Email or Password incorrect" rendered="#{!memberController.passCorrect}"></h:outputText>
	</div>
		<h:commandButton value="Submit"  action="#{memberController.logIn}"/>
	</div>
</h:form>
</f:view>
</body>
</html>