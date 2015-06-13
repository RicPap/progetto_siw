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
<title>Edit Task</title>
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
            <li><h:outputLink value="member.jsp"
            	styleClass="navbar-brand">
    			<h:outputText value="Back to your personal page" />
			</h:outputLink>
			</li>
          </ul>
        </div>
      </div>
</nav>
<div class="container">
<h:form styleClass="form-signin">
<h2 class="form-signin-heading">Edit task</h2>
    <div>Name: <h:inputText value="#{superController.currentTask.name}" 
                     required="true"
                     styleClass="form-control"
                     requiredMessage="Name is mandatory"
                     id="name"/> <h:message for="name" styleClass="alert-danger"/>
	</div>
	<div>Description: <h:inputTextarea value="#{superController.currentTask.description}"
					styleClass="form-control" 
    				required="false" 
    				cols="20" 
    				rows="5" /> 
    </div>
    <div>Expires: Expires: (correct format is dd-mm-yyyy HH.mm)<h:inputText value="#{superController.currentTask.expiration}"
    				styleClass="form-control"
                    required="false">
                    <f:convertDateTime pattern="dd-MM-yyyy HH.mm" type="date" dateStyle="long" locale="it"/>
                  </h:inputText>
	</div><br/>
	<div>
		<h:commandButton value="Submit"  action="#{taskController.updateTask}" 
		styleClass="btn btn-lg btn-primary btn-block"/>
	</div>
</h:form>
</div>
</f:view>
</body>
</html>