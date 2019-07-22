<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta content="utf-8">
<title>사 원 상 세 보 기</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var dept = "${selectedemp.deptno}";
		$('option').each(function() {
			if (dept == $(this).val()) {
				$(this).attr('selected', 'selected');
			}
		});
	});
</script>
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
		<div class="jumbotron text-center" style="margin-bottom: 0">
			<h3>사원 상세 보기</h3>
		</div>
		<a href="emp_list">리스트로 돌아가기</a>
		<form method="post" action="emp_update?updateno=${selectedemp.empno}">

			사원 번호: <input type="text" class="form-control" name="empno" value="${selectedemp.empno}" disabled="disabled" /><br /> 
			사원 이름: <input type="text" class="form-control" name="ename" value="${selectedemp.ename}" /><br /> 
			업무: <input type="text" class="form-control" name="job" value="${selectedemp.job}" /><br />
			고용 일자: <input type="text" class="form-control" name="hiredate" value="${selectedemp.hiredate}" disabled="disabled" /><br /> 
			급여 금액: <input type="text" class="form-control" name="sal" value="${selectedemp.sal}" /><br /> 
			부서: <select class="form-control" name=deptno>
				<c:forEach var="deptname" items="${deptlist}">
					<option value="${deptname.deptno}">${deptname.dname}</option>
				</c:forEach>
			</select> <input type="submit" class="btn btn-outline-primary" name="Commit" value="수정" />
		</form>
		<a href="emp_delete?deleteno=${selectedemp.empno}"
			class="btn btn-outline-primary">삭제</a> <br /> <br />
	</div>

</body>
</html>