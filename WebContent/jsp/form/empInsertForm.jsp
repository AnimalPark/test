<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta content="utf-8">
<title>사 원 등 록</title>
<meta charset="utf-8">
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
	<div class="container mt-3">
		<div class="jumbotron text-center">
			<h3>사 원 등 록</h3>
		</div>
		<a href="emp_list"> 사원리스트로 가기</a>
		<form method="post" action="emp_insert">
			사원 이름: <input type="text" class="form-control" placeholder="이름을 입력하세요." name="ename" /><br />
			업무: <input type="text" class="form-control" placeholder="업무를 입력하세요." name="job"><br />
			급여 금액: <input type="text" class="form-control" placeholder="가격을 입력하세요." name="sal" /><br /> 
			부서 : <select class="form-control" name=deptno>
					<c:forEach var="deptname" items="${deptlist}">
						<option value="${deptname.deptno}">${deptname.dname}</option>
					</c:forEach>
			</select>
			<br /><input type="submit" class="btn btn-outline-primary" value="제출" />
		</form>

	</div>
</body>
</html>