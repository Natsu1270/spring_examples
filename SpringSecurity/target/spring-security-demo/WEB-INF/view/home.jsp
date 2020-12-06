<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Spring Security DEMO</title>
</head>

<body>
<h2>HOME</h2>
<div class="auth">
    User: <security:authentication property="principal.username"/>
    <br>
    Roles: <security:authentication property="principal.authorities"/>
</div>
<div class="link">
    <security:authorize access="hasRole('ADMIN')">
        <p>
            <a href="${pageContext.request.contextPath}/admin">ADMIN PAGE</a>
        </p>
    </security:authorize>
</div>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>