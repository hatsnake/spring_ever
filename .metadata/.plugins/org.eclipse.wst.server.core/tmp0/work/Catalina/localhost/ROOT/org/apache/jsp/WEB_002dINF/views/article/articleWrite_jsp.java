/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.73
 * Generated at: 2022-02-12 08:18:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.article;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class articleWrite_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/SpringWeb/sts_work/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ever/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/SpringWeb/sts_work/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ever/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1642396012685L));
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("	<title>Document</title>\r\n");
      out.write("\r\n");
      out.write("	<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("	<script src=\"/summernote/js/summernote-lite.js\"></script>\r\n");
      out.write("	<script src=\"/summernote/js/lang/summernote-ko-KR.js\"></script>\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"/summernote/css/summernote-lite.css\">\r\n");
      out.write("	\r\n");
      out.write("	<link href=\"https://www.jqueryscript.net/css/jquerysctipttop.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("	<link href=\"/tagsinput/tagsinput.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\r\n");
      out.write("	<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/typeahead.js/0.11.1/typeahead.bundle.min.js\"></script>\r\n");
      out.write("	<script src=\"/tagsinput/tagsinput.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		$(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("			$(\"#writeBtn\").on(\"click\", function() {\r\n");
      out.write("				const count = $(\".hashtag\").length;\r\n");
      out.write("				let hashtagText = \"\";\r\n");
      out.write("				for(let i=0; i<count; i++) {\r\n");
      out.write("					hashtagText += $(\".hashtag\").get(i).textContent + \",\";\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("				$(\"#atag\").val(hashtagText.slice(0, -1));\r\n");
      out.write("				\r\n");
      out.write("				const writeForm = $(\"#writeForm\"); \r\n");
      out.write("				writeForm.attr(\"action\", \"/article/write\");\r\n");
      out.write("				writeForm.attr(\"method\", \"post\");\r\n");
      out.write("				writeForm.submit();\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			$('#summernote').summernote({\r\n");
      out.write("				  height: 300,                 // 에디터 높이\r\n");
      out.write("				  minHeight: null,             // 최소 높이\r\n");
      out.write("				  maxHeight: null,             // 최대 높이\r\n");
      out.write("				  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부\r\n");
      out.write("				  lang: \"ko-KR\",					// 한글 설정\r\n");
      out.write("				  placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정\r\n");
      out.write("				  toolbar: [\r\n");
      out.write("					    // [groupName, [list of button]]\r\n");
      out.write("					    ['fontname', ['fontname']],\r\n");
      out.write("					    ['fontsize', ['fontsize']],\r\n");
      out.write("					    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],\r\n");
      out.write("					    ['color', ['forecolor','color']],\r\n");
      out.write("					    ['table', ['table']],\r\n");
      out.write("					    ['para', ['ul', 'ol', 'paragraph']],\r\n");
      out.write("					    ['height', ['height']],\r\n");
      out.write("					    ['insert',['picture','link','video']],\r\n");
      out.write("					    ['view', ['fullscreen', 'help']]\r\n");
      out.write("					  ],\r\n");
      out.write("				fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],\r\n");
      out.write("				fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],\r\n");
      out.write("				disableResizeEditor: true\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			$(\".note-statusbar\").hide();\r\n");
      out.write("			\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		// 특수문자 입력 방지\r\n");
      out.write("		function characterCheck(obj){\r\n");
      out.write("		var regExp = /[ \\{\\}\\[\\]\\/?.,;:|\\)*~`!^\\-_+┼<>@#$%&\\'\\\"\\\\\\(\\=]/gi; \r\n");
      out.write("		// 허용할 특수문자는 여기서 삭제하면 됨\r\n");
      out.write("		// 지금은 띄어쓰기도 특수문자 처리됨 참고하셈\r\n");
      out.write("		if( regExp.test(obj.value) ){\r\n");
      out.write("			obj.value = obj.value.substring( 0 , obj.value.length - 1 ); // 입력한 특수문자 한자리 지움\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("	<style>\r\n");
      out.write("		.container { margin: 150px auto; }\r\n");
      out.write("		h2 { margin:20px auto; font-size:14px;}\r\n");
      out.write("		.badge { margin: 2px 3px !important; background: #ecf0f1 !important;}\r\n");
      out.write("		.test { font-size:12px; background:#ecf0f1 !important; border-radius:3px; padding:1px !important; margin:1px !important;}	\r\n");
      out.write("	</style>\r\n");
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
      out.write("<main id=\"main\" class=\"main\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\" style=\"margin: 50px auto;\">\r\n");
      out.write("	<div style=\"width:862px; margin:0 auto;\">\r\n");
      out.write("		<div class=\"clearfix\">\r\n");
      out.write("			<div class=\"float-start fw-bold fs-3\" style=\"line-height:40px;\">카페 글쓰기</div>\r\n");
      out.write("			<div id=\"writeBtn\" class=\"float-end btn btn-success\">등록</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<hr>\r\n");
      out.write("		<form id=\"writeForm\" name=\"writeForm\">\r\n");
      out.write("			<input type=\"hidden\" name=\"awriter\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member.mno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("			<input type=\"hidden\" name=\"ainsertid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member.mno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("			<!-- hashTag 값 -->\r\n");
      out.write("			<input type=\"hidden\" id=\"atag\" name=\"atag\">\r\n");
      out.write("			<div class=\"row mb-2\">\r\n");
      out.write("				<select class=\"form-select me-2\" name=\"acategoryno\" style=\"width:630px; margin-left:12px;\">\r\n");
      out.write("					<option value=\"1\" selected>1</option>\r\n");
      out.write("					<option value=\"2\">2</option>\r\n");
      out.write("					<option value=\"3\">3</option>\r\n");
      out.write("				</select>\r\n");
      out.write("				<select class=\"form-select\" name=\"acategorynoref\" style=\"width:224px;\">\r\n");
      out.write("					<option value=\"1\" selected>1</option>\r\n");
      out.write("					<option value=\"2\">2</option>\r\n");
      out.write("					<option value=\"3\">3</option>\r\n");
      out.write("				</select>\r\n");
      out.write("			</div>\r\n");
      out.write("			<input type=\"text\" class=\"form-control\" name=\"atitle\" id=\"atitle\" placeholder=\"제목을 입력해 주세요.\">\r\n");
      out.write("			<div class=\"mt-2\">\r\n");
      out.write("				<textarea id=\"summernote\" name=\"acontent\"></textarea>\r\n");
      out.write("				<div>\r\n");
      out.write("					<input type=\"text\" data-role=\"tagsinput\" value=\"\">\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</main>\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fimport_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("  var _gaq = _gaq || [];\r\n");
      out.write("  _gaq.push(['_setAccount', 'UA-36251023-1']);\r\n");
      out.write("  _gaq.push(['_setDomainName', 'jqueryscript.net']);\r\n");
      out.write("  _gaq.push(['_trackPageview']);\r\n");
      out.write("\r\n");
      out.write("  (function() {\r\n");
      out.write("    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;\r\n");
      out.write("    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\r\n");
      out.write("    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);\r\n");
      out.write("  })();\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
      // /WEB-INF/views/article/articleWrite.jsp(91,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
      // /WEB-INF/views/article/articleWrite.jsp(92,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
      // /WEB-INF/views/article/articleWrite.jsp(133,0) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
