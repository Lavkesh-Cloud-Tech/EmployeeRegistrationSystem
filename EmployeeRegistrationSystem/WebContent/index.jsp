<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee Registration</title>

<style type="text/css">
* {
	margin: 0 auto;
}

.header  {
	text-align: center;
	padding: 10px;
}

.content  {
	text-align: center;
	padding-bottom: 10px 
}
</style>

</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
	<div>
		<div class="header">
			<h2>Employee Registration</h2>
		</div>

		<div class="content">
			<a href="${contextPath}/fileupload.html">Click here for	registration</a>
		</div>
	</div>

</body>
</html>