<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	//协议://+IP:+端口号+/+工程名+/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>在线购物商城</title>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.css" />
<link rel="stylesheet" href="<%=basePath%>css/style.css" />
<link rel="stylesheet" href="<%=basePath%>iconfont/iconfont.css">
<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>js/bootstrap.js"></script>
<script src="<%=basePath%>js/zshop.js"></script>
<script src="<%=basePath%>layer/layer.js"></script>
<script type="text/javascript">
    function login(){
    	$.ajax({
    		type:"post",
    		url:"<%=basePath%>login",
    		data:$("#loginform").serialize(),
    		success:function(result){
    			layer.msg(result.message,{
					time:1500
				},function(){
					//刷新页面
					window.location.reload();
				}
				); 
    		}
    		
    	});
    }
    
    function register(){
    	$.ajax({
    		type:"post",
    		url:"<%=basePath%>register",
    		data:$("#registerform").serialize(),
    		success:function(result){
    			layer.msg(result.message,{
					time:1500
				},function(){
					//刷新页面
					window.location.reload();
				}
				);
    		}
    		
    	});
    }
    function sendCode(){
    	$("input[name='code']").val('');
    	$.ajax({
    		type:"post",
    		url:"<%=basePath%>checkPhone",
			data:"phone="+$("#phone").val(),
			success : function(result) {
				console.log(result);
				layer.msg(result.message, {
					time : 1000
				}, function() {
					console.log(result.status);
					//手机验证正确，验证码发送成功
					if (result.status == 1) {
						var obj = $("#phoneCode");
						console.log(obj.text());
						obj.attr("disabled","disabled");
// 						$("#loginPhone").remove("disabled");
						//设置倒计时时间59-0
						var time = 59;
						//serInterval()按照指定周期（毫秒计算）来调用函数或计算表达式，返回一个ID值
						var timer = setInterval(function() {
							var temp = time--;
							obj.text("(" + temp + "s)后重新获取验证码");
							if (temp <= 0) {
								obj.removeAttr("disabled");
								obj.text("发送验证码");
								//取消setInterval()的设置的时间
								clearInterval(timer);
								return;
							}
						}, 1000);//设置1000毫秒=1秒
					}
					else{
// 						$("#loginPhone").attr("disabled", "disabled");
					}
				});
			}

		});
	}
    
    function loginByPhone(){
    	$.ajax({
    		type:"post",
    		url:"<%=basePath%>loginByPhone",
    		data:$("#loginByPhone").serialize(),
    		success:function(result){
    			console.log(result);
    			layer.msg(result.message,{
					time:1000
				},function(){
					if (result.status==1) {
						//刷新页面
 	 					window.location.reload();
					}
				}
				);
    		}
    	});
    }
</script>
</head>

