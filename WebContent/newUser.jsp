<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New User</title>
</head>
<body>
<f:view>
<h:form>
    <div>Name: <h:inputText value="#{userController.name}" 
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="name"/> <h:message for="name" />
	</div>
	<div>Lastname: <h:inputText value="#{userController.lastName}" 
    				required="true" 
    				requiredMessage="Name is mandatory"
                    id="lastname"/> <h:message for="lastname" /> 
    </div>
    <div>Email: <h:inputText value="#{userController.email}" 
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="email"/> <h:message for="email" />
	</div>
	<div>Password: <h:inputText value="#{userController.password}" 
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="psw"/> <h:message for="psw" />
	</div>
	<div>
		<h:commandButton value="Submit"  action="#{userController.createUser}"/>
	</div>
</h:form>
</f:view>
</body>
</html>