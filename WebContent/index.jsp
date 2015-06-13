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
<link rel="stylesheet" href="CSS/index.css" type="text/css">
<title>A warm welcome in ActivityTask</title>
</head>
<body>
	<f:view>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
         <h:outputText value="ActivityTask" styleClass="navbar-brand"/>
        </div>
      </div>
	</nav>
	<div class="container">
	<div class="jumbotron">
      <div class="container">
      <h3>Project description:</h3>
        <p>Si vuole realizzare un sistema informativo su web per la gestione di attivita' con annessi compiti.</p>
      </div>
    </div>
      
      <div class="masthead">
        <nav>
          <ul class="nav nav-justified">
          	<li>
            <h:outputLink value="newMember.jsp">
    			<h:outputText value="Create a new user" />
			</h:outputLink>
			</li>
            <li>
            <h:outputLink value="logIn.jsp">
    			<h:outputText value="Sign in" />
			</h:outputLink>
			</li>
          </ul>
        </nav>
      </div>
     </div>
	</f:view>
</body>
</html>

