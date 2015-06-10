<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Add members to your group task</title>
</head>
<body>
<f:view>
<h:form>
	<div>
		<h:selectManyListbox value="#{superController.entryId}">
			<f:selectItems value="#{superController.allMember}" var="member"
			itemLabel="#{member.nickName}" itemValue="#{member.id}"/>
		</h:selectManyListbox>
	</div>
	<div>
		<h:commandButton value="Submit"  action="#{memberController.addMembersToActivity}" />
	</div>
</h:form>
</f:view>
</body>
</html>