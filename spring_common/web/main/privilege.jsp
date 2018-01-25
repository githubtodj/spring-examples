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
<script src="ui/jquery.min.js" type="text/javascript"></script>
<script src="ui/jquery.easyui.min.js" type="text/javascript"></script>
<script type="text/javascript">
	var url='CustomerAction!addCustomer.action';
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
    
	$(function() {
		loadingGrid();
	});
	function loadingGrid() {
		$("#datagrid")
				.datagrid(
						{
							title : "驾驶员客户信息",
							striped : true,//是否显示斑马线效果
							singleSelect : true,//是否只允许选择一行
							url : 'CustomerAction!findPage.action',
							//queryParams:{},
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
								field : 'username',
								align : 'center',
								title : '用户名',
								width : 80
							}, {
								field : 'sex',
								align : 'center',
								title : '性别',
								width : 80
							}, {
								field : 'phone',
								align : 'center',
								title : '电话号码',
								width : 80
							}, {
								field : 'email',
								align : 'center',
								title : '邮箱',
								width : 80
							},
							{
							    field:'opt',
							    align:'center',
							    title:'操作',
							    width:80,  
                                formatter:function(value,rec,index){  
			                        var s = '<a href="javascript:void(0)" mce_href="#" onclick="view(\''+ index + '\')">查看</a> ';  
			                        var e = '<a href="javascript:void(0)" mce_href="#" onclick="edit(\''+ index + '\')">编辑</a> ';  
			                        var d = '<a href="javascript:void(0)" mce_href="#" onclick="deleteCust(\''+ index +'\')">删除</a> ';  
                        			return s+e+d;  
                    			}  
                  			}  
							]],
							toolbar : [ {
								text : "添加驾驶员",
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
									edituser();
								}
							},{
								text : "删除",
								iconCls : "icon-remove",
								handler : function() {
									console.log("删除激活");
									deleteCust();
								}
							}]
						});

	}
	function openDialogAdd() {
	    url='CustomerAction!addCust.action';
		$('#dlg').dialog({
			title : '添加用户',
			width : 400,
			height : 200,
			closed : false,
			cache : false,
			modal : true
		});
	}
	
	 function edituser() {
            var row = $("#datagrid").datagrid("getSelected");
            if (row) {
                $("#dlg").dialog("open").dialog('setTitle', '修改信息');
                $("#frm").form("load", {
                	'customer.id':row.id,
                	'customer.cusName':row.cusName,
                	'customer.cusLicenseLevel':row.cusLicenseLevel,
                	'customer.cusLicenseNo':row.cusLicenseNo,
                	'customer.year':row.year
                });
                url = "CustomerAction!updateCust.action";
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
								$("input[name^='customer.']").val("");
								$("select").val("请选择");
								//重载datagrid
								$('#datagrid').datagrid('reload');
							}
						});
	}
	
	function deleteCust(index){
		$.messager.confirm('确认','确认删除?',function(row){  
             if(row){  
             	var row = $("#datagrid").datagrid("getSelected");
				var delId=row.id;
                 $.ajax({  
                     url:'CustomerAction!deleteCust.action',    
                     type:"post",//提交方式
					 data:{ //请求参数 
						 'customer.id':delId
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
			<div id="dlg" class="easyui-dialog" title="添加用户信息"
				style="width:400px;height:200px;"
				data-options="iconCls:'icon-save',resizable:true,modal:true,novalidate:true,closed:true">
				<form id="frm" class="easyui-form" method="post">
					<input type="hidden" name="customer.id">
					<table>
						<tr>
							<td>用户名：</td>
							<td><input class="easyui-textbox" name="username" data-options="required:true"
								type="text" />
							</td>
						</tr>
						<tr>
							<td>性别：</td>
							<td>
							<input class="easyui-textbox" name="sex" data-options="required:true"
								type="text" />
							</td>
						</tr>
						<tr>
							<td>电话号码：</td>
							<td><input class="easyui-textbox" name="phone" data-options="required:true"
								type="text"/>
							</td>
						</tr>
						<tr>
							<td>邮箱：</td>
							<td><input class="easyui-textbox" name="email" data-options="required:true"
								type="text"/>
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
			</div>
</body>
</html>
