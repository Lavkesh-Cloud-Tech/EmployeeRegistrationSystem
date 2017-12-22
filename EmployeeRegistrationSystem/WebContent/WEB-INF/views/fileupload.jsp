
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration</title>
<style type="text/css">
* {
	margin: 0 auto;
}

.header  {
	text-align: center;
	padding: 20px;
	background-color: lightgreen;
	color: blue;
}

.content  {
	padding-top: 10px; 
	padding-bottom: 10px; 
}

.error  {
	color: red; 
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
			<form:form action="${contextPath}/fileupload.html" method="POST"
				enctype="multipart/form-data" commandName="command">
				<table cellpadding="5">
					<tr>
						<td>Employee First Name</td>
						<td><form:input type="text" path="firstName" /></td>
						<td class="error"><form:errors path="firstName" /></td>
					</tr>

					<tr>
						<td>Contact Number</td>
						<td><form:input type="text" path="contact" /></td>
						<td class="error"><form:errors path="contact" /></td>
					</tr>

					<tr>
						<td>Number of years of Experience</td>
						<td><form:input type="text" path="experience" /></td>
						<td class="error"><form:errors path="experience" /></td>
					</tr>

					<tr>
						<td>Resume Upload</td>
						<td><form:input type="file" path="file" /></td>
						<td class="error"><form:errors path="file" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<center>
								<form:button type="submit">Submit</form:button>
							</center>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>