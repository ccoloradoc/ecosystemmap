<html>
	<head>
		<title>Ecosystem Map</title>
		
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		
		<jsp:include page="../include/head.jsp" />
		
	</head>
	<body>
		<jsp:include page="../include/header.jsp" />
		<div class="section">			
			<div class="row">
		        <div class="large-offset-3 large-5 columns" role="content">
		        	<c:if test="${DUPLICATE_USER_ERROR == 'active' }">
		        		<h3>Thank you for choosing Ecosystem Map!</h3>
		        		<p>We are sorry! Email account has already been used, If you want to recover password please click <a href="<c:url value='/auth/password_recovery'/>">here</a>.</p>
		        	</c:if>
		        	<c:if test="${VALIDATION_MAIL_SENT == 'active' }">
		        		<h3>Thank you for choosing Ecosystem Map!</h3>
		        		<p>We have send an notification in order to validate your email.</p>
		        	</c:if>
		        	<c:if test="${VALIDATION_URL_ERROR == 'active' }">
		        		<h3>Thank you for choosing Ecosystem Map!</h3>
		        		<p>We are sorry! credentials or activation code is not correct.In order to send the activation email again please click <a href="<c:url value='/auth/validation_recovery'/>">here</a>.</p>
		        	</c:if>
		        	<c:if test="${CREDENTIALS_ERROR == 'active' }">
		        		<h3>Thank you for choosing Ecosystem Map!</h3>
		        		<p>We are sorry! Your user or password are incorrect. If you want to recover password please click <a href="<c:url value='/auth/validation_recovery'/>">here</a>.</p>
		        	</c:if>		        	
		        </div>
	      	</div>	
		</div>	
		<jsp:include page="../include/footer.jsp" />
	</body>
</html>
