<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Member</title>
</head>
<body>
<f:view>
<h1>${memberController.member.nickName}</h1>
<h2>Details</h2>
<div>Name: ${memberController.member.name}</div>
<div>Lastname: ${memberController.member.lastName}</div>
<div>Email: ${memberController.member.email}</div>
<div>Birthday: ${memberController.member.birthDay}</div>
<div>RegistrationDate: ${memberController.member.registrationDate}</div>
</f:view>
</body>
</html>