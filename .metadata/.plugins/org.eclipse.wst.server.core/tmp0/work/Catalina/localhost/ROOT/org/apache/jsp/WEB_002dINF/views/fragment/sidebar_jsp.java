/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.73
 * Generated at: 2022-02-09 04:45:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.fragment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sidebar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!-- ======= Sidebar ======= -->\r\n");
      out.write("<aside id=\"sidebar\" class=\"sidebar\">\r\n");
      out.write("\r\n");
      out.write("  <ul class=\"sidebar-nav\" id=\"sidebar-nav\">\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link \" href=\"/article/list\">\r\n");
      out.write("        <i class=\"bi bi-grid\"></i>\r\n");
      out.write("        <span>???????????????</span>\r\n");
      out.write("      </a>\r\n");
      out.write("    </li><!-- End Dashboard Nav -->\r\n");
      out.write("    \r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link \" href=\"/chat\">\r\n");
      out.write("        <i class=\"bi bi-grid\"></i>\r\n");
      out.write("        <span>??????</span>\r\n");
      out.write("      </a>\r\n");
      out.write("    </li><!-- End Dashboard Nav -->    \r\n");
      out.write("    \r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link collapsed\" data-bs-target=\"#components-nav\" data-bs-toggle=\"collapse\" href=\"#\">\r\n");
      out.write("        <i class=\"bi bi-menu-button-wide\"></i><span>Components</span><i class=\"bi bi-chevron-down ms-auto\"></i>\r\n");
      out.write("      </a>\r\n");
      out.write("      <ul id=\"components-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-alerts.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Alerts</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-accordion.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Accordion</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-badges.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Badges</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-breadcrumbs.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Breadcrumbs</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-buttons.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Buttons</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-cards.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Cards</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-carousel.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Carousel</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-list-group.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>List group</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-modal.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Modal</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-tabs.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Tabs</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-pagination.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Pagination</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-progress.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Progress</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-spinners.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Spinners</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"components-tooltips.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Tooltips</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li><!-- End Components Nav -->\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link collapsed\" data-bs-target=\"#forms-nav\" data-bs-toggle=\"collapse\" href=\"#\">\r\n");
      out.write("        <i class=\"bi bi-journal-text\"></i><span>Forms</span><i class=\"bi bi-chevron-down ms-auto\"></i>\r\n");
      out.write("      </a>\r\n");
      out.write("      <ul id=\"forms-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"forms-elements.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Form Elements</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"forms-layouts.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Form Layouts</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"forms-editors.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Form Editors</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"forms-validation.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Form Validation</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li><!-- End Forms Nav -->\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link collapsed\" data-bs-target=\"#tables-nav\" data-bs-toggle=\"collapse\" href=\"#\">\r\n");
      out.write("        <i class=\"bi bi-layout-text-window-reverse\"></i><span>Tables</span><i class=\"bi bi-chevron-down ms-auto\"></i>\r\n");
      out.write("      </a>\r\n");
      out.write("      <ul id=\"tables-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"tables-general.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>General Tables</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"tables-data.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Data Tables</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li><!-- End Tables Nav -->\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link collapsed\" data-bs-target=\"#charts-nav\" data-bs-toggle=\"collapse\" href=\"#\">\r\n");
      out.write("        <i class=\"bi bi-bar-chart\"></i><span>Charts</span><i class=\"bi bi-chevron-down ms-auto\"></i>\r\n");
      out.write("      </a>\r\n");
      out.write("      <ul id=\"charts-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"charts-chartjs.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Chart.js</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"charts-apexcharts.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>ApexCharts</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"charts-echarts.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>ECharts</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li><!-- End Charts Nav -->\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link collapsed\" data-bs-target=\"#icons-nav\" data-bs-toggle=\"collapse\" href=\"#\">\r\n");
      out.write("        <i class=\"bi bi-gem\"></i><span>Icons</span><i class=\"bi bi-chevron-down ms-auto\"></i>\r\n");
      out.write("      </a>\r\n");
      out.write("      <ul id=\"icons-nav\" class=\"nav-content collapse \" data-bs-parent=\"#sidebar-nav\">\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"icons-bootstrap.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Bootstrap Icons</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"icons-remix.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Remix Icons</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"icons-boxicons.html\">\r\n");
      out.write("            <i class=\"bi bi-circle\"></i><span>Boxicons</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </li><!-- End Icons Nav -->\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-heading\">Pages</li>\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link collapsed\" href=\"users-profile.html\">\r\n");
      out.write("        <i class=\"bi bi-person\"></i>\r\n");
      out.write("        <span>Profile</span>\r\n");
      out.write("      </a>\r\n");
      out.write("    </li><!-- End Profile Page Nav -->\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link collapsed\" href=\"pages-faq.html\">\r\n");
      out.write("        <i class=\"bi bi-question-circle\"></i>\r\n");
      out.write("        <span>F.A.Q</span>\r\n");
      out.write("      </a>\r\n");
      out.write("    </li><!-- End F.A.Q Page Nav -->\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link collapsed\" href=\"pages-contact.html\">\r\n");
      out.write("        <i class=\"bi bi-envelope\"></i>\r\n");
      out.write("        <span>Contact</span>\r\n");
      out.write("      </a>\r\n");
      out.write("    </li><!-- End Contact Page Nav -->\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link collapsed\" href=\"pages-register.html\">\r\n");
      out.write("        <i class=\"bi bi-card-list\"></i>\r\n");
      out.write("        <span>Register</span>\r\n");
      out.write("      </a>\r\n");
      out.write("    </li><!-- End Register Page Nav -->\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link collapsed\" href=\"pages-login.html\">\r\n");
      out.write("        <i class=\"bi bi-box-arrow-in-right\"></i>\r\n");
      out.write("        <span>Login</span>\r\n");
      out.write("      </a>\r\n");
      out.write("    </li><!-- End Login Page Nav -->\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link collapsed\" href=\"pages-error-404.html\">\r\n");
      out.write("        <i class=\"bi bi-dash-circle\"></i>\r\n");
      out.write("        <span>Error 404</span>\r\n");
      out.write("      </a>\r\n");
      out.write("    </li><!-- End Error 404 Page Nav -->\r\n");
      out.write("\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("      <a class=\"nav-link collapsed\" href=\"pages-blank.html\">\r\n");
      out.write("        <i class=\"bi bi-file-earmark\"></i>\r\n");
      out.write("        <span>Blank</span>\r\n");
      out.write("      </a>\r\n");
      out.write("    </li><!-- End Blank Page Nav -->\r\n");
      out.write("\r\n");
      out.write("  </ul>\r\n");
      out.write("\r\n");
      out.write("</aside><!-- End Sidebar-->");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
