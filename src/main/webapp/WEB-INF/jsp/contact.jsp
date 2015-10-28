<html>
	<head>
		<title>Ecosystem Map</title>

		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		
		<jsp:include page="include/head.jsp" />
		
	</head>
	<body>
		<div class="wrapper">
			<jsp:include page="include/header.jsp" />
			<div class="section">
				<div class="row">
					<div class="large-9 columns">
	     
			          <h3>Get in Touch!</h3>
			          <p>We'd love to hear from you. You can either reach out to us as a whole and one of our awesome team members will get back to you, or if you have a specific question reach out to one of our staff. We love getting email all day <em>all day</em>.</p>
			     
			          <div class="section-container tabs" data-section>
			            <section class="section">
			              <h5 class="title"><a href="#panel1">Contact Our Company</a></h5>
			              <div class="content" data-slug="panel1">
			                <form>
			                  <div class="row collapse">
			                    <div class="large-2 columns">
			                      <label class="inline">Your Name</label>
			                    </div>
			                    <div class="large-10 columns">
			                      <input type="text" id="yourName" placeholder="Jane Smith">
			                    </div>
			                  </div>
			                  <div class="row collapse">
			                    <div class="large-2 columns">
			                      <label class="inline"> Your Email</label>
			                    </div>
			                    <div class="large-10 columns">
			                      <input type="text" id="yourEmail" placeholder="jane@smithco.com">
			                    </div>
			                  </div>
			                  <label>What's up?</label>
			                  <textarea rows="4"></textarea>
			                  <button type="submit" class="radius button">Submit</button>
			                </form>
			              </div>
			            </section>
			            <section class="section">
			              <h5 class="title"><a href="#panel2">Specific Person</a></h5>
			              <div class="content" data-slug="panel2">
			                <ul class="large-block-grid-5">
			                  <li><a href="/cdn-cgi/l/email-protection#177a767b5764726572797e636e39757439657275"><img src="http://placehold.it/200x200&text=[person]">Mal Reynolds</a></li>
			                  <li><a href="/cdn-cgi/l/email-protection#1e64717b5e6d7b6c7b70776a67307c7d306c7b7c"><img src="http://placehold.it/200x200&text=[person]">Zoe Washburne</a></li>
			                  <li><a href="/cdn-cgi/l/email-protection#9cf6fde5f2f9dceff9eef9f2f5e8e5b2feffb2eef9fe"><img src="http://placehold.it/200x200&text=[person]">Jayne Cobb</a></li>
			                  <li><a href="/cdn-cgi/l/email-protection#0f6b606c4f7c6a7d6a61667b76216d6c217d6a6d"><img src="http://placehold.it/200x200&text=[person]">Simon Tam</a></li>
			                  <li><a href="/cdn-cgi/l/email-protection#a4cfcdc8c8ddcbd1d3cdd0ccc9ddc9cdcac0e4d7c1d6c1cacdd0dd8ac6c78ad6c1c6"><img src="http://placehold.it/200x200&text=[person]">River Tam</a></li>
			                  <li><a href="/cdn-cgi/l/email-protection#f4989195929b9a809c91839d9a90b4879186919a9d808dda9697da869196"><img src="http://placehold.it/200x200&text=[person]">Hoban Washburne</a></li>
			                  <li><a href="/cdn-cgi/l/email-protection#bddfd2d2d6fdced8cfd8d3d4c9c493dfde93cfd8df"><img src="http://placehold.it/200x200&text=[person]">Shepherd Book</a></li>
			                  <li><a href="/cdn-cgi/l/email-protection#c9a2a5acac89baacbbaca7a0bdb0e7abaae7bbacab"><img src="http://placehold.it/200x200&text=[person]">Kaywinnet Lee Fry</a></li>
			                  <li><a href="/cdn-cgi/l/email-protection#f89196998a99b89f8d91949cd69b979588d6999494"><img src="http://placehold.it/200x200&text=[person]">Inarra Serra</a></li>
			                </ul>
			              </div>
			            </section>
			          </div>
			        </div>
	
			        <div class="large-3 columns">
			          <h5>Map</h5>		           
			          <p>
			            <a href="" data-reveal-id="mapModal"><img src="http://placehold.it/400x280"></a><br/>
			            <a href="" data-reveal-id="mapModal">View Map</a>
			          </p>
			          <p>
			            123 Awesome St.<br/>
			            Barsoom, MA 95155
			          </p>
			        </div>
			         
			      </div>
			</div>
			
			<div class="reveal-modal" id="mapModal">
		        <h4>Where We Are</h4>
		        <p><img src="http://placehold.it/800x600"/></p>
		     
		         
		        <a href="#" class="close-reveal-modal">×</a>
		    </div>
		   
			<jsp:include page="include/footer.jsp" />
		</div>
	</body>
</html>
