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
<title>Task</title>
</head>
<body>
<f:view>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
         <h:outputText value="#{superController.currentMember.nickName}
         > #{superController.currentActivity.name} >
          #{superController.currentTask.name}" styleClass="navbar-brand"/>
		<h:outputLink value="editTask.jsp" rendered="#{superController.veryActivityCompletition()}"
		styleClass="navbar-brand">
			<span class="glyphicon glyphicon-edit"></span>
		</h:outputLink>
         </div>
         <h:form styleClass="form-inline">
         <h:commandLink action="#{taskController.removeTask}"
         styleClass="navbar-brand">
			<f:setPropertyActionListener value="#{superController.currentTask.id}" target="#{taskController.id}"/>
			<span class="glyphicon glyphicon-trash"></span>
		</h:commandLink>
		</h:form>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><h:outputLink value="member.jsp"
            	styleClass="navbar-brand">
    			<h:outputText value="Back to your personal page" />
				</h:outputLink>
			</li>
			<li>
			<h:form>
			<h:commandLink action="#{taskController.getCreator}" value="Creator activity"
			styleClass="navbar-brand">
			<f:param name="id" value="#{task.id}" />
			</h:commandLink>
			</h:form>
			</li>
          </ul>
        </div>
      </div>
</nav>
<div class="container">
<div class="jumbotron">
      <div class="container">
      <h2>Task</h2>
      <h3>Task details:</h3>
        <p>Name: ${superController.currentTask.name}</p>
		<p>Description: ${superController.currentActivity.description}</p>
		<p>
		<h:outputText value="Expiration: "/>
		<h:outputText value="#{superController.currentTask.expiration}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="it"/>
		</h:outputText>
		</p>
		<p>
		<h:outputText value="Creation date: "/>
		<h:outputText value="#{superController.currentTask.creationDate}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="it"/>
		</h:outputText>
		</p>
		<c:if test="${superController.currentTask.getIsComplete()}">
		<p>
		<h:outputText value="Completion date: "/>
		<h:outputText value="#{superController.currentTask.completionDate}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="it"/>
		</h:outputText>
		</p>
		</c:if>
      </div>
    </div>
</div>
</f:view>
</body>
</html>