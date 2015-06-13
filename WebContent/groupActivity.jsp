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
<link rel="stylesheet" href="CSS/signin.css" type="text/css">
<title>Group Activity</title>
</head>
<body>
<f:view>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
         <h:outputText value="#{superController.currentMember.nickName}
         > #{superController.currentActivity.name}" styleClass="navbar-brand"/>
		<h:outputLink value="editActivity.jsp" rendered="#{superController.veryActivityCompletition()}"
		styleClass="navbar-brand">
			<span class="glyphicon glyphicon-edit"></span>
		</h:outputLink>
         </div>
         <h:form styleClass="form-inline">
         <h:commandLink action="#{activityController.removeActivity}"
         styleClass="navbar-brand">
			<f:setPropertyActionListener value="#{superController.currentActivity.id}" target="#{activityController.id}"/>
			<span class="glyphicon glyphicon-trash"></span>
		</h:commandLink>
		</h:form>
		<h:form styleClass="form-inline" rendered="#{superController.veryActivityCompletition()}">
         	<h:commandLink action="#{superController.addingMember}"
         	styleClass="navbar-brand">
			<span class="glyphicon glyphicon-plus"></span>
			Member
			</h:commandLink>
			</h:form>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
			<li>
			<h:outputLink value="newIndividualTask.jsp" rendered="#{superController.veryActivityCompletition()}"
			styleClass="navbar-brand">
			<h:outputText value="Create new individual task" />
			</h:outputLink>
			</li>
			<li>
			<h:outputLink value="newTargetTask.jsp" rendered="#{superController.veryActivityCompletition()}"
			styleClass="navbar-brand">
			<h:outputText value="Create new target task" />
			</h:outputLink>
			</li>
            <li><h:outputLink value="member.jsp"
            	styleClass="navbar-brand">
    			<h:outputText value="Back to your personal page" />
				</h:outputLink>
			</li>
          </ul>
        </div>
      </div>
</nav>

<c:if test="${superController.adding}">
	<div class="container">
	<h:form styleClass="form-signin">
	<h2 class="form-signin-heading">Select members to add</h2>
	<div>
		<h:selectManyListbox value="#{superController.entryId}"
		styleClass="form-control">
			<f:selectItems value="#{superController.allMember}" var="member"
			itemLabel="#{member.nickName}" itemValue="#{member.id}"/>
		</h:selectManyListbox>
	</div><br/>
	<div>
		<h:commandButton value="Submit"  action="#{memberController.addMembersToActivity}"
		styleClass="btn btn-lg btn-primary btn-block"/>
	</div>
	</h:form>
	</div>
</c:if>

<div class="container">
<div class="jumbotron">
      <div>
      <h2>This is a group Activity</h2>
      <h3>Activity details:</h3>
        <p>Name: ${superController.currentActivity.name}</p>
		<p>Description: ${superController.currentActivity.description}</p>
		<p>
		<h:outputText value="Expiration: "/>
		<h:outputText value="#{superController.currentActivity.expiration}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="it"/>
		</h:outputText>
		</p>
		<p>
		<h:outputText value="Creation date: "/>
		<h:outputText value="#{superController.currentActivity.creationDate}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="it"/>
		</h:outputText>
		</p>
		<c:if test="${superController.currentActivity.getIsComplete()}">
		<p>
		<h:outputText value="Completion date: "/>
		<h:outputText value="#{superController.currentActivity.completionDate}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="it"/>
		</h:outputText>
		</p>
		</c:if>
      </div>
    </div>
    
    <h:form>
    <div>
    <h1> <h:outputText value="Tasks: " rendered="#{superController.verifyBothInTask()}"></h:outputText> </h1>
	<c:if test="${superController.verifyUnDoneTaskInActivity()}">
	<table class="table table-hover">
	<caption>
	<strong><h:outputText value="Undone Tasks" rendered="#{superController.verifyUnDoneTaskInActivity()}"/></strong>
	<span class="badge">${superController.unDoneTask.size()}</span>
	</caption>
    <thead>
      <tr>
        <th>Task name</th>
        <th>Assign to</th>
        <th>Complete button</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="task" items="#{superController.unDoneTask}">
      <tr>
      <td>
		<h:commandLink action="#{taskController.findTask}" value="#{task.name}">
			<f:setPropertyActionListener value="#{task.id}" target="#{taskController.id}"/>
		</h:commandLink>
	 </td>
	 <td>
		<h:commandLink action="#{memberController.findMember}" value="#{task.pushTo.nickName}">
			<f:setPropertyActionListener value="#{task.pushTo.id}" target="#{memberController.id}"/>
		</h:commandLink>
	</td>
	<td>
		<h:commandLink action="#{taskController.setTaskCompletition}">
			<f:setPropertyActionListener value="#{task.id}" target="#{taskController.targetId}"/>
			<span class="glyphicon glyphicon-ok-circle"></span>
		</h:commandLink>
	</td>
	</tr>
	</c:forEach>
    </tbody>
  </table>
  </c:if>
  <c:if test="${superController.verifyDoneTaskInActivity()}">
	<table class="table table-hover">
	<caption>
	<strong><h:outputText value="Done Tasks" rendered="#{superController.verifyDoneTaskInActivity()}"/></strong>
	<span class="badge">${superController.doneTask.size()}</span>
	</caption>
    <thead>
      <tr>
        <th>Task name</th>
        <th>Assign to</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="task" items="#{superController.doneTask}">
      <tr>
      <td>
		<h:commandLink action="#{taskController.findTask}" value="#{task.name}">
			<f:setPropertyActionListener value="#{task.id}" target="#{taskController.id}"/>
		</h:commandLink>
	 </td>
	 <td>
		<h:commandLink action="#{memberController.findMember}" value="#{task.pushTo.nickName}">
			<f:setPropertyActionListener value="#{task.pushTo.id}" target="#{memberController.id}"/>
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