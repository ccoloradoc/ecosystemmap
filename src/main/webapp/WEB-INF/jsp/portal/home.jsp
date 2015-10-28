<html>
		<head>
		<title>Ecosystem Map</title>

		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		
		<jsp:include page="../../../include/head.jsp" />
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="../../../include/header.jsp" />
			<section class="section">			
				<div class="row">
		         	<div class="large-12 column">
		         		<div class="card">
		         			<div class="card-header">
		         				<h3><i class="fi-torsos-all"></i>&nbsp;Ecosystem</h3>
		         				<button href="#" data-dropdown="users-drop" aria-controls="users-drop" aria-expanded="false" class="tiny button secondary dropdown"><i class="fi-widget"></i></button><br>
								<ul id="users-drop" data-dropdown-content class="f-dropdown" aria-hidden="true">
								  <li><a href="#" data-reveal-id="newUserModal" >Add Ecosystem</a></li>
								</ul>
		         			</div>
		         			
		         			<div class="card-content">		         			
							    
						    </div>
		         		</div>
		         	</div>
		      	</div>
		      	
		      	
			</section>	
			<jsp:include page="../../../include/footer.jsp" />
		</div>
	</body>
</html>
