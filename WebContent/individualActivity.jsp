<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>My individual activity</title>
</head>
<body>
<f:view>
<h1>${superController.currentActivity.name}</h1>
<h2>Details</h2>
<div>This is an individual Activity</div>
<div>Description: ${superController.currentActivity.description}</div>
<div>
	<h:outputText value="Expiration: "/>
	<h:outputText value="#{superController.currentActivity.expiration}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="en"/>
	</h:outputText>
</div>
<div>
	<h:outputText value="Creation date: "/>
	<h:outputText value="#{superController.currentActivity.creationDate}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="en"/>
	</h:outputText>
</div>
<h:form>
<div><br/>
<div> <h:outputText value="Tasks: " rendered="#{superController.verifyBothInTask()}"></h:outputText> </div>
<div><h:outputText value ="Undone tasks: " rendered="#{superController.verifyUnDoneTaskInActivity()}"/></div>
<ul>
<c:forEach var="task" items="#{superController.unDoneTask}">
	<li>
		<h:commandLink action="#{taskController.setTaskCompletition}" value="X">
			<f:setPropertyActionListener value="#{task.id}" target="#{taskController.targetId}"/>
		</h:commandLink>
		<h:outputText value="Task name: "/>
		<h:commandLink action="#{taskController.findTask}" value="#{task.name}">
			<f:setPropertyActionListener value="#{task.id}" target="#{taskController.id}"/>
		</h:commandLink>
		<h:outputText value="			Assign to: "/>
		<h:commandLink action="#{taskController.findTargetMember}" value="#{task.pushTo.nickName}">
			<f:setPropertyActionListener value="#{task.pushTo.id}" target="#{taskController.targetId}"/>
		</h:commandLink>
	</li>
</c:forEach>
</ul>
<div><h:outputText value ="Done tasks: " rendered="#{superController.verifyDoneTaskInActivity()}"/></div>
<ul>
<c:forEach var="task" items="#{superController.doneTask}">
	<li>
		<h:outputText value="Task name: "/>
		<h:commandLink action="#{taskController.findTask}" value="#{task.name}">
			<f:setPropertyActionListener value="#{task.id}" target="#{taskController.id}"/>
		</h:commandLink>
		<h:outputText value="			Assign to: "/>
		<h:commandLink action="#{taskController.findTargetMember}" value="#{task.pushTo.nickName}">
			<f:setPropertyActionListener value="#{task.pushTo.id}" target="#{taskController.targetId}"/>
		</h:commandLink>
	</li>
</c:forEach>
</ul>
</div>
</h:form>
<div>
<h:outputLink value="newIndividualTask.jsp" >
	<h:outputText value="Create new individual task" />
</h:outputLink>
</div>
<div>
	<h:form>
		<h:commandLink action="#{activityController.removeActivity}" value="Remove this activity" >
			<f:setPropertyActionListener value="#{superController.currentActivity.id}" target="#{activityController.id}"/>
		</h:commandLink>
	</h:form>
</div>
<div>
<h:outputLink value="member.jsp" >
	<h:outputText value="Back to yuor personal page" />
</h:outputLink>
</div>
</f:view>
</body>
</html>