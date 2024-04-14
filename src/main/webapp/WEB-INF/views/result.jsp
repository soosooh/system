<%--
  Created by IntelliJ IDEA.
  User: soohee
  Date: 4/12/24
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration List</title>
</head>
<body>
<h1>2024학년도 2학기 수강신청 조회</h1>
<link rel="stylesheet" href="<c:url value='/resources/css/tableStyle.css'/>">
<table border="1">
    <thead>
    <tr>
        <th>수강년도</th>
        <th>학기</th>
        <th>교과목명</th>
        <th>교과구분</th>
        <th>담당교수</th>
        <th>학점</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${courses}" var="registration">
        <tr>
            <c:choose>
                <c:when test="${registration.year == 2024 && registration.semester == 2}">
                    <td>${registration.year}</td>
                    <td>${registration.semester}</td>
                    <td>${registration.courseName}</td>
                    <td>${registration.courseType}</td>
                    <td>${registration.professor}</td>
                    <td>${registration.credit}</td>
                </c:when>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
