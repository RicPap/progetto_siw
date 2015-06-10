<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Edit Activity</title>
</head>
<body>
<f:view>
<h:form>
    <div>Name: <h:inputText value="#{superController.currentActivity.name}" 
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="name"/> <h:message for="name" />
	</div>
	<div>Description: <h:inputTextarea value="#{superController.currentActivity.description}" 
    				required="false" 
    				cols="20" 
    				rows="5" /> 
    </div>
    <div>Expires: <h:inputText value="#{superController.currentActivity.expiration}"
                     required="false">
                    <f:convertDateTime pattern="dd-MM-yyyy hh.mm" type="date" dateStyle="long"/>
                  </h:inputText>
	</div>   
	<div>
		<h:commandButton value="Submit"  action="#{activityController.upDateActivity}" />
	</div>
</h:form>
</f:view>
</body>
</html>