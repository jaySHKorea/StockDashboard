<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="dashboard.title" /></title>
</head>
<body>
	<a href="<c:url value="/main" />">[메인으로 돌아가기]</a>
    <form:form modelAttribute="cmd">
    <p>
    	<label>종목이름: <form:input path="ID" /></label>
    	<form:errors path="ID"/>
        <label>from: <form:input path="from" /></label>
        <form:errors path="from" />
        ~
        <label>to:<form:input path="to" /></label>
        <form:errors path="to" />
        <input type="submit" value="조회">
    </p>
    </form:form>
    
    	<p>현재 상태 : ${identify}</p>
    
    <c:if test="${! empty map}">
    <table>
        <tr>
            <th><spring:message code="stock.id"/></th><th><spring:message code="stock.id"/></th>
            <th><spring:message code="stock.name"/></th><th><spring:message code="stock.name"/></th>
        </tr>
        <c:forEach var="mem" items="${map}">
        
        <tr>
            <td>${mem.id}</td>
            <td>${mem.name}</td>
            <td>${mem.present}</td>
			<td>${mem.diffprev}</td>
			<td>${mem.prevClose}</td>
			<td>${mem.volume}</td>
			<td>${mem.volumeMoney}</td>
            <td>${mem.open}</td>
            <td>${mem.high}</td>
			<td>${mem.low}</td>
			<td>${mem.high52}</td>
			<td>${mem.low52}</td>
			<td>${mem.ulprice}</td>
            <td>${mem.llprice}</td>
            <td>${mem.per}</td>
			<td>${mem.totalcnt}</td>
			<td>${mem.faceValue}</td>
        </tr>
        </c:forEach>
    </table>
    </c:if>
</body>
</html>
