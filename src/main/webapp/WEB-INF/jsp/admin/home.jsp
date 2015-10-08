<html>
		<head>
		<title>Ecosystem Map</title>

		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		
		<jsp:include page="../../../include/head.jsp" />
		
	</head>
	<body>
		<jsp:include page="../../../include/header.jsp" />
		<div class="section">			
			<div class="row">
				<c:if test="${not empty message}">
	         		<p data-alert class="alert-box warning radius">${param.message}</p>
	         	</c:if> 
	     		<h1>Administration page</h1>
	     		<c:if test="${not empty user}">
	         		<p>Dear <strong>${user}</strong>, Welcome to Admin Page.</p>
	         	</c:if>
	      	</div>	
		</div>	
		<jsp:include page="../../../include/footer.jsp" />
	</body>
</html>
