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
	<script type="text/javascript" src="js/jquery.1.11.3.min.js"></script>
  	<script type="text/javascript" src="ztree/js/jquery.ztree.all.min.js"></script>
	<script type="text/javascript">
		var goAsync=true;
		var setting = {
            view: {
                showLine: false,
                addDiyDom: addDiyDom
            },
            async: {
                enable: true,
                autoParam: ["id"],
                url: "MenuController/loadMenuTree",
                dataFilter: filter
            },
            check: {
                enable: true,
//                 chkboxType: {"Y":"s", "N":"ps"}
				chkboxType: {"Y":"", "N":""}
            },
            callback: {
                onAsyncSuccess: zTreeOnAsyncSuccess,
                onClick: zTreeOnClick
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };
	    $(document).ready(function(){
	        $.fn.zTree.init($("#treeDemo"), setting);
	    });
	
		function zTreeOnClick(event, treeId, treeNode) {
			window.open(treeNode.localUrl,"contentIframe");
		};

	    var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	    
	    function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
		    if(treeNode==null){
		        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		        nodes = zTree.getNodes();
		        for (var i=0, l=nodes.length; i<l; i++) {
		            zTree.expandNode(nodes[i], true, false, false);
		        }
		        asyncNodes(zTree.getNodes());
		         if (!goAsync) {
		            curStatus = "";
		         }
		    }
		}

		function asyncNodes(nodes) {
		        if (!nodes) return;
		        curStatus = "async";
		        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		        for (var i=0, l=nodes.length; i<l; i++) {
		            if (nodes[i].isParent && nodes[i].zAsync) {
		                asyncNodes(nodes[i].children);
		            } else {
		                goAsync = true;
		                zTree.reAsyncChildNodes(nodes[i], "refresh", true);
		            }
		        }
		}
		
		function filter(treeId, parentNode, childNodes) {
		            if (!childNodes) return null;
		            for (var i=0, l=childNodes.length; i<l; i++) {
		            	childNodes[i].nocheck =true;
		                childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
		            }
		            return childNodes;
		        }
		
		function addDiyDom(treeId,treeNode) {
		    var aObj = $("#" + treeNode.tId + "_a");
		    if ($("#diyBtn_"+treeNode.id).length>0) return;
		    switch (treeNode.state) {
		        case 0:
		            var editStr = "<span id='diyBtn_space_" +treeNode.id+ "' style='color:red;padding-left:5px;'>未审核</span>";
		            break;
		        case 1:
		            var editStr = "<span id='diyBtn_space_" +treeNode.id+ "' style='color:#6495ED;padding-left:5px;'>正常</span>";
		            break;
		        case 2:
		            var editStr = "<span id='diyBtn_space_" +treeNode.id+ "' style='color:#CD2626;padding-left:5px;'>锁定</span>";
		            break;
		        default:
		            var editStr = "<span id='diyBtn_space_" +treeNode.id+ "' style='padding-left:5px;'>未知状态</span>";
		            break;
		        }
		    aObj.append(editStr);
		}
	</script>
  </head>
  
  <body>
	<TABLE border=0 width="100%" align=left>
		<TR>
			<TD  align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
				<ul id="treeDemo" class="ztree" style="width:100%; overflow:auto;"></ul>
			</TD>
		</TR>
	</TABLE>
  </body>
</html>
