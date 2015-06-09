<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>New Task</title>
</head>
<body>
<f:view>
<h:form>
    <div>Name: <h:inputText value="#{taskController.name}" 
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="name"/> <h:message for="name" />
	</div>
	<div>Description: <h:inputTextarea value="#{taskController.description}" 
    				required="false" 
    				cols="20" 
    				rows="5" /> 
    </div>
    <div>Expires: <h:inputText value="#{taskController.expiration}"
                     required="false">
                    <f:convertDateTime pattern="dd-MM-yyyy hh.mm" type="date" dateStyle="long"/>
                  </h:inputText>
	</div>
	<div>
		<h:commandButton value="Submit"  action="#{taskController.createIndividualTask}" />
	</div>
</h:form>
</f:view>
</body>
</html>