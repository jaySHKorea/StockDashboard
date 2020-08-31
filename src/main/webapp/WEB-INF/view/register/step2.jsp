<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="member.register" /></title>
</head>
<body>
	<h2><spring:message code="member.info"/></h2>
	<form:form action="step3" modelAttribute="registerRequest">
	<%--<form action = "step3" method="post"> --%>
	<p>
		<label><spring:message code="email"/>:<br>
		<form:input path = "email"/>
		<form:errors path = "email"/>
		<%--<input type = "text" name = "email" id = "email" value = "${registerRequest.email}">--%>
		</label>
	</p>
	<p>
		<label><spring:message code="name"/>:<br>
		<form:input path = "name"/>
		<form:errors path = "name"/>
		<%--<input type = "text" name = "name" id = "name" value = "${registerRequest.name}"> --%>
		</label>
	</p>
	<p>
		<label><spring:message code="password" />:<br>
		<form:password path = "password"/>
		<form:errors path = "password"/>
		<%--<input type = "password" name = "password" id = "password">--%>
		</label>
	</p>
	<p>
		<label><spring:message code="password.confirm" />:<br>
		<form:password path = "confirmPassword"/>
		<%--<input type = "password" name = "confirmPasswrod" id = "confirmPassword">--%>
		</label>
	</p>
	<input type = "submit" value = "<spring:message code="register.btn"/>"/>
	</form:form>
	<%--</form> --%>
</body>
</html>