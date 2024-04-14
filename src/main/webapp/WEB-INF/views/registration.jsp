<%--
  Created by IntelliJ IDEA.
  User: soohee
  Date: 4/12/24
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>수강신청</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/registrationStyle.css'/>">
</head>
<body>
<div class="container">
<sf:form method="post" action="${pageContext.request.contextPath}/doneregister" modelAttribute="registration">
    <h1>수강신청</h1>
    <table>
        <tr>
            <td><label for="courseCode">교과목 코드:</label></td>
            <td>
                <div class="input-container">
                        <sf:input type="text" id="courseCode" path="courseCode" />
            <sf:errors path="courseCode" cssClass="error" />
                </div>
            </td>
        </tr>

        <tr>
            <td><label for="courseName">교과목명:</label></td>
            <td>
                <div class="input-container">
                <sf:input type="text" id="courseName" path="courseName" />
            <sf:errors path="courseName" cssClass="error" />
                </div>
            </td>
        </tr>

        <tr>
            <td><label for="courseType">교과 구분:</label></td>
            <td>
                <div class="input-container">
                <sf:input type="text" id="courseType" path="courseType" />
            <sf:errors path="courseType" cssClass="error" />
                </div>
            </td>
        </tr>

        <tr>
            <td><label for="professor">담당 교수:</label></td>
            <td>

                <div class="input-container">
                    <sf:input type="text" id="professor" path="professor" />
                    <sf:errors path="professor" cssClass="error" />
                </div>
            </td>
        </tr>

        <tr>
            <td><label for="credit">학점:</label></td>
            <td>
                <div class="input-container">
                        <sf:input type="text" id="credit" path="credit" />
                    <c:if test="${not empty creditError}">
                    <div class="error">${creditError}</div>
                    </c:if>
                </div>
            </td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="제출하기"></td>
        </tr>
    </table>
</sf:form>
</div>
</body>
</html>
