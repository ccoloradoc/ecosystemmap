<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="contain-to-grid fixed">
	<nav class="top-bar" data-topbar data-options="sticky_on: [small,medium,large]" role="navigation">
	  <ul class="title-area">
	    <li class="name">
	      <h1><a href="<c:url value="/" />"> <img alt="" src="<c:url value="/resources/ecosystem/img/logo.png" />"/> Ecosystem Map</a></h1>
	    </li>
	     <!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone
	    <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li> -->
	  </ul>
	
	  <section class="top-bar-section">
	    <!-- Right Nav Section -->
	    
	    <ul class="right">
	      <sec:authorize access="isAnonymous()">
	      <li class="active"><a href="#" data-reveal-id="registerModal">Sing In</a></li>
	      <li><a href="#" data-reveal-id="loginModal">Login</a></li>
	      </sec:authorize>
	      <sec:authorize access="isAuthenticated()">
	      <li class="has-dropdown no-click">
	      	<a href="#"><c:out value="${display_name}"/> &nbsp; <i class="fi-torso"></i></a>
	      	<ul class="dropdown">
	      		<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'DEVELOPER')">
	      		<li><a href="<c:url value="/admin" />">Admin Panel</a></li>
	      		</sec:authorize>
	      		<li><a href="<c:url value="/ecosystems" />">Ecosystems</a></li>
	      		<li><a href="<c:url value="/settings" />">Settings</a></li>
	      		<li>
	      			<a id="logoutMenu" href="#">Logout</a>
	      			<form id="logoutForm" action="<c:url value="/j_spring_security_logout" />" method="post">
			      		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			      	</form>
	      		</li>
	      	</ul>	
	      </li>
	      </sec:authorize>
	    </ul>
	  </section>
	</nav>
</div>

<c:if test="${ not empty message }">
	<p class="">${ message }</p>
</c:if>

<!-- The modal for login service -->
<div id="loginModal" class="reveal-modal tiny" data-reveal aria-labelledby="modalTitle" aria-hidden="true" role="dialog">
  <form action="<c:url value="/j_spring_security_check" />" method="post">
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
	<a class="close-reveal-modal" aria-label="Close">&#215;</a>
</div>

<!-- The modal for register service -->
<div id="registerModal" class="reveal-modal tiny" data-reveal aria-labelledby="modalTitle" aria-hidden="true" role="dialog">
	<c:url var="register_new_url" value="/register" />
	<form:form method="post" action="${register_new_url}" modelAttribute="user">
	  <fieldset>
	    <legend>Register</legend>
	
	    <label> Full Name
	    	<form:input path="username" placeholder="Audrey Hepburn"/>
	    </label>
	    <label>Email
	    	<form:input path="email" type="text" placeholder="audrey.hepburn@ecosystemmap.co"/>
	    </label>
	    
	    <label>Password
	    	<form:input path="password" type="password" placeholder="*********"/>
	    </label>
	    
	    <form:input path="enabled" type="hidden" value="0"/>
	    
	    <p class="small">You already have an account? Login <a href="#" id="openLogin">here</a>.</p>
	    <p  class="small">By clicking the button below, you agree to EcosystemMap's <a target="_blank" href="<c:url value="/terms" />">terms of service</a>.</p>
	    <button type="submit" class="button expand success">Register</button>
	  </fieldset>					
	</form:form>
	<a class="close-reveal-modal" aria-label="Close">&#215;</a>
</div>
