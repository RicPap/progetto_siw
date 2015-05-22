<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Members</title>
</head>
<body>
<f:view>
<h1>Members</h1>
<h:form>
<table>
	<tr>
		<th>Subscribed members</th>
	</tr>
	<c:forEach var="member" items="#{memberController.members}">
		<tr><td>${member.name} ${member.lastName} ${member.email}</td></tr>
	</c:forEach>
</table>
</h:form>

</f:view>
</body>
</html>