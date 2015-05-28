<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Task</title>
</head>
<body>
<f:view>
<h1>${taskController.task.name}</h1>
<h2>Details</h2>
<div>Name: ${taskController.task.name}</div>
<div>Description: ${taskController.task.description}</div>
<div>Expiration: ${taskController.task.expiration}</div>
<div>Creation date: ${taskController.task.creationDate}</div>
<div>RegistrationDate: ${memberController.member.registrationDate}</div>
<div>
	<h:commandLink action="#{taskController.getCreator}" value="#{task.getCreator.name}">
			<f:param name="id" value="#{task.id}" />
	</h:commandLink>
</div>
<a href='<c:url value="/faces/member.jsp" />'>Back to your personal page</a>

</f:view>
</body>
</html>