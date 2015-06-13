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
          <h:form>
            <li><h:commandLink action="#{activityController.backIn}"
            styleClass="navbar-brand">
    			<h:outputText value="Back to activity page" />
			</h:commandLink>
			</li>
		</h:form>
          </ul>
        </div>
      </div>
</nav>
<div class="container">
	<div class="jumbotron">
      <div class="container">
      <h3>Personal details:</h3>
        <p>Name: ${memberController.member.name}</p>
		<p>Lastname: ${memberController.member.lastName}</p>
		<p>Email: ${memberController.member.email}</p>
		<p>
		<h:outputText value="Birthday: "/>
		<h:outputText value="#{memberController.member.birthDay}" >
    	<f:convertDateTime type="date" dateStyle="medium" locale="en"/>
		</h:outputText>
		</p>
		<p>
		<h:outputText value="Registration date: "/>
		<h:outputText value="#{memberController.member.registrationDate}" >
    	<f:convertDateTime type="both" dateStyle="medium" locale="en"/>
		</h:outputText>
		</p>
      </div>
    </div>
</div>
</f:view>
</body>
</html>