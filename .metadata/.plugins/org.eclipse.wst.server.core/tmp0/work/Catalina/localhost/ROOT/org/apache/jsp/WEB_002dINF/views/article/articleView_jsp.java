/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.73
 * Generated at: 2022-02-01 19:38:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.article;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class articleView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/SpringProjects/sts01_work/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ever/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1643011921376L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>articleView</title>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$(document).ready(function() {\r\n");
      out.write("		$(\"#topBtn\").on(\"click\", function() {\r\n");
      out.write("			$(\"html, body\").animate({ scrollTop:0 }, 100);\r\n");
      out.write("			return false;\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		$(\"#heartWrapper\").on(\"click\", function() {\r\n");
      out.write("			const heartIconTag = $(\"#heartIcon\");\r\n");
      out.write("			const heartClass = heartIconTag.attr(\"class\");\r\n");
      out.write("			const heartCountTag = $(\"#heartCount\");\r\n");
      out.write("			//let heartCount = heartCountTag.text();\r\n");
      out.write("			const ano = $(\"#ano\").val();\r\n");
      out.write("			const mid = $(\"#mid\").val();\r\n");
      out.write("			\r\n");
      out.write("			// 좋아요 갯수 불러오기\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url: \"/article/like\",\r\n");
      out.write("				data: {\r\n");
      out.write("					ano:ano\r\n");
      out.write("				},\r\n");
      out.write("				method:\"GET\"\r\n");
      out.write("			})\r\n");
      out.write("			.done(function(result) {\r\n");
      out.write("				heartCountTag.text(result);\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			if(!mid) {\r\n");
      out.write("				let result = confirm(\"이 기능은 로그인 멤버만 사용할 수 있습니다.\\n로그인하시겠습니까?\");\r\n");
      out.write("				if(result) {\r\n");
      out.write("					location.href=\"/member/login\";	\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			// 빈 하트 상태\r\n");
      out.write("			if(heartClass === \"far fa-heart\") {\r\n");
      out.write("				heartIconTag.attr(\"class\", \"fas fa-heart\");\r\n");
      out.write("				heartCount++;\r\n");
      out.write("				heartCountTag.text(heartCount);\r\n");
      out.write("			} \r\n");
      out.write("			\r\n");
      out.write("			// 들어있는 하트 상태\r\n");
      out.write("			if(heartClass === \"fas fa-heart\") {\r\n");
      out.write("				heartIconTag.attr(\"class\", \"far fa-heart\");\r\n");
      out.write("				heartCount--;\r\n");
      out.write("				heartCountTag.text(heartCount);\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("	table .ellipsis {\r\n");
      out.write("		position: relative;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.table .ellipsis span {\r\n");
      out.write("		overflow: hidden;\r\n");
      out.write("		white-space: nowrap;\r\n");
      out.write("		text-overflow: ellipsis;\r\n");
      out.write("		position: absolute;\r\n");
      out.write("		left: 9px;\r\n");
      out.write("		right: 9px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.ellipsis:before {\r\n");
      out.write("		content: '';\r\n");
      out.write("		display: inline-block;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.comment_inbox_text {\r\n");
      out.write("		border: 0px;\r\n");
      out.write("		background: transparent;\r\n");
      out.write("		resize: none;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.comment_inbox_text:focus {\r\n");
      out.write("		box-shadow: none;\r\n");
      out.write("		outline: none;\r\n");
      out.write("	}\r\n");
      out.write("	.report-span:before {\r\n");
      out.write("		content: \"｜\";\r\n");
      out.write("	    margin: 0px 5px;\r\n");
      out.write("	    color: silver;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fimport_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <main id=\"main\" class=\"main\">\r\n");
      out.write("	<input type=\"hidden\" id=\"ano\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${article.ano}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("	<input type=\"hidden\" id=\"mid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member.mid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("	\r\n");
      out.write("    <div class=\"container pagetitle clearfix\" style=\"width:860px; margin:0 auto;\">\r\n");
      out.write("      <div class=\"float-end\">\r\n");
      out.write("		<div class=\"btn btn-sm fw-bold\" style=\"background:#e6e6e6;\"><i class=\"fas fa-chevron-up\"></i> &nbsp; 이전글</div>\r\n");
      out.write("		<div class=\"btn btn-sm fw-bold\" style=\"background:#e6e6e6;\"><i class=\"fas fa-chevron-down\"></i> &nbsp; 다음글</div>\r\n");
      out.write("		<div class=\"btn btn-sm fw-bold\" style=\"background:#e6e6e6;\">목록</div>\r\n");
      out.write("	  </div>\r\n");
      out.write("    </div><!-- End Page Title -->\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"container\" style=\"width:860px; margin:0 auto;\">\r\n");
      out.write("		<div class=\"mt-3 p-4\" style=\"border:1px solid gray; border-radius:5px;\">\r\n");
      out.write("			<div class=\"ms-1\" style=\"color:#03c75a; font-size:13px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${article.acategoryno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" <i class=\"fas fa-chevron-right\"></i></div>\r\n");
      out.write("			<div>\r\n");
      out.write("				<span class=\"fw-bold fs-4\">[");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${article.acategorynoref}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("] </span>\r\n");
      out.write("				<span class=\"fw-bold fs-4\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${article.atitle}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"clearfix\">\r\n");
      out.write("				<div class=\"float-start d-flex align-items-start mt-2\"> \r\n");
      out.write("					<img src=\"https://bootdey.com/img/Content/avatar/avatar1.png\" class=\"rounded-circle\" alt=\"profile-image\" style=\"width:36px; height:36px;\">\r\n");
      out.write("					<div class=\"w-100 ms-3\">\r\n");
      out.write("						<div style=\"font-size:14px;\">\r\n");
      out.write("							<span class=\"me-1 fw-bold\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${article.awriter}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("							<span>침팬치</span>\r\n");
      out.write("							<div class=\"badge badge-sm\" style=\"background:#d4d4d4; color:#000; border-radius:5px;\">1:1 채팅</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"text-muted mt-1\" style=\"font-size:12px;\">\r\n");
      out.write("							<span class=\"me-1\">2022.01.29. 17:04</span> \r\n");
      out.write("							<span>조회 224</span>\r\n");
      out.write("						</div>  \r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"float-end\" style=\"line-height:55px;\">\r\n");
      out.write("					<span>\r\n");
      out.write("						<span class=\"me-2\" style=\"font-size:13px;\">\r\n");
      out.write("							<i class=\"far fa-comment-dots\"></i>&nbsp;\r\n");
      out.write("							<span>댓글</span> \r\n");
      out.write("							<span class=\"fw-bold\">17</span>\r\n");
      out.write("						</span>\r\n");
      out.write("						<span class=\"me-2\" style=\"font-size:13px;\">URL 복사</span>\r\n");
      out.write("						<span><i class=\"fas fa-ellipsis-v\" style=\"color:#b2b2b2; font-size:16px;\"></i></span>\r\n");
      out.write("					</span>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<hr>\r\n");
      out.write("\r\n");
      out.write("			<div>\r\n");
      out.write("				");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${article.acontent}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"d-flex align-items-start mt-4\"> \r\n");
      out.write("				<img src=\"https://bootdey.com/img/Content/avatar/avatar1.png\" class=\"rounded-circle\" alt=\"profile-image\" style=\"width:36px; height:36px;\">\r\n");
      out.write("				<div class=\"w-100 ms-3\">\r\n");
      out.write("					<div style=\"font-size:12px; line-height:40px;\">\r\n");
      out.write("						<span class=\"fw-bold\" style=\"font-size:16px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${article.awriter}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("						<span>님의 게시글 더보기 ></span>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"clearfix mt-3\">\r\n");
      out.write("				<div class=\"float-start\">\r\n");
      out.write("					<span id=\"heartWrapper\" class=\"me-3\">\r\n");
      out.write("						<i id=\"heartIcon\" class=\"far fa-heart\" style=\"color:red;\"></i>\r\n");
      out.write("						<!-- <i class=\"fas fa-heart\"></i> -->\r\n");
      out.write("						<span style=\"font-size:12px;\">좋아요</span> \r\n");
      out.write("						<span id=\"heartCount\" style=\"font-size:14px; font-weight:bold;\">0</span>\r\n");
      out.write("					</span>\r\n");
      out.write("					<span>\r\n");
      out.write("						<i class=\"far fa-comment-dots position-relative\">\r\n");
      out.write("						  <span class=\"position-absolute top-0 start-100 translate-middle p-1 bg-danger border border-light rounded-circle\">\r\n");
      out.write("						    <span class=\"visually-hidden\">New alerts</span>\r\n");
      out.write("						  </span>\r\n");
      out.write("						</i>\r\n");
      out.write("						<span style=\"font-size:12px;\">댓글</span> \r\n");
      out.write("						<span style=\"font-size:14px; font-weight:bold;\">17</span>\r\n");
      out.write("					</span>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"float-end\">\r\n");
      out.write("					<span>\r\n");
      out.write("						<i class=\"far fa-share-square\"></i>\r\n");
      out.write("						<span style=\"font-size:13px;\">공유</span>\r\n");
      out.write("					</span>\r\n");
      out.write("					<span class=\"report-span\" style=\"font-size:13px;\">신고</span>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<hr>\r\n");
      out.write("	\r\n");
      out.write("			<!-- 텍스트아레나 -->\r\n");
      out.write("			<div class=\"fw-bold fs-5\">댓글</div>\r\n");
      out.write("\r\n");
      out.write("			<div class=\"mt-3 p-3\" style=\"border:1px solid gray; border-radius:5px; background:white;\">\r\n");
      out.write("				<div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member.mid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("				<div class=\"mt-2\">\r\n");
      out.write("					<textarea class=\"comment_inbox_text\" placeholder=\"댓글을 남겨보세요\" rows=\"2\" style=\"width:100%; overflow:hidden; overflow-wrap: break-word; height:36px;\"></textarea>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"clearfix\">\r\n");
      out.write("					<div class=\"float-start\">\r\n");
      out.write("						<span class=\"me-2 fs-5\"><i class=\"fas fa-camera\"></i></span>\r\n");
      out.write("						<span class=\"fs-5\"><i class=\"far fa-smile\"></i></span>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"float-end\">\r\n");
      out.write("						<div class=\"btn btn-success btn-sm\">등록</span>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<!-- /텍스트아레나 -->\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<!-- 카드 -->\r\n");
      out.write("		<div class=\"card mt-4\" style=\"box-shadow:none !important; background:transparent;\">\r\n");
      out.write("		  <div class=\"card-body p-4\">\r\n");
      out.write("			<div class=\"row\">\r\n");
      out.write("			  <div>\r\n");
      out.write("				<!-- 댓글 -->\r\n");
      out.write("				<div>\r\n");
      out.write("					<div class=\"d-flex flex-start mt-2\" style=\"border-bottom:1px solid #E1E1E1; \">\r\n");
      out.write("					  <a class=\"me-3\" href=\"#\">\r\n");
      out.write("						<img\r\n");
      out.write("						  class=\"rounded-circle shadow-1-strong\"\r\n");
      out.write("						  src=\"https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp\"\r\n");
      out.write("						  alt=\"avatar\"\r\n");
      out.write("						  width=\"36\"\r\n");
      out.write("						  height=\"36\"\r\n");
      out.write("						/>\r\n");
      out.write("					  </a>\r\n");
      out.write("					  <div style=\"margin-bottom:-7px; width:100%;\">\r\n");
      out.write("						<div>\r\n");
      out.write("						  <div class=\"d-flex justify-content-between align-items-center\">\r\n");
      out.write("							<p class=\"mb-1 fw-bold\" style=\"font-size:14px;\">\r\n");
      out.write("							  Anchovy\r\n");
      out.write("							</p>\r\n");
      out.write("						  </div>\r\n");
      out.write("						  <p class=\"small mb-0\">\r\n");
      out.write("							아니 다들 모여있었냐고 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ\r\n");
      out.write("						  </p>\r\n");
      out.write("						  <p>\r\n");
      out.write("							<span class=\"text-muted me-1\" style=\"font-size:12px;\">2022.01.29. 02:39</span>\r\n");
      out.write("							<span class=\"text-muted\" style=\"font-size:12px;\">답글쓰기</span>\r\n");
      out.write("						  </p>\r\n");
      out.write("						</div>\r\n");
      out.write("					  </div>\r\n");
      out.write("					  <div class=\"flex-grow-1 flex-shrink-1\">\r\n");
      out.write("					  	<i class=\"fas fa-ellipsis-v\" style=\"color:#b2b2b2; font-size:16px;\"></i>\r\n");
      out.write("					  </div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!-- /댓글 -->\r\n");
      out.write("			\r\n");
      out.write("				<!-- 대댓글 -->\r\n");
      out.write("				<div>\r\n");
      out.write("					<div class=\"d-flex flex-start mt-3\" style=\"margin-left:50px; border-bottom:1px solid #E1E1E1;\">\r\n");
      out.write("					  <a class=\"me-3\" href=\"#\">\r\n");
      out.write("						<img\r\n");
      out.write("						  class=\"rounded-circle shadow-1-strong\"\r\n");
      out.write("						  src=\"https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp\"\r\n");
      out.write("						  alt=\"avatar\"\r\n");
      out.write("						  width=\"36\"\r\n");
      out.write("						  height=\"36\"\r\n");
      out.write("						/>\r\n");
      out.write("					  </a>\r\n");
      out.write("					  <div style=\"margin-bottom:-7px; width:100%;\">\r\n");
      out.write("						<div>\r\n");
      out.write("						  <div class=\"d-flex justify-content-between align-items-center\">\r\n");
      out.write("							<p class=\"mb-1 fw-bold\" style=\"font-size:14px;\">\r\n");
      out.write("							  Anchovy\r\n");
      out.write("							</p>\r\n");
      out.write("						  </div>\r\n");
      out.write("						  <p class=\"small mb-0\">\r\n");
      out.write("							아니 다들 모여있었냐고 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ\r\n");
      out.write("						  </p>\r\n");
      out.write("						  <p>\r\n");
      out.write("							<span class=\"text-muted me-1\" style=\"font-size:12px;\">2022.01.29. 02:39</span>\r\n");
      out.write("							<span class=\"text-muted\" style=\"font-size:12px;\">답글쓰기</span>\r\n");
      out.write("						  </p>\r\n");
      out.write("						</div>\r\n");
      out.write("					  </div>\r\n");
      out.write("					  <div class=\"flex-grow-1 flex-shrink-1\">\r\n");
      out.write("					  	<i class=\"fas fa-ellipsis-v\" style=\"color:#b2b2b2; font-size:16px;\"></i>\r\n");
      out.write("					  </div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!-- /대댓글 -->\r\n");
      out.write("\r\n");
      out.write("				<!-- 대댓글 -->\r\n");
      out.write("				<div>\r\n");
      out.write("					<div class=\"d-flex flex-start mt-3\" style=\"margin-left:50px; border-bottom:1px solid #E1E1E1;\">\r\n");
      out.write("					  <a class=\"me-3\" href=\"#\">\r\n");
      out.write("						<img\r\n");
      out.write("						  class=\"rounded-circle shadow-1-strong\"\r\n");
      out.write("						  src=\"https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp\"\r\n");
      out.write("						  alt=\"avatar\"\r\n");
      out.write("						  width=\"36\"\r\n");
      out.write("						  height=\"36\"\r\n");
      out.write("						/>\r\n");
      out.write("					  </a>\r\n");
      out.write("					  <div style=\"margin-bottom:-7px; width:100%;\">\r\n");
      out.write("						<div>\r\n");
      out.write("						  <div class=\"d-flex justify-content-between align-items-center\">\r\n");
      out.write("							<p class=\"mb-1 fw-bold\" style=\"font-size:14px;\">\r\n");
      out.write("							  Anchovy\r\n");
      out.write("							</p>\r\n");
      out.write("						  </div>\r\n");
      out.write("						  <p class=\"small mb-0\">\r\n");
      out.write("							아니 다들 모여있었냐고 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ\r\n");
      out.write("						  </p>\r\n");
      out.write("						  <p>\r\n");
      out.write("							<span class=\"text-muted me-1\" style=\"font-size:12px;\">2022.01.29. 02:39</span>\r\n");
      out.write("							<span class=\"text-muted\" style=\"font-size:12px;\">답글쓰기</span>\r\n");
      out.write("						  </p>\r\n");
      out.write("						</div>\r\n");
      out.write("					  </div>\r\n");
      out.write("					  <div class=\"flex-grow-1 flex-shrink-1\">\r\n");
      out.write("					  	<i class=\"fas fa-ellipsis-v\" style=\"color:#b2b2b2; font-size:16px;\"></i>\r\n");
      out.write("					  </div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<!-- /대댓글 -->\r\n");
      out.write("\r\n");
      out.write("				<!-- 페이지네이션 -->\r\n");
      out.write("				<nav class=\"mt-4\" aria-label=\"Page navigation example\">\r\n");
      out.write("				  <ul class=\"pagination pagination-sm justify-content-center\">\r\n");
      out.write("					<li class=\"page-item ms-1 me-1\">\r\n");
      out.write("					  <a class=\"page-link\" href=\"#\" aria-label=\"Previous\">\r\n");
      out.write("						<span aria-hidden=\"true\">&laquo; 이전</span>\r\n");
      out.write("					  </a>\r\n");
      out.write("					</li>\r\n");
      out.write("					<li class=\"page-item ms-1 me-1\"><a class=\"page-link\" href=\"#\">1</a></li>\r\n");
      out.write("					<li class=\"page-item ms-1 me-1\"><a class=\"page-link\" href=\"#\">2</a></li>\r\n");
      out.write("					<li class=\"page-item ms-1 me-1\"><a class=\"page-link\" href=\"#\">3</a></li>\r\n");
      out.write("					<li class=\"page-item ms-1 me-1\">\r\n");
      out.write("					  <a class=\"page-link\" href=\"#\" aria-label=\"Next\">\r\n");
      out.write("						<span aria-hidden=\"true\">다음 &raquo;</span>\r\n");
      out.write("					  </a>\r\n");
      out.write("					</li>\r\n");
      out.write("				  </ul>\r\n");
      out.write("				</nav>\r\n");
      out.write("				<!-- /페이지네이션 -->\r\n");
      out.write("\r\n");
      out.write("			  </div>\r\n");
      out.write("			</div>\r\n");
      out.write("		  </div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<!-- /카드 -->\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"clearfix mt-2\">\r\n");
      out.write("		<div class=\"float-start\">\r\n");
      out.write("			<a href=\"/article/write\" class=\"btn btn-success btn-sm\">\r\n");
      out.write("				<i class=\"fas fa-pen\"></i>\r\n");
      out.write("				<span>글쓰기</span>\r\n");
      out.write("			</a>\r\n");
      out.write("			<div class=\"btn btn-sm fw-bold\" style=\"background:#e6e6e6;\">답글</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"float-end\">\r\n");
      out.write("			<div class=\"btn btn-sm fw-bold\" style=\"background:#e6e6e6;\">목록</div>\r\n");
      out.write("			<div id=\"topBtn\" class=\"btn btn-sm fw-bold\" style=\"background:#e6e6e6;\"><i class=\"fas fa-caret-up\"></i> &nbsp; TOP</div>			\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("</main><!-- End #main -->\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fimport_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005fimport_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    boolean _jspx_th_c_005fimport_005f0_reused = false;
    try {
      _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fimport_005f0.setParent(null);
      // /WEB-INF/views/article/articleView.jsp(103,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fimport_005f0.setUrl("/header");
      int[] _jspx_push_body_count_c_005fimport_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fimport_005f0 = _jspx_th_c_005fimport_005f0.doStartTag();
        if (_jspx_th_c_005fimport_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fimport_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fimport_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fimport_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f0);
      _jspx_th_c_005fimport_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fimport_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fimport_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fimport_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f1 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    boolean _jspx_th_c_005fimport_005f1_reused = false;
    try {
      _jspx_th_c_005fimport_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fimport_005f1.setParent(null);
      // /WEB-INF/views/article/articleView.jsp(104,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fimport_005f1.setUrl("/sidebar");
      int[] _jspx_push_body_count_c_005fimport_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fimport_005f1 = _jspx_th_c_005fimport_005f1.doStartTag();
        if (_jspx_th_c_005fimport_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fimport_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fimport_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fimport_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f1);
      _jspx_th_c_005fimport_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fimport_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fimport_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fimport_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f2 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    boolean _jspx_th_c_005fimport_005f2_reused = false;
    try {
      _jspx_th_c_005fimport_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fimport_005f2.setParent(null);
      // /WEB-INF/views/article/articleView.jsp(371,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fimport_005f2.setUrl("/footer");
      int[] _jspx_push_body_count_c_005fimport_005f2 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fimport_005f2 = _jspx_th_c_005fimport_005f2.doStartTag();
        if (_jspx_th_c_005fimport_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fimport_005f2[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fimport_005f2.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fimport_005f2.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f2);
      _jspx_th_c_005fimport_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fimport_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fimport_005f2_reused);
    }
    return false;
  }
}
