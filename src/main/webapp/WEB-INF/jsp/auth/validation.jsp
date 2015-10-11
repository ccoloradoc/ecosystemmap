<html>
	<head>
		<title>Ecosystem Map</title>

		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>		
		<jsp:include page="../../../include/head.jsp" />
		
	</head>
	<body>
		<jsp:include page="../../../include/header.jsp" />
		<div class="section">
			<div class="row">
				<div class="large-offset-3 large-5 columns" role="content">
			        <c:if test="${ not empty error}">
						<div data-alert class="alert-box alert radius">
						  ${error}
						  <a href="#" class="close">&times;</a>
						</div>
					</c:if>
				</div>
			</div>
			<div class="row">
		        <div class="large-offset-3 large-5 columns" role="content">
		        	<c:url var="validate_url" value="/auth/validate" />
					<form:form method="post" action="${validate_url}" modelAttribute="validateUser">
					  <fieldset>
					    <legend>Login</legend>
					
					    <label>Email
					    	<form:input path="email" placeholder="audrey.hepburn@ecosystemmap.co"/>
					    </label>
					    
					    <label>Password
					    	<form:input path="password" type="password" placeholder="*********"/>
					    </label>
					    <form:hidden path="activationCode"/>
					    
					    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					    <button type="submit" class="button expand success">Login</button>
					  </fieldset>					
					</form:form>
		        </div>
	      	</div>	
		</div>	
		<jsp:include page="../../../include/footer.jsp" />
	</body>
</html>
