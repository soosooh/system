<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: soohee
  Date: 4/12/24
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/resources/css/doneregisterStyle.css'/>">
    <title>Title</title>
</head>
<body>
<h1>수강신청이 완료되었습니다.</h1>
<div class="links-container">
    <a href="${pageContext.request.contextPath}/result">수강신청내역</a>
    <a href="${pageContext.request.contextPath}/home">홈화면</a>
</div></body>
</html>
