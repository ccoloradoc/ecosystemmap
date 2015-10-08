package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>Ecosystem Map</title>\n");
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/head.jsp", out, false);
      out.write("\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/header.jsp", out, false);
      out.write("\n");
      out.write("\t\t<div class=\"hero-cover\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"small-12 medium-7 large-7 medium-offset-4 large-offset-5 columns end\">\n");
      out.write("\t\t\t\t\t<div class=\"hide-for-small\">\n");
      out.write("\t\t\t\t\t\t<h1 class=\"hero-heading hero-unit\">We are all part of an <strong>Ecosystem</strong>!.</h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"show-for-small pd-top-lg margin-top-2rem\">\n");
      out.write("\t\t\t\t\t\t<h1 class=\"hero-heading hero-unit\">EcosystemMap helps you to have a better understanding of the ecosystems you live in.</h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<p class=\"lead large hero-unit\"><strong>EcosystemMap</strong> helps you to have a better understanding of the <strong>ecosystems</strong> you live in.</p>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"hide-for-small\">\n");
      out.write("\t\t\t\t\t\t<a class=\"button inverted-button large\" href=\"#\" data-reveal-id=\"registerModal\">Get Started</a>&nbsp;\n");
      out.write("\t\t\t\t\t\t<!-- <a href=\"/download\" class=\"technologies-link-on-homepage link-button\">I'll guide myself, thanks.</a>  -->\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"contain-to-grid\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<ul class=\"inline-list social\">\n");
      out.write("\t\t\t        <a href=\"#\"><i class=\"fi-social-facebook\"></i></a>\n");
      out.write("\t\t\t        <a href=\"#\"><i class=\"fi-social-twitter\"></i></a>\n");
      out.write("\t\t\t        <a href=\"#\"><i class=\"fi-social-linkedin\"></i></a>\n");
      out.write("\t\t\t        <a href=\"#\"><i class=\"fi-social-github\"></i></a>\n");
      out.write("\t\t\t    </ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"section\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"small-12 medium-12 large-12 columns\">\n");
      out.write("\t\t\t\t\t<h2>How does it works?</h2>\n");
      out.write("\t\t\t\t\t<h3>An <strong>Ecosystem</strong> is a set of <strong>elements</strong> linked together.</h3>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"medium-4 columns\">\n");
      out.write("\t\t\t        <div class=\"profile-card\">\n");
      out.write("\t\t\t          <img src=\"http://zurb.com/ink/images/inky-computer.svg\" alt=\"Inky\">\n");
      out.write("\t\t\t          <div class=\"profile-info\">\n");
      out.write("\t\t\t            <h4 class=\"subheader\">Register an ecosystem</h4>\n");
      out.write("\t\t\t            <p>Sing in into our portal and provide the details of your ecosystem.</p>\n");
      out.write("\t\t\t          </div>\n");
      out.write("\t\t\t        </div>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\t\t\t    <div class=\"medium-4 columns\">\n");
      out.write("\t\t\t        <div class=\"profile-card\">\n");
      out.write("\t\t\t          <img src=\"http://zurb.com/ink/images/inky-computer.svg\" alt=\"Inky\">\n");
      out.write("\t\t\t          <div class=\"profile-info\">\n");
      out.write("\t\t\t            <h4 class=\"subheader\">Define elements</h4>\n");
      out.write("\t\t\t            <p>What is the information you want to know about your environment's elements?.</p>\n");
      out.write("\t\t\t          </div>\n");
      out.write("\t\t\t        </div>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\t\t\t    <div class=\"medium-4 columns\">\n");
      out.write("\t\t\t        <div class=\"profile-card\">\n");
      out.write("\t\t\t          <img src=\"http://zurb.com/ink/images/inky-computer.svg\" alt=\"Inky\">\n");
      out.write("\t\t\t          <div class=\"profile-info\">\n");
      out.write("\t\t\t            <h4 class=\"subheader\">Collaborate</h4>\n");
      out.write("\t\t\t            <p>Invite your collegues to collaborate to complete the map of your ecosystem.</p>\n");
      out.write("\t\t\t          </div>\n");
      out.write("\t\t\t        </div>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/footer.jsp", out, false);
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
