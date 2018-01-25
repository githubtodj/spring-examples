<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="ui/themes/default/easyui.css"
	type="text/css">
<link rel="stylesheet" href="ui/themes/color.css" type="text/css">
<link rel="stylesheet" href="ui/themes/icon.css" type="text/css"></link>

<link rel="stylesheet" href="ztree/css/demo.css" type="text/css">
<link rel="stylesheet" href="ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script src="ui/jquery.min.js" type="text/javascript"></script>
<script src="ui/jquery.easyui.min.js" type="text/javascript"></script>
<script type="text/javascript" src="ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="ztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript">
	var url='RoleAction!addrole.action';
	<!-- ztree -->
	/**
     * 扩展combox验证，easyui原始只验证select text的值，不支持value验证
     */
    $.extend($.fn.validatebox.defaults.rules, {
        selectValueRequired: {
            validator: function(value,param){
                console.info($(param[0]).find("option:contains('"+value+"')").val());
                return $(param[0]).find("option:contains('"+value+"')").val() != '';
            },
            message: '必选项'
        }
    });
    var setting = {
			check: {
				enable: true,
				chkboxType: {"Y":"", "N":""}
			},
			view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onCheck: onCheck
			}
		};
    function beforeClick(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("privilegeTree");
			zTree.checkNode(treeNode, !treeNode.checked, null, true);
			return false;
		}
		
		function onCheck(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("privilegeTree"),
			nodes = zTree.getCheckedNodes(true),
			v = "";
			for (var i=0, l=nodes.length; i<l; i++) {
				v += nodes[i].name + ",";
			}
			if (v.length > 0 ) v = v.substring(0, v.length-1);
			var privilegeSelObj = $("#privilegeSel");
			privilegeSelObj.attr("value", v);
		}

		function showMenu() {
			var privilegeSelObj = $("#privilegeSel");
			var privilegeSelOffset = $("#privilegeSel").offset();
			// $("#menuContent").css({left:privilegeSelOffset.left + "px", top:privilegeSelOffset.top + privilegeSelObj.outerHeight() + "px"}).slideDown("fast");
			$("#menuContent").css({left:"50px", top:"100px"}).slideDown("fast");
			$("body").bind("mousedown", onBodyDown);
		}
		function hideMenu() {
			$("#menuContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "privilegeSel" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}
    
	$(function() {
		// 加载权限树
		$.ajax({
				url:"RoleController/findPrivilegeTree",//url
				type:"post",//提交方式
				data:{ //请求参数 
				},
				success:function(zNodes){
					$.fn.zTree.init($("#privilegeTree"), setting, zNodes);
				}
		});
		//easyui
		loadingGrid();
		
	});
	function loadingGrid() {
		$("#datagrid")
				.datagrid(
						{
							title : "角色管理",
							striped : true,//是否显示斑马线效果
							singleSelect : true,//是否只允许选择一行
							url : 'RoleController/findPage',
							loadMsg : '数据加载中请稍后……',//在从远程站点加载数据的时候显示提示消息
							pagination : true,//如果为true,则在DataGrid控件底部显示分页工具栏
							rownumbers : true,//如果为true，则显示一个行号列。
							fit : true,//自动撑满表格
							fitColumns : true,//列自动撑满表格
							pageList : [ 5, 10, 15, 20, 30 ],
							pageSize : 5,
// 							frozenColumns:[[
//                  				{field:'id',checkbox:true}
//     						]],
							columns : [ [ {
								field : 'name',
								align : 'center',
								title : '角色名称',
								width : 80
							}, {
								field : 'description',
								align : 'center',
								title : '角色描述',
								width : 80
							},
							{
							    field:'opt',
							    align:'center',
							    title:'操作',
							    width:80,  
                                formatter:function(value,rec,index){  
			                        var s = '<a href="javascript:void(0)" mce_href="#" onclick="view(\''+ index + '\')">查看</a> ';  
			                        var e = '<a href="javascript:void(0)" mce_href="#" onclick="view(\''+ index + '\')">编辑</a> ';  
			                        var d = '<a href="javascript:void(0)" mce_href="#" onclick="deleteCust(\''+ index +'\')">删除</a> ';  
                        			return s+e+d;  
                    			}  
                  			}  
							]],
							toolbar : [ {
								text : "添加角色",
								iconCls : "icon-add",
								handler : function() {
									console.log("添加按钮激活");
									openDialogAdd();
								}
							},{
								text : "编辑",
								iconCls : "icon-edit",
								handler : function() {
									console.log("编辑激活");
									editRole();
								}
							},{
								text : "删除",
								iconCls : "icon-remove",
								handler : function() {
									console.log("删除激活");
									deleteRole();
								}
							}]
						});

	}
	function openDialogAdd() {
	    url='RoleController/addRole';
		$('#dlg').dialog({
			title : '添加角色',
			width : 400,
			height : 200,
			closed : false,
			cache : false,
			modal : true
		});
	}
	
	 function editRole() {
            var row = $("#datagrid").datagrid("getSelected");
            if (row) {
                $("#dlg").dialog("open").dialog('setTitle', '修改信息');
                $("#frm").form("load", {
                	'role.id':row.id,
                	'role.name':row.name,
                	'role.description':row.description,
                });
                url = "RoleAction!updateRole.action";
            }
			
        }
        
	function saveCust() {
		$('#frm').form('submit',
						{
							url : url,
							onSubmit : function() {
								return $(this).form('enableValidation').form(
										'validate');//对form表单数据进行校验 
							},
							success : function(data) {
								var jsondata = $.parseJSON(data);
								$.messager.alert('提示', jsondata.message);
								$('#dlg').dialog("close");
								// 清空所有以cust.开头的input value值
								$("input[name^='role.']").val("");
								$("select").val("请选择");
								//重载datagrid
								$('#datagrid').datagrid('reload');
							}
						});
	}
	
	function deleteRole(index){
		$.messager.confirm('确认','确认删除?',function(row){  
             if(row){  
             	var row = $("#datagrid").datagrid("getSelected");
				var delId=row.id;
                 $.ajax({  
                     url:'RoleController/deleteRole',    
                     type:"post",//提交方式
					 data:{ //请求参数 
						 'role.id':delId
					 },
					 dataType : "json",
                     success:function(data){
						$.messager.alert('提示', data.message);
					}  
                 });  
//                  $('#datagrid').datagrid('clearSelections'); 
//                  $('#datagrid').datagrid('deleteRow',index); 
				 $('#datagrid').datagrid('reload'); 
             }  
       })  
	}
	function clearForm() {
		$('#frm').form('clear');
	}
</script>
</head>

<body>
		<table id="datagrid"></table>
			<div id="dlg" class="easyui-dialog" title="添加角色信息"
				style="width:400px;height:600px;"
				data-options="iconCls:'icon-save',resizable:true,modal:true,novalidate:true,closed:true">
				<form id="frm" class="easyui-form" method="post">
					<input type="hidden" name="role.id">
					<table>
						<tr>
							<td>角色：</td>
							<td><input class="easyui-textbox" name="role.name" data-options="required:true"
								type="text" />
							</td>
						</tr>
						<tr>
							<td>描述：</td>
							<td>
							<input class="easyui-textbox" name="role.description" data-options="required:true"
								type="text" />
							</td>
						</tr>
						<tr>
							<td>权限：</td>
							<td><input  name="role.privilegeIds" id="privilegeSel" 
								type="text" style="width:120px;" onclick="showMenu();"/>
								<input id="privilegeSel1" type="text" readonly value="" style="width:120px;" onclick="showMenu();" />
								&nbsp;<a id="menuBtn" href="#" onclick="showMenu(); return false;">select</a>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<div style="text-align:center;padding:5px">
									<a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveCust()">保存</a>
									<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
								</div>
							</td>
						</tr>
					</table>
				</form>
				<div id="menuContent" class="menuContent" style="display:none; position: absolute;scrolling:yes">
	           		<ul id="privilegeTree" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
				</div>
			</div>
			
</body>
</html>
