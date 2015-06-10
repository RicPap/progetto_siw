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
<h1>${superController.currentTask.name}</h1>
<h2>Details</h2>
<div>Name: ${superController.currentTask.name}</div>
<div>Description: ${superController.currentTask.description}</div>
<div>
	<h:outputText value="Expiration: "/>
	<h:outputText value="#{superController.currentTask.expiration}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="en"/>
	</h:outputText>
</div>
<div>
	<h:outputText value="CreationDate: "/>
	<h:outputText value="#{superController.currentTask.creationDate}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="en"/>
	</h:outputText>
</div><br/>
<div>
<h:form>
	<h:outputText value="This task belongs to this activity: "/>
	<h:commandLink action="#{taskController.getCreator}" value="#{superController.currentTask.activityCreator.name}">
			<f:param name="id" value="#{task.id}" />
	</h:commandLink>
</h:form>
</div>
<div>
<div>
	<h:form>
		<h:commandLink action="#{taskController.removeTask}" value="Remove this task" >
			<f:setPropertyActionListener value="#{superController.currentTask.id}" target="#{taskController.id}"/>
		</h:commandLink>
	</h:form>
</div>
<h:outputLink value="task.jsp" rendered="#{superController.veryTaskCompletition()}">
	<h:outputText value="Edit task" />
</h:outputLink>
<h:outputLink value="member.jsp" >
	<h:outputText value="Back to your personal page" />
</h:outputLink>
</div>
</f:view>
</body>
</html>