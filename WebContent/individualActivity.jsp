<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Activity</title>
</head>
<body>
<f:view>
<h1>${activityController.activity.name}</h1>
<h2>Details</h2>
<div>Name: ${activityController.task.name}</div>
<div>Description: ${activityController.task.description}</div>
<div>Expiration: ${activityController.task.expiration}</div>
<div>Creation date: ${activityController.task.creationDate}</div>
<div>RegistrationDate: ${activityController.member.registrationDate}</div>
<div>
	<h:commandLink action="#{taskController.getCreator}" value="#{activity.getCreator.name}">
			<f:param name="id" value="#{task.id}" />
	</h:commandLink>
</div>
<a href='<c:url value="/faces/member.jsp" />'>Back to your personal page</a>
<a href='<c:url value="/faces/task.jsp" />'>Go to your tasks page</a>

</f:view>
</body>
</html>