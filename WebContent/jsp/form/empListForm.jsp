<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>사 원 리 스 트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="jumbotron text-center" style="margin-bottom: 0">
			<h3>사 원 리 스 트</h3>
		</div>
		<a href="emp_add">사원 등록하기</a><br /> <br />
		<form action="emp_search" method="post">
			<div class="input-group mb-3">
				<input class="form-control" type="text" placeholder="고용일자" name="datefirst" /> 
				<div class="input-group-prepend">
					<span class="input-group-text"> ~ </span>
				</div>
				<input class="form-control" type="text" placeholder="고용일자" name="datesecond" />
				<input class="form-control" type="submit" value="검색" />
			</div>
		</form>
		<c:if test="${empty emplist}">
			<hr />
		검색된 결과가 존재 하지 않습니다.
		<hr />
		</c:if>
		<c:if test="${!empty emplist}">
			<table class="table table-hover">
				<tr>
					<td>사원 번호</td>
					<td>사원 이름</td>
					<td>고용 일자</td>
				</tr>
				<c:forEach var="emps" items="${emplist}">
					<tr>
						<td>${emps.empno}</td>
						<td><a href = "emp_detail?empnoindex=${emps.empno}">${emps.ename}</a>
						<td>${emps.hiredate}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>