<body>
	<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<!-- content start -->
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="page-header" style="margin-bottom: 0px;">
						<h3>商品列表</h3>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<form class="form-inline hot-search" id="searchfrom" method="post"
						action="<%=basePath%>/showByParam">
						<div class="form-group">
							<label class="control-label">商品：</label> <input type="text"
								class="form-control" placeholder="商品名称" name="name">
						</div>
						&nbsp;
						<div class="form-group">
							<label class="control-label">价格：</label> <input type="text"
								class="form-control" placeholder="最低价格" name="minPrice">
							<input type="text" class="form-control" placeholder="最高价格"
								name="maxPrice">
						</div>
						&nbsp;
						<div class="form-group">
							<label class="control-label">种类：</label> <select
								class="form-control input-sm" name="productTypeId">
								<option value="-1">查询全部</option>
								<c:forEach items="${productTypes }" var="pt">
									<option value="${pt.id }">${pt.name }</option>
								</c:forEach>
							</select>
						</div>
						&nbsp;
						<div class="form-group">
							<button type="submit" class="btn btn-warning">
								<i class="glyphicon glyphicon-search"></i> 查询
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="content-back">
			<div class="container" id="a">
				<div class="row">
					<c:forEach items="${products }" var="p">
						<div class="col-xs-3  hot-item">
							<div class="panel clear-panel">
								<div class="panel-body">
									<div class="art-back clear-back">
										<div class="add-padding-bottom">
											<img src="<%=basePath %>${p.image}" class="shopImg">
										</div>
										<h4>
											<a href="">${p.name }</a>
										</h4>
										<div class="user clearfix pull-right">￥${p.price }</div>
										<div class="desc">${p.info }</div>
										<div class="attention pull-right">
											加入购物车 <i class="icon iconfont icon-gouwuche"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- content end-->
		<!-- footers start -->
		<div class="footers">版权所有：南京网博</div>
		<!-- footers end -->
	</div>

	<!-- 修改密码模态框 start -->
	<div class="modal fade" id="modifyPasswordModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改密码</h4>
				</div>
				<form action="" class="form-horizontal" method="post">
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-3 control-label">原密码：</label>
							<div class="col-sm-6">
								<input class="form-control" type="password">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">新密码：</label>
							<div class="col-sm-6">
								<input class="form-control" type="password">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">重复密码：</label>
							<div class="col-sm-6">
								<input class="form-control" type="password">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning" data-dismiss="modal"
							aria-label="Close">关&nbsp;&nbsp;闭</button>
						<button type="reset" class="btn btn-warning">重&nbsp;&nbsp;置</button>
						<button type="submit" class="btn btn-warning">修&nbsp;&nbsp;改</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 修改密码模态框 end -->

	<!-- 登录模态框 start  -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<!-- 用户名密码登陆 start -->
			<div class="modal-content" id="login-account">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">用户名密码登录</h4>
				</div>
				<form class="form-horizontal" id="loginform">
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-3 control-label">用户名：</label>
							<div class="col-sm-6">
								<input class="form-control" type="text" placeholder="请输入用户名"
									name="login_name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
							<div class="col-sm-6">
								<input class="form-control" type="password" placeholder="请输入密码"
									name="password">
							</div>
						</div>
					</div>
					<div class="modal-footer" style="text-align: center">
						<a class="btn-link">忘记密码？</a> &nbsp;
						<button type="button" class="btn btn-warning" data-dismiss="modal"
							aria-label="Close">关&nbsp;&nbsp;闭</button>
						<button type="button" class="btn btn-warning" onclick="login()">登&nbsp;&nbsp;陆</button>
						&nbsp;&nbsp; <a class="btn-link" id="btn-sms-back">短信快捷登录</a>
					</div>
				</form>
			</div>
			<!-- 用户名密码登陆 end -->
			<!-- 短信快捷登陆 start -->
			<div class="modal-content" id="login-sms" style="display: none;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">短信快捷登陆</h4>
				</div>
				<form class="form-horizontal" method="post" id="loginByPhone">
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-3 control-label">手机号：</label>
							<div class="col-sm-6">
								<input class="form-control" type="text" placeholder="请输入手机号"
									name="phone" id="phone">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">验证码：</label>
							<div class="col-sm-4">
								<input class="form-control" type="text" placeholder="请输入验证码"
									name="code">
							</div>
							<div class="col-sm-2">
								<button class="pass-item-timer" type="button"
									onclick="sendCode()" id="phoneCode">发送验证码</button>
							</div>
						</div>
					</div>
					<div class="modal-footer" style="text-align: center">
						<a class="btn-link">忘记密码？</a> &nbsp;
						<button type="button" class="btn btn-warning" data-dismiss="modal"
							aria-label="Close">关&nbsp;&nbsp;闭</button>
						<button type="button" class="btn btn-warning"
							onclick="loginByPhone()" id="loginPhone">登&nbsp;&nbsp;陆</button>
						&nbsp;&nbsp; <a class="btn-link" id="btn-account-back">用户名密码登录</a>
					</div>
				</form>
			</div>
			<!-- 短信快捷登陆 end -->
		</div>
	</div>
	<!-- 登录模态框 end  -->

	<!-- 注册模态框 start -->
	<div class="modal fade" id="registModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">会员注册</h4>
				</div>
				<form class="form-horizontal" id="registerform">
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-3 control-label">用户姓名:</label>
							<div class="col-sm-6">
								<input class="form-control" type="text" name="name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">登陆账号:</label>
							<div class="col-sm-6">
								<input class="form-control" type="text" name="login_name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">登录密码:</label>
							<div class="col-sm-6">
								<input class="form-control" type="password" name="password">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">联系电话:</label>
							<div class="col-sm-6">
								<input class="form-control" type="text" name="phone">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">联系地址:</label>
							<div class="col-sm-6">
								<input class="form-control" type="text" name="address">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning" data-dismiss="modal"
							aria-label="Close">关&nbsp;&nbsp;闭</button>
						<button type="reset" class="btn btn-warning">重&nbsp;&nbsp;置</button>
						<button type="button" class="btn btn-warning" onclick="register()">注&nbsp;&nbsp;册</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 注册模态框 end -->
</body>

</html>