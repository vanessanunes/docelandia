package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"pt-br\">\r\n");
      out.write("<head>\r\n");
      out.write("  <title>Docelandia - Central de doces</title>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <!-- Chamada Css-->\r\n");
      out.write("<a href=\"css/bootstrap.min.css.map\"></a>\r\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <!-- Chamadas JS -->\r\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("          <script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body id=\"myPage\" data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"60\">\r\n");
      out.write("<!--Chamada CSS-->\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/sprtd.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<!-- Menu responsivo -->\r\n");
      out.write("<nav role=\"navigation\" class=\"navbar navbar-default navbar-inverse navbar-fixed-top\">\r\n");
      out.write("    \r\n");
      out.write("  \r\n");
      out.write("<div class=\"navbar-header\">\r\n");
      out.write("      <a class=\"navbar-brand\" href=\"index.jsp\"></a>\r\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\" >\r\n");
      out.write("        \r\n");
      out.write("        <span class=\"sr-only\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("      </button>\r\n");
      out.write("      <!-- Logo -->\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Menu normal responsivo  -->\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\r\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("          <li><a href=\"index.jsp\">Inicio </a></li>\r\n");
      out.write("         <li><a href=\"cadastro_cliente.jsp\">Login</a></li>\r\n");
      out.write("        <li><a href=\"#\">Contato</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write(" \r\n");
      out.write("<!-- Telão resposivo -->\r\n");
      out.write("<div id=\"fieto\">\r\n");
      out.write("   \r\n");
      out.write("    <div id=\"fieto-overlay\">\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
