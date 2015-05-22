<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Progetto SIW</title>
</head>
<body>
	<f:view>
		<h1>Progetto SIW</h1>
		<ul>
			<li><a href='<c:url value="/faces/newIndividualActivity.jsp" />'>Create a new Individual Activity</a></li>
			<li><a href='<c:url value="/faces/newGroupActivity.jsp" />'>Create a new Group Activity</a></li>
			<li><a href='<c:url value="/faces/newMember.jsp" />'>Create a new user</a></li>
			<li><h:form>
					<h:commandLink action="#{memberController.listMembers}"
						value="List all Users" />
				</h:form></li>
		</ul>
	</f:view>
</body>
</html>

