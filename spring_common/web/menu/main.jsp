<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'asyncZtree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
	<!-- bootstrap css begin -->
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css"></link>
  	<link rel="stylesheet" href="boot/dashboard.css">
  	<!-- bootstrap css end -->
	<script type="text/javascript" src="js/jquery.1.11.3.min.js"></script>
  	<script type="text/javascript" src="ztree/js/jquery.ztree.all.min.js"></script>
	<script type="text/javascript">
	</script>
  </head>
  
  <body>
<!--   		<div class="zTreeDemoBackground left"> -->
<!--         	<ul id="treeDemo" class="ztree"></ul> -->
<!-- 		</div> -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">网银后台管理系统</a>
        </div>
        <!-- 定义导航条部分 -->
        <div id="navbar" class="navbar-collapse collapse">
        	<ul class="nav navbar-nav navbar-right">
    			<li class="active"><a href="#">Home</a></li>
			    <li><a href="#">SVN</a></li>
			    <li><a href="#">iOS</a></li>
			    <li><a href="#">VB.Net</a></li>
			    <li class="dropdown">
			      <a class="dropdown-toggle" data-toggle="dropdown" href="#">
			        Java <span class="caret"></span>
			      </a>
		      <ul class="dropdown-menu">
		        <li><a href="#">Swing</a></li>
		        <li><a href="#">jMeter</a></li>
		        <li><a href="#">EJB</a></li>
		        <li class="divider"></li>
		        <li><a href="#">分离的链接</a></li>
		      </ul>
    			</li>
    			<li><a href="#">PHP</a></li>
  			</ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">控制面板</a></li>
            <li><a href="#">设置</a></li>
            <li><a href="#">概况</a></li>
            <li><a href="#">帮助</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="搜索...">
          </form>
        </div>
      </div>
    </nav>
	<TABLE border=0 height="100%" width="100%" align=left>
		<TR>
			<TD width=20% align=left valign=top>
				<IFRAME ID="treeIframe" Name="treeIframe" FRAMEBORDER=0  width=100%  height=100% src="<%=path%>/menu/menus.jsp">
				</IFRAME>
			</TD>
			<TD width=80% align=center valign=middle>
				<IFRAME ID="contentIframe" Name="contentIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=100%>
				</IFRAME>
			</TD>
		</TR>
	</TABLE>
  </body>
</html>
