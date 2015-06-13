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
<title>Log in member</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="CSS/signin.css" type="text/css">
</head>
<body>
<f:view>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
         <h:outputText value="ActivityTask" styleClass="navbar-brand"/>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><h:outputLink value="newMember.jsp"
            	styleClass="navbar-brand">
    			<h:outputText value="Register a new user" />
			</h:outputLink></li>
            <li><h:outputLink value="index.jsp"
            	styleClass="navbar-brand">
    			<h:outputText value="Back to the homepage" />
			</h:outputLink></li>
          </ul>
        </div>
      </div>
</nav>
<div class="container">
<h:form styleClass="form-signin">
<h2 class="form-signin-heading">Please sign in</h2>
    <div>Email: <h:inputText value="#{memberController.email}"
    				styleClass="form-control"
    				required="true"
                    requiredMessage="Email is mandatory"
                    id="email"/> <h:message for="email" styleClass="alert-danger"/>
	</div>
	<div>Password: <h:inputSecret value="#{memberController.password}"
						styleClass="form-control"
						required="true"
                     	requiredMessage="Password is mandatory"
                     	id="pwd"/>
                    <h:message for="pwd" styleClass="alert-danger"/>
    </div>
    <div>
    <h:panelGroup layout="block" rendered="#{!memberController.passCorrect}" styleClass="alert alert-danger">
    <h:outputText value="Email or Password incorrect" rendered="#{!memberController.passCorrect}"/>
	</h:panelGroup>
	</div>
		<h:commandButton value="Submit" action="#{memberController.logIn}"
		styleClass="btn btn-lg btn-primary btn-block">
		</h:commandButton>
</h:form>
</div>
</f:view>
</body>
</html>