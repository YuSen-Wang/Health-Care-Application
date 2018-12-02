<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Medication</title>
	
	<style>
		.error {color:red}
	</style>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Medical App - Medication</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Medication</h3>
	
		<form:form action="saveMedication" modelAttribute="medication" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" />
						<form:errors path="name" cssClass="error" /></td>
					</tr>
				
					<tr>
						<td><label>Inventory:</label></td>
						<td><form:input path="inventory" /></td>
					</tr>

					<tr>
						<td><label>Quantity:</label></td>
						<td><form:input path="quatity" /></td>
					</tr>
					

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/medication/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










