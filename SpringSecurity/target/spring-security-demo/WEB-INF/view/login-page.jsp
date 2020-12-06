<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: natsu
  Date: 22/11/2020
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Login</h1>
        </div>
        <div class="form">
            <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
                <div class="error">
                    <c:if test="${param.error != null}">
                        <b style="color: red">Invalid username or password!</b>
                    </c:if>
                </div>
                <div class="error">
                    <c:if test="${param.logout != null}">
                        <b style="color: red">Logout! Consider login again ?</b>
                    </c:if>
                </div>

                <label for="username">Username: </label>
                <input type="text" id="username" name="username" /> <br>
                <label for="password">Password: </label>
                <input type="password" id="password" name="password" /> <br>
                <input type="submit" value="Login">
            </form:form>
        </div>
    </div>
</body>
</html>
