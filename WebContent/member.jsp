<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Member</title>
</head>
<body>
<f:view>
<h1>${superController.currentMember.nickName}</h1>
<h2>Details</h2>
<div>Name: ${superController.currentMember.name}</div>
<div>Lastname: ${superController.currentMember.lastName}</div>
<div>Email: ${superController.currentMember.email}</div>
<div>
	<h:outputText value="Birthday: "/>
	<h:outputText value="#{superController.currentMember.birthDay}" >
    	<f:convertDateTime type="date" dateStyle="medium" locale="en"/>
	</h:outputText>
</div>
<div>
	<h:outputText value="Registration date: "/>
	<h:outputText value="#{superController.currentMember.registrationDate}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="en"/>
	</h:outputText>
</div><br/>
<h:form>
<div> <h:outputText value="My personal Activities:" rendered="#{superController.verifyActivity()}"></h:outputText> </div>
<ul>
<c:forEach var="activity" items="#{superController.currentMember.myActivities}">
	<li>
		<h:outputText value="Activity name: "/>
		<h:commandLink action="#{activityController.findActivity}" value="#{activity.name}">
			<f:setPropertyActionListener value="#{activity.id}" target="#{activityController.id}"/>
		</h:commandLink>
		<h:outputText value="(completed)" rendered="#{activity.getIsComplete()}"/>
		<h:commandButton action="#{activityController.setActivityCompletition}" value="complete"
			rendered="#{!activity.getIsComplete()}">
			<f:setPropertyActionListener value="#{activity.id}" target="#{activityController.id}"/>
		</h:commandButton>
	</li>
</c:forEach>
</ul>
<div> <h:outputText value="My Tasks:" rendered="#{superController.verifyTask()}"></h:outputText> </div>
<ul>
<c:forEach var="task" items="#{superController.currentMember.toDoTask}">
	<c:if test="${!task.getIsComplete()}">
	<li>
		<h:outputText value="Task name: "/>
		<h:commandLink action="#{taskController.findTask}" value="#{task.name}">
			<f:setPropertyActionListener value="#{task.id}" target="#{taskController.id}"/>
		</h:commandLink>
	</li>
	</c:if>
</c:forEach>
</ul>
<div>
<h:outputLink value="newIndividualActivity.jsp">
    <h:outputText value="Create new individual activity" />
</h:outputLink>
</div>
<div>
<h:outputLink value="newGroupActivity.jsp">
    <h:outputText value="Create new group activity" />
</h:outputLink>
</div>
<div>
<h:outputLink value="index.jsp">
    <h:outputText value="Log out" />
</h:outputLink>
</div>
</h:form>
</f:view>
</body>
</html>