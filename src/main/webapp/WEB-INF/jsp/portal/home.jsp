<html>
		<head>
		<title>Ecosystem Map</title>

		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		
		<jsp:include page="../include/head.jsp" />
		<jsp:include page="../include/head_angular.jsp" />
	</head>
	<body ng-app="ecosystemApp">
		<div class="wrapper">
			<jsp:include page="../include/header.jsp" />
			<section class="section">			
				<div class="row">
		         	<div class="large-12 column">
		         		<div class="view-animate-container">
		         			<div ng-view class="view-animate">
		         			
		         			</div>
		         		</div>
		         	</div>
		      	</div>
			</section>	
			
			<script src="<c:url value="/resources/ecosystem/js/portal/app.js" />"></script>
			<jsp:include page="../include/footer.jsp" />
		</div>
	</body>
</html>
