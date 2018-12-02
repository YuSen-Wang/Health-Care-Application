<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Medications</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

	  <style>
    	.red {
    		color:red;
    	}
    </style>	
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Medical App - Medication</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
			<input type="button" value="Add Medication"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add a search box -->
			<form:form action="search" method="POST">
				Search medication: <input type="text" name="theSearchName" />
				
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Name</th>
					<th>Inventory</th>
					<th>Quantity</th>
					<th></th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempMedication" items="${medications}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/medication/showFormForUpdate">
						<c:param name="medicationId" value="${tempMedication.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/medication/delete">
						<c:param name="medicationId" value="${tempMedication.id}" />
					</c:url>					
					
				
					
					<tr>
						<td> ${tempMedication.name} </td>
						<td> ${tempMedication.inventory} </td>
						<c:choose>		
						<c:when test= "${tempMedication.quatity <=10}">	
							<td class="red"> ${tempMedication.quatity} </td>
						</c:when>
						<c:otherwise>
						<td> ${tempMedication.quatity} </td>	
					 </c:otherwise>
				</c:choose>	 
						
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Remove</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
			
				<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
				
   <A href="/spring-security-demo/patient/list">To Patient App</A>				
		
		</div>
	
	</div>
	

</body>

</html>









