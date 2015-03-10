<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head></head>

<body>
	<h1>This is the body of the sample view</h1>
	
	<form:form commandName="Bar">
	<form:button value="${name}" ></form:button>
	
	
	</form:form>

	<security:authorize access="hasRole('ROLE_USER')">
		This text is only visible to a user
		<br/>
		Your accounts:
		
		
		
	</security:authorize>
	<security:authorize access="hasRole('ROLE_ADMIN')">
		This text is only visible to an admin
		<br/>
	</security:authorize>

	<a href="<c:url value="/logout" />">Logout</a>
	
</body>
</html>