<%--
  Created by IntelliJ IDEA.
  User: soohee
  Date: 4/12/24
  Time: 5:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학년별 이수 학점 조회</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/tableStyle.css'/>">
</head>
</head>
<body>
<h1>학년별 이수 학점 조회</h1>
<c:if test="${not empty groupedCoursesInfo}">
    <table border="1">
        <tr>
            <th>년도</th>
            <th>학기</th>
            <th>취득 학점</th>
            <th>상세보기</th>
        </tr>
        <c:forEach items="${groupedCoursesInfo}" var="entry">
            <c:set var="year" value="${fn:split(entry.key, '-')[0]}" />
            <c:set var="semester" value="${fn:split(entry.key, '-')[1]}" />
            <tr>
                <td>${year}</td>
                <td>${semester}</td>
                <td>${entry.value.totalCredits}</td>
                <td><a href="${pageContext.request.contextPath}/coursedetails?year=${year}&semester=${semester}">상세보기</a></td>
            </tr>
        </c:forEach>
        <tr class="total-row">
            <td colspan="2">총계</td>
            <td>${totalCredits}</td>
            <td></td>
        </tr>
    </table>
</c:if>
<c:if test="${empty groupedCoursesInfo}">
    <p>조회된 결과가 없습니다.</p>
</c:if>
</body>
</html>
