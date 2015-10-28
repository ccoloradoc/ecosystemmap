<html>
	<head>
		<title>Ecosystem Map</title>

		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		
		<jsp:include page="../include/head.jsp" />
		
	</head>
	<body>
	<div class="wrapper">
		<jsp:include page="../include/header.jsp" />
		<div class="section">
			
			<div class="row">
	     		
		        <div class="large-offset-3 large-5 columns" role="content">
		        	<form name='loginForm' action="<c:url value="/j_spring_security_check" />" method='POST'>
					  <fieldset>
					    <legend>Login</legend>
					
					    <label>Email
					    	<input name="username" class="username" type="text" placeholder="audrey.hepburn@ecosystemmap.co">
					    </label>
					    
					    <label>Password
					    	<input name="password" class="password" type="password" placeholder="*********">
					    </label>
					    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					    <p class="small">You do not have an account? Get an account <a href="#" id="openRegister">here</a>.</p>
					    <button type="submit" class="button expand success">Login</button>
					  </fieldset>					
					</form>
		        </div>
		     	         
	      	</div>	
		</div>	
		<jsp:include page="../include/footer.jsp" />
	</div>
	</body>
</html>
