<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>
	


	<title>List Patients</title>
	
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
			<h2>Medical App - Patient Record</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
			<sec:authorize access="hasRole('ROLE_DOCTOR')">
			<input type="button" value="Add Patient"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			</sec:authorize>
		
			<!--  add a search box -->
			<form:form action="search" method="POST">
				Search patient(first name): <input type="text" name="theSearchName" />
				
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Weight(lb)</th>
					<th>Blood Pressure</th>
					<sec:authorize access="hasRole('ROLE_DOCTOR')">
					<th></th>
					</sec:authorize>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempPatient" items="${patients}">
				   
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/patient/showFormForUpdate">
						<c:param name="patientId" value="${tempPatient.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/patient/delete">
						<c:param name="patientId" value="${tempPatient.id}" />
					</c:url>					
					
					
					
					
					<tr>
						<td> ${tempPatient.firstName} </td>
						<td> ${tempPatient.lastName} </td>
						<td> ${tempPatient.email} </td>	
						<td> ${tempPatient.weight} </td>	
				<c:choose>		
					<c:when test= "${tempPatient.bloodPressure >=100}">	
							<td class="red"> ${tempPatient.bloodPressure} </td>
					</c:when>
					<c:otherwise>
						<td> ${tempPatient.bloodPressure} </td>	
					 </c:otherwise>
				</c:choose>	 
						<sec:authorize access="hasRole('ROLE_DOCTOR')">
						<td>
							<!-- display the update link -->
							
							<a href="${updateLink}">Update</a>
							
							<a href="${deleteLink}"
							
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Remove</a>
						</td>
						</sec:authorize>
						
					</tr>
					
				
				</c:forEach>
						
			</table>
			
				<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
  
   <sec:authorize access="hasRole('ROLE_PHARMACIST')">
	   <td> <a href="/spring-security-demo/medication/list">To Medication App</a> </td>	
   </sec:authorize>	
 
				
		</div>
	
	</div>
	
	

</body>

</html>









