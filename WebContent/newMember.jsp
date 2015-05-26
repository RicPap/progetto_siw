<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Member</title>
</head>
<body>
<f:view>
<h:form>
    <div>Name: <h:inputText value="#{memberController.name}" 
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="name"/> <h:message for="name" />
	</div>
	<div>Lastname: <h:inputText value="#{memberController.lastName}" 
    				required="true" 
    				requiredMessage="Lastname is mandatory"
                    id="lastname"/> <h:message for="lastname" /> 
    </div>
     <div>Birthday: <h:inputText value="#{memberController.birthDay}">
                    <f:convertDateTime pattern="yyyy-MM-dd" type="date" dateStyle="long"/>
                    </h:inputText>
    </div>
    <div>Nickname: <h:inputText value="#{memberController.nickName}" 
    				required="true" 
    				requiredMessage="Nickname is mandatory"
                    id="nickname"/> <h:message for="nickname" /> 
    </div>
    <div>Email: <h:inputText value="#{memberController.email}" 
                     required="true"
                     requiredMessage="Email is mandatory"
                     id="email"/> <h:message for="email" />
	</div>
	<div>Password: <h:inputText value="#{memberController.password}" 
                     required="true"
                     requiredMessage="Password is mandatory"
                     id="psw"/> <h:message for="psw" />
	</div>
	<div>
		<h:commandButton value="Submit"  action="#{memberController.createMember}"/>
	</div>
</h:form>
</f:view>
</body>
</html>