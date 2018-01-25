http://blog.csdn.net/canot/article/details/50645039
需求,其中涉及到了三个主体: 
1.用户user(该部门的所有用户) 
2.角色Role(普通员工or部门负责人) 
3.权限Privilege(关于对该部分CURD的权限)

关于这三个主体之间的对应关系，大家自己模拟一下(在实际项目中我们以实际的项目为准):

User与Role是多对多 Role与Privilege是多对多

easyui tree
https://www.cnblogs.com/20gg-com/p/6206502.html


<h2>功能菜单</h2>
  	<hr>
  	<h3>
  		<ul>
  			<li><a href="LoginAction!addDept">添加部门</a></li>
  			<li><a href="LoginAction!detailDept">查看部门</a></li>
  			<li><a href="">删除部门</a></li>
  			<li><a href="">修改部门</a></li>
  			
  			<li><a href="">添加员工</a></li>
  			<li><a href="">修改员工</a></li>
  			<li><a href="">删除员工</a></li>
  			<li><a href="">查看员工</a></li>
  		</ul>
  	</h3>
  	<hr>