<%--
  Created by IntelliJ IDEA.
  User: soohee
  Date: 4/12/24
  Time: 6:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>학년별 이수 학점 조회 상세보기</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/tableStyle.css'/>">
</head>
<body>

<c:choose>
  <c:when test="${not empty courses}">
    <c:set var="firstCourse" value="${courses[0]}" />
    <h1>${firstCourse.year}학년도 ${firstCourse.semester}학기 이수 학점</h1>
    <table>
      <tr>
        <th>수강년도</th>
        <th>학기</th>
        <th>교과목명</th>
        <th>교과구분</th>
        <th>담당교수</th>
        <th>학점</th>
      </tr>
      <c:forEach items="${courses}" var="course">
        <tr>
          <td>${course.year}</td>
          <td>${course.semester}</td>
          <td>${course.courseName}</td>
          <td>${course.courseType}</td>
          <td>${course.professor}</td>
          <td>${course.credit}</td>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <p>조회된 결과가 없습니다.</p>
  </c:otherwise>
</c:choose>

</body>
</html>
