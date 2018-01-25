<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'ztree.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
<!-- 	<script type="text/javascript" src="ztree/js/jquery-1.4.4.min.js"></script> -->
	<script type="text/javascript" src="js/jquery.1.11.3.min.js"></script>
  	<script type="text/javascript" src="ztree/js/jquery.ztree.all.min.js"></script>
  	<script type="text/javascript">
//   		var zNodes = ${listTree};
	    $(function(){
	    	var setting = {
	            check: {
	                enable: true,
	                chkboxType: {"Y":"s", "N":"ps"}
	            },
	            data: {
	                simpleData: {
	                    enable: true
	                }
	            }
	        };
   			$.ajax({
				url:"ZTreeAction!showTree",//url
				type:"post",//提交方式
				data:{ //请求参数 
				},
				success:function(zNodes){
// 					alert(zNodes);
// 					zNodes = zNodes.replace(/"(\w+)":/g, "$1:");
// 					alert(zNodes);
// 					zNodes=[{icon:"../img/add.png",iconClose:"../img/iconClose.png",iconOpen:"../img/iconOpen.png",id:0,"isParent":true,name:"顶层节点 "}];
// 					var zNodes =[
// 			{ id:1, pId:0, name:"主菜单 1"},
// 			{ id:2, pId:1, name:"子菜单 1-1"},
// 			{ id:3, pId:2, name:"叶子节点 1-1-1"},
// 			{ id:4, pId:2, name:"叶子节点 1-1-2"},
// 			{ id:5, pId:2, name:"叶子节点 1-1-3"},
// 			{ id:6, pId:2, name:"叶子节点 1-1-4"},
// 			{ id:7, pId:1, name:"子菜单 1-2"},
// 			{ id:8, pId:7, name:"叶子节点 1-2-1"},
// 			{ id:9, pId:7, name:"叶子节点 1-2-2"},
// 			{ id:10, pId:7, name:"叶子节点 1-2-3"},
// 			{ id:11, pId:7, name:"叶子节点 1-2-4"},
// 			{ id:12, pId:0, name:"主菜单 2"},
// 			{ id:13, pId:12, name:"子菜单 2-1"},
// 			{ id:211, pId:13, name:"叶子节点 2-1-1"},
// 			{ id:212, pId:13, name:"叶子节点 2-1-2"},
// 			{ id:213, pId:13, name:"叶子节点 2-1-3"},
// 			{ id:214, pId:13, name:"叶子节点 2-1-4"},
// 		];
					$.fn.zTree.init($("#treeDemo"),setting,zNodes);
				}
			});
	    });
  	</script>
  </head>
  
  <body>
  		<div class="zTreeDemoBackground left">
        	<ul id="treeDemo" class="ztree"></ul>
		</div>
  </body>
</html>
