<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer class="footer">
  <div class="row">
    <div class="small-12 medium-12 medium-pull-12 columns">
      <p class="footer-links">
        <a href="<c:url value="/" />">Home</a>
        <a href="<c:url value="/about" />">About</a>
        <a href="<c:url value="/faq" />">Faq</a>
        <a href="<c:url value="/contact" />">Contact</a>
        <a href="<c:url value="/terms" />">Terms</a>
      </p>
    </div>
    <div class="small-12 medium-12 medium-pull-12 columns">
    	<p class="copyright"><a href="http://cristiancolorado.com">Cristian Colorado</a> &copy; 2015</p>
    </div>
  </div>
</footer>

<script>
    $(document).foundation();
    
	$('#openRegister').on('click', function() {
		  $('#loginModal').foundation('reveal','close');
		  $('#registerModal').foundation('reveal','open');
	});
	
	$('#openLogin').on('click', function() {
		  $('#registerModal').foundation('reveal','close');
		  $('#loginModal').foundation('reveal','open');
	});
	
	$('#logoutMenu').on('click', function() {
		$('#logoutForm').submit();
	});
</script>
