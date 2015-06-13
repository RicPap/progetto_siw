<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="CSS/member.css" type="text/css">
<title>Member</title>
</head>
<body>
<f:view>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
         <h:outputText value="#{superController.currentMember.nickName}" styleClass="navbar-brand"/>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><h:outputLink value="newIndividualActivity.jsp"
            	styleClass="navbar-brand">
    			<h:outputText value="Create new individual activity" />
				</h:outputLink>
			</li>
			<li>
			<h:outputLink value="newGroupActivity.jsp"
			styleClass="navbar-brand">
    		<h:outputText value="Create new group activity" />
			</h:outputLink>
			</li>
            <li><h:outputLink value="index.jsp"
            styleClass="navbar-brand">
    			<h:outputText value="Log out" />
			</h:outputLink>
			</li>
          </ul>
        </div>
      </div>
</nav>
<div class="container">
	<div class="jumbotron">
      <div class="container">
      <h3>Personal details:</h3>
        <p>Name: ${superController.currentMember.name}</p>
		<p>Lastname: ${superController.currentMember.lastName}</p>
		<p>Email: ${superController.currentMember.email}</p>
		<p>
		<h:outputText value="Birthday: "/>
		<h:outputText value="#{superController.currentMember.birthDay}" >
    	<f:convertDateTime type="date" dateStyle="medium" locale="en"/>
		</h:outputText>
		</p>
		<p>
		<h:outputText value="Registration date: "/>
		<h:outputText value="#{superController.currentMember.registrationDate}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="it"/>
		</h:outputText>
		</p>
      </div>
    </div>
<h:form>
<div class="container">
<c:if test="${superController.verifyActivity()}">
<table class="table table-hover">
	<caption>
	<strong><h:outputText value="My personal Activities" rendered="#{superController.verifyActivity()}"/></strong>
	<span class="badge">${superController.currentMember.myActivities.size()}</span>
	</caption>
    <thead>
      <tr>
        <th>Activity name</th>
        <th>State</th>
        <th>Complete button</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="activity" items="#{superController.currentMember.myActivities}">
      <tr>
      <td>
		<h:commandLink action="#{activityController.findActivity}" value="#{activity.name}">
			<f:setPropertyActionListener value="#{activity.id}" target="#{activityController.id}"/>
		</h:commandLink>
	 </td>
	 <td>
		<h:outputText value="completed" rendered="#{activity.getIsComplete()}"/>
		<h:outputText value="to complete" rendered="#{!activity.getIsComplete()}"/>
	</td>
	<td>
		<h:commandLink action="#{activityController.setActivityCompletition}"
			rendered="#{!activity.getIsComplete()}">
			<span class="glyphicon glyphicon-ok-circle"></span>
			<f:setPropertyActionListener value="#{activity.id}" target="#{activityController.id}"/>
		</h:commandLink>
	</td>
	</tr>
	</c:forEach>
    </tbody>
  </table>
  </c:if>
 </div>

<div class="container">
<c:if test="${superController.verifyTask()}">
<table class="table table-hover">
	<caption>
	<strong><h:outputText value="My tasks:" rendered="#{superController.verifyTask()}"/></strong>
	<span class="badge">${superController.currentMember.toDoTask.size()}</span>
	</caption>
    <thead>
      <tr>
        <th>Task name</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="task" items="#{superController.currentMember.toDoTask}">
      <tr>
      <td>
		<h:commandLink action="#{taskController.findTask}" value="#{task.name}">
			<f:setPropertyActionListener value="#{task.id}" target="#{taskController.id}"/>
		</h:commandLink>
	 </td>
	</tr>
	</c:forEach>
    </tbody>
  </table>
  </c:if>
 </div>
</h:form>
</div>
</f:view>
</body>
</html>