<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Product</title>
</head>
<body>
<f:view>
<h:form>
    <div>Name: <h:inputText value="#{activityController.name}" 
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="name"/> <h:message for="name" />
	</div>
	<div>Description: <h:inputTextarea value="#{activityController.description}" 
    				required="false" 
    				cols="20" 
    				rows="5" /> 
    </div>
    <div>Expires: <h:inputText value="#{activityController.expiration}" 
                     required="false"/>
	</div>   
	<div>
		<h:commandButton value="Submit"  action="#{activityController.createIndividualActivity}"/>
	</div>
	<!-- 
	<h:commandLink action="#{productController.listProducts}"
						value="List all Products" /> -->
</h:form>
</f:view>
</body>
</html>