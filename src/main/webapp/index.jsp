<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>人力资源管理系统</title>

	<script type="text/javascript">
		function resetValue() {
			document.getElementById("username").value="";
			document.getElementById("password").value="";
		}
	</script>

	<style type="text/css">
		body{
			font-size:12px;
			margin: 0;
			padding: 0;
			width: 100%
		}
		
		#main{
			background: url("images/login.jpg") no-repeat;
			background-position: center;
			background-attachment: fixed;
			width: 1200px;
			height: 650px;
			margin: 0 auto;
			position: relative;
		}
		
		form{
			margin: 0 auto;
			position: absolute;
			left: 360px;
			top:410px;
		}
		
		.inp{
			width: 110px;
		}
		.text{
			color:#000;
		}
	</style>

</head>

<body>
	<div id="main">
		<form action="main.jsp" method="post">
			<table id="input">
				<tr>
					<td class="text">用户名：</td>
					<td><input type="text" value="" class="inp" name="username" id="username"/></td>
					<td class="text">密    码：</td>
					<td><input type="password" value="" class="inp" name="password" id="password"/></td>
					<td><input type="submit" value="登录"></td>
					<td><input type="button" value="重置" onclick="resetValue()"></td>					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
