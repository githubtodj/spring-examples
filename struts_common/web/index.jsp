<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" href="ui/themes/default/easyui.css" type="text/css"></link>
  <link rel="stylesheet" href="ui/themes/icon.css" type="text/css"></link>
  <script type="text/javascript" src="ui/jquery.min.js"></script>
  <script type="text/javascript" src="ui/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="ui/locale/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript">
  	$(function(){
  		$("#fun").tree({
  			url:"TreeAction!showTree",
  			loadFilter:function(data){
  				if(data.text){
  					return data.text;
  				}else{
  					return data;
  				}
  			}
  		});
  	});
  </script>
  </head>
  
  <body>
  	<ul id="fun"></ul>
  </body>
</html>
