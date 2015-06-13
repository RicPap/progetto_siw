<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="CSS/signin.css" type="text/css">
<title>New Member</title>
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
<h2 class="form-signin-heading">Create new member</h2>
    <div>Name: <h:inputText value="#{memberController.name}"
    				 styleClass="form-control"
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="name"/> <h:message for="name" styleClass="alert-danger"/>
	</div>
	<div>Lastname: <h:inputText value="#{memberController.lastName}"
					styleClass="form-control"
    				required="true" 
    				requiredMessage="Lastname is mandatory"
                    id="lastname"/> <h:message for="lastname" styleClass="alert-danger"/> 
    </div>
     <div>Birthday: (correct format is dd-mm-yyyy)<h:inputText value="#{memberController.birthDay}"
     				styleClass="form-control">
                    <f:convertDateTime pattern="dd-MM-yyyy" type="date" dateStyle="long"/>
                    </h:inputText>
    </div>
    <div>Nickname: <h:inputText value="#{memberController.nickName}"
    				styleClass="form-control"
    				required="true"
    				requiredMessage="Nickname is mandatory"
                    id="nickname"/> <h:message for="nickname" styleClass="alert-danger"/> 
    </div>
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
                     id="psw"/> <h:message for="psw" styleClass="alert-danger"/>
	</div>
	<div>
		<h:commandButton value="Submit"  action="#{memberController.createMember}"
		styleClass="btn btn-lg btn-primary btn-block"/>
	</div>
</h:form>
</div>
</f:view>
</body>
</html>