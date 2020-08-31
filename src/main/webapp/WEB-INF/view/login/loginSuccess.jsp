<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>
    <p>
        <spring:message code="login.done" />
    </p>
    <p>
        <a href="<c:url value='/main'/>">
            [<spring:message code="go.main" />]
        </a>
        <a href="<c:url value='/dashboard/dashboard'/>">
        	[<spring:message code="go.dashboard"/>]
        </a>
    </p>
</body>
</html>
© 2020 GitHub, Inc.