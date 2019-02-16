<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
	String path = request.getContextPath();
	//协议://+IP:+端口号+/+工程名+/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>在线商城-后台管理系统</title>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>css/bootstrapValidator.min.css" />
<link rel="stylesheet" href="<%=basePath%>css/mycss.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrapValidator.min.js"></script>
<script src="<%=basePath %>layer/layer.js"></script>
<script type="text/javascript">
function refresh(){
	var t = new Date().getTime();
	 $("img[name='code']").attr("src","<%=basePath%>code/image?t="+t);
	 $("input[name='vcode']").val('');
}

$(function(){
	if (${!empty msg}) {
		layer.msg('${msg}',{
			time:2000
		});
	}
	$("#loginform").bootstrapValidator({
		feedbackIcons: {
		valid: 'glyphicon glyphicon-ok',
		invalid: 'glyphicon glyphicon-remove',
		validating: 'glyphicon glyphicon-refresh'
	},
	fields: { 
		loginName: {
			validators: {
				notEmpty: {
					message: '用户名不能为空',
				},
			},
		},
			password: {
				validators: {
					notEmpty: {
						message: '密码不能为空',
					},
				},
			},
			vcode: {
				validators: {
					noEmpty: {
						message: '验证码不能为空',
					},
					remote: {
						url:'<%=basePath%>code/checkCode',
						message: '验证码错误',
					}
				},
			},
		},
	});
});
    
</script>
</head>
<body>
	<!-- 使用自定义css样式 div-signin 完成元素居中-->
	<div class="container div-signin">
		<div class="panel panel-primary div-shadow">
			<!-- h3标签加载自定义样式，完成文字居中和上下间距调整 -->
			<div class="panel-heading">
				<h3>在线商城系统 3.0</h3>
				<span>ZSHOP Manager System</span>
			</div>
			<div class="panel-body">
				<!-- login form start -->
				<form action="<%=basePath %>manager/login" class="form-horizontal" method="post"
					id="loginform">
					<div class="form-group">
						<label class="col-sm-3 control-label">用户名：</label>
						<div class="col-sm-9">
							<input class="form-control" type="text" placeholder="请输入用户名" name="loginName">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
						<div class="col-sm-9">
							<input class="form-control" type="password" placeholder="请输入密码" name="password">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">验证码：</label>
						<div class="col-sm-4">
							<input class="form-control" type="text" placeholder="验证码" name="vcode">
						</div>
						<div class="col-sm-2">
							<!-- 验证码 -->
							<img class="img-rounded" name="code" src="<%=basePath %>code/image"
								style="height: 32px; width: 70px;" />
						</div>
						<div class="col-sm-2">
							<button type="button" class="btn btn-link" name="replace" onclick="refresh()">看不清</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3"></div>
						<div class="col-sm-9 padding-left-0">
							<div class="col-sm-4">
								<button type="submit" class="btn btn-primary btn-block">登&nbsp;&nbsp;陆</button>
							</div>
							<div class="col-sm-4">
								<button type="reset" class="btn btn-primary btn-block">重&nbsp;&nbsp;置</button>
							</div>
							<div class="col-sm-4">
								<button type="button" class="btn btn-link btn-block">忘记密码？</button>
							</div>
						</div>
					</div>
				</form>
				<!-- login form end -->
			</div>
		</div>
	</div>
	<!-- 页尾 版权声明 -->
	<div class="container">
		<div class="col-sm-12 foot-css">
			<p class="text-muted credit">Copyright 南京网博 版权所有</p>
		</div>
	</div>

</body>
</html>
