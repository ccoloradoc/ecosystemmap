<html>
	<head>
		<title>Ecosystem Map</title>

		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<jsp:include page="include/head.jsp" />
	</head>
	<body>
		<jsp:include page="include/header.jsp" />
		<div class="hero-cover">
			<div class="row">
				<div class="small-12 medium-7 large-7 medium-offset-4 large-offset-5 columns end">
					<div class="hide-for-small">
						<h1 class="hero-heading hero-unit">We are all part of an <strong>Ecosystem</strong>!.</h1>
					</div>
						
					<div class="show-for-small pd-top-lg margin-top-2rem">
						<h1 class="hero-heading hero-unit">EcosystemMap helps you to have a better understanding of the ecosystems you live in.</h1>
					</div>
						
					<p class="lead large hero-unit"><strong>EcosystemMap</strong> helps you to have a better understanding of the <strong>ecosystems</strong> you live in.</p>
						
					<div class="hide-for-small">
						<a class="button inverted-button large" href="#" data-reveal-id="registerModal">Get Started</a>&nbsp;
						<!-- <a href="/download" class="technologies-link-on-homepage link-button">I'll guide myself, thanks.</a>  -->
					</div>
				</div>
			</div>
		</div>
		
		<div class="contain-to-grid">
			<div class="row">
				<ul class="inline-list social">
			        <a href="#"><i class="fi-social-facebook"></i></a>
			        <a href="#"><i class="fi-social-twitter"></i></a>
			        <a href="#"><i class="fi-social-linkedin"></i></a>
			        <a href="#"><i class="fi-social-github"></i></a>
			    </ul>
			</div>
		</div>
		
		<div class="section">
			<div class="row">
				<div class="small-12 medium-12 large-12 columns">
					<h2>How does it works?</h2>
					<h3>An <strong>Ecosystem</strong> is a set of <strong>elements</strong> linked together.</h3>
				</div>
			</div>
			<div class="row">
				<div class="medium-4 columns">
			        <div class="profile-card">
			          <img src="http://zurb.com/ink/images/inky-computer.svg" alt="Inky">
			          <div class="profile-info">
			            <h4 class="subheader">Register an ecosystem</h4>
			            <p>Sing in into our portal and provide the details of your ecosystem.</p>
			          </div>
			        </div>
			    </div>
			    <div class="medium-4 columns">
			        <div class="profile-card">
			          <img src="http://zurb.com/ink/images/inky-computer.svg" alt="Inky">
			          <div class="profile-info">
			            <h4 class="subheader">Define elements</h4>
			            <p>What is the information you want to know about your environment's elements?.</p>
			          </div>
			        </div>
			    </div>
			    <div class="medium-4 columns">
			        <div class="profile-card">
			          <img src="http://zurb.com/ink/images/inky-computer.svg" alt="Inky">
			          <div class="profile-info">
			            <h4 class="subheader">Collaborate</h4>
			            <p>Invite your collegues to collaborate to complete the map of your ecosystem.</p>
			          </div>
			        </div>
			    </div>
			</div>
		</div>
	
		<jsp:include page="include/footer.jsp" />
	</body>
</html>
