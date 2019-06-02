<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>人力资源管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/icon.css">
	<link rel="stylesheet" type="text/css" href="css/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	
	<script type="text/javascript">
		// 对资源进行初始化
		$(function(){
			// 1、构造一个填充了JSON格式数据模型的tree
			var treeData = [{
								text:"服务外包人力资源管理系统",
								children:[{
												text:"部门管理",
												attributes:{url:"dept.jsp"}
								},{
												text:"员工管理",
												attributes:{url:"employee.jsp"}	
								},{
												text:"管理员管理",
												attributes:{url:"employee.jsp"}										
								}]
			}];
			// 2、绑定数据到tree组件上tree(json数据对象{},data:要绑定的变量,lines:是否有连线，onClick:指定点击事件)
			$("#tree").tree({
				data:treeData,
				lines:true,
				// node代表children数组的一个节点
				onClick:function(node){
					if (node.attributes){
						openTab(node.text,node.attributes.url);
					}
				}
			});
		});
		
		// 点击连接时做的具体打开标签动作
		function openTab(text,url){
			// tabs('exists',text)返回布尔类型,在容器中存在该标签，返回true
			if ($("#tabs").tabs('exists',text)){
				$("#tabs").tabs('select',text);
			}
			else{
				var content = "<iframe frameborder='0' border='0' scrolling='auto' marginwidth='0' style='width:100%;height:100%' src="+url+"></iframe>";
				$("#tabs").tabs('add',{
					title:text,
					closable:true,
					content:content,
					border:false
				});
			}
		}
	</script>
	
</head>
<body class="easyui-layout">
	    <div data-options="region:'north'" style="height:102px;background-color:#F9F7F8">
        	<img alt="" src="images/main.jpg" style="height:98px;width:700px;float:left;"  >
        	<div style="margin:60px 50px 20px;float:right;">当前登录用户：&nbsp;<font color="red">${currentUser.userName }</font></div>
        </div>
		<div data-options="region:'south'" style="height:30px;padding:5px;" align="center"  >版权所有&nbsp;&nbsp;<a href="http://www.cissst.com">www.cissst.com</a></div>
		<div data-options="region:'west',split:true" title="功能菜单" style="width:13%;">
			<ul class="easyui-tree" id="tree"></ul>
		</div>
		<div data-options="region:'center'">
			<div id="tabs" class="easyui-tabs" style="width:100%;heigth:100%" data-options="border:false,fit:true">
				<div title="首页" style="padding: 10px">
					<div align="center" style="padding-top:100px"><font color="red" size="7">欢迎使用服务外包公司人力资源管理系统</font></div>
				</div>
			</div>
		</div>

</body>
</html>