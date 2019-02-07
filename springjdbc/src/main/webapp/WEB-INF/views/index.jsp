<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>test</title>
</head>
<body>
<a class="btn pull-right btn-default"  href="/joinform">가입</a>
<h1>test</h1>
<img src="/github.gif">
<br><br data-tomark-pass>

<c:forEach items="${users}" var="user">
    name : ${user.nickname}, email : ${user.email}<br data-tomark-pass>
</c:forEach>
</body>
</html>