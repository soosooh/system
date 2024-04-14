<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>종합정보시스템</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/HomeStyle.css'/>">
  </head>
  <body>

  <div class="header">
    <%-- 로그인 상태에 따라 버튼 --%>
    <c:choose>
      <c:when test="${pageContext.request.userPrincipal == null}">
        <%-- 로그인 상태가 아닐 때 로그인 버튼 --%>
        <a href="${pageContext.request.contextPath}/login"><button>SIGN IN</button></a>
      </c:when>
      <c:otherwise>
        <%-- 로그인 상태일 때 로그아웃 버튼 --%>
        <form id="logout" action="<c:url value='/logout'/>" method="post">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          <button type="submit">LOGOUT</button>
        </form>
      </c:otherwise>
    </c:choose>
  </div>

  <div class="main-title">학사정보시스템</div>

  <div class="card-container">

    <div class="card">
      <h2>학년별 이수 학점 조회</h2>
      <a href="${pageContext.request.contextPath}/coursecheck"><button>조회</button></a>
    </div>

    <div class="card">
      <h2>수강신청하기</h2>
      <a href="${pageContext.request.contextPath}/registration"><button>신청</button></a>
    </div>

    <div class="card">
      <h2>수강 신청 조회</h2>
      <a href="${pageContext.request.contextPath}/result"><button>조회</button></a>
    </div>

    <c:if test="${pageContext.request.userPrincipal != null}">
    <form id="logout" action="<c:url value='/logout'/>" method="post">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
    </c:if>

  </body>
</html>
