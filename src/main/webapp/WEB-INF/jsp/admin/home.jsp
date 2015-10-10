<html>
		<head>
		<title>Ecosystem Map</title>

		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
		
		<jsp:include page="../../../include/head.jsp" />
	</head>
	<body>
		<jsp:include page="../../../include/header.jsp" />
		<section class="section">			
			<div class="row">
	         	<div class="large-12 column">
	         		<div class="card">
	         			<div class="card-header">
	         				<h3><i class="fi-torsos-all"></i>&nbsp;Users</h3>
	         				<button href="#" data-dropdown="users-drop" aria-controls="users-drop" aria-expanded="false" class="tiny button secondary dropdown"><i class="fi-widget"></i></button><br>
							<ul id="users-drop" data-dropdown-content class="f-dropdown" aria-hidden="true">
							  <li><a href="#" data-reveal-id="newUserModal" >Add User</a></li>
							</ul>
	         			</div>
	         			
	         			<div class="card-content">		         			
		         			<table class="usertable">
			         			<thead>
			         				<tr>
				         				<th>User</th>
				         				<th>Mail</th>
				         				<th>Password</th>
				         				<th>Activation Code</th>
				         				<th>Enabled?</th>
				         				<th></th>
				         				<th></th>
				         			</tr>
			         			</thead>
			         		<c:forEach items="${userList}" var="user">
						        <tr>
						            <td><a href="<c:url value="/admin/user/show/${user.userId}" />"><c:out value="${user.username}"/></a></td>
						            <td><c:out value="${user.email}"/></td>
						            <td><c:out value="${user.password}"/></td>
						            <td><c:out value="${user.activationCode}"/></td>
						            <td><c:out value="${user.enabled}"/></td>
						            <td><a href="#" data-reveal-id="editUserModal"><i class="fi-pencil"></i></a></td>
						            <td><a href="<c:url value="/admin/user/delete/${user.userId}" />"><i class="fi-x"></i></a></td>
						        </tr>
						    </c:forEach>
						    </table>
					    </div>
	         		</div>
	         	</div>
	      	</div>
	      	
	      	<div id="newUserModal" class="reveal-modal tiny" data-reveal aria-labelledby="modalTitle" aria-hidden="true" role="dialog">
	      		<c:url var="user_new_url" value="/admin/user/new" />
		      	<form:form method="post" action="${user_new_url}" modelAttribute="user">
		      		<fieldset>
		      			<legend>Add User</legend>
			      		<form:label path="username">User Name:
							<form:input path="username" />
						</form:label>
						<form:label path="email">Email:
							<form:input path="email" /></p>
						</form:label>
						<form:input path="enabled" type="hidden" value="0"/>
						<input type="submit" value="Add User" class="button expand"/>
					</fieldset>
	            </form:form>
	            <a class="close-reveal-modal" aria-label="Close">&#215;</a>
            </div>
            
            <div id="editUserModal" class="reveal-modal tiny" data-reveal aria-labelledby="modalTitle" aria-hidden="true" role="dialog">
	      		<c:url var="user_new_url" value="/admin/user/update" />
		      	<form:form method="post" action="${user_new_url}" modelAttribute="user">
		      		<fieldset>
		      			<legend>Edit User</legend>
			      		<form:label path="username">User Name:
							<form:input path="username" />
						</form:label>
						<form:label path="email">Email:
							<form:input path="email" /></p>
						</form:label>
						
						<fieldset class="switch round tiny">
						  <form:checkbox path="enabled" value="1"></form:checkbox>
						  <label for="enabled"></label>
						</fieldset>
						<input type="submit" value="Add User" class="button expand"/>
					</fieldset>
	            </form:form>
	            <a class="close-reveal-modal" aria-label="Close">&#215;</a>
            </div>
	      	
		</section>	
		<jsp:include page="../../../include/footer.jsp" />
		<script type="text/javascript">
			$('.usertable').DataTable();
		</script>
	</body>
</html>
