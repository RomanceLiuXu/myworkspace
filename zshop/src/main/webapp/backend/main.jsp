<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://shiro.apache.org/tags"  prefix="shiro"%>
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>在线商城-后台管理系统</title>
    <link rel="stylesheet"  href="<%=basePath%>css/bootstrap.css" />
    <link rel="stylesheet"  href="<%=basePath%>css/index.css" />
    <script src="<%=basePath%>js/jquery.js"></script>
    <script src="<%=basePath%>js/bootstrap.js"></script>
    <script src="<%=basePath%>js/userSetting.js"></script>
    <script type="text/javascript">
    $(function(){
    	// 点击切换页面
	     $("#product-type-set").click(function() {
            $("#frame-id").attr("src", "<%=basePath%>backend/productType/findAll");
        });
        $("#product-set").click(function() {
            $("#frame-id").attr("src", "<%=basePath%>backend/product/findAll");
        });
        $("#user-set").click(function() {
            $("#frame-id").attr("src", "<%=basePath%>backend/customer/findAll");
        });
        $("#manager-set").click(function() {
            $("#frame-id").attr("src", "<%=basePath%>backend/sysuser/findAll");
        });
        $("#product-num").click(function() {
            $("#frame-id").attr("src", "<%=basePath%>backend/showChart.jsp");
        });
    });
    </script>
</head>

<body>
    <div class="wrapper-cc clearfix">
        <div class="content-cc">
            <!-- header start -->
            <div class="clear-bottom head">
                <div class="container head-cc">
                    <p>在线商城<span>后台管理系统</span></p>
                    <div class="welcome">
                        <div class="left">欢迎您：</div>
                        <div class="right">${loginName }</div>
                        <div class="exit"><a href="<%=basePath%>manager/loginout" style="color: white">退出</a></div>
                    </div>
                </div>
            </div>
            <!-- header end -->
            <!-- content start -->
            <div class="container-flude flude-cc" id="a">
                <div class="row user-setting">
                    <div class="col-xs-2 user-wrap">
                        <ul class="list-group">
                            <li class="list-group-item active" name="userSet" id="product-type-set">
                                <i class="glyphicon glyphicon-lock"></i> &nbsp;商品类型管理
                            </li>
                            <li class="list-group-item" name="userPic" id="product-set">
                                <i class="glyphicon glyphicon-facetime-video"></i> &nbsp;商品管理
                            </li>
                            <li class="list-group-item" name="userPic" id="product-num">
                                <i class="glyphicon glyphicon-facetime-video"></i> &nbsp;商品汇总
                            </li>
                             <shiro:hasAnyRoles name="营销经理,超级管理员">
                            <li class="list-group-item" name="userInfo" id="user-set">
                                <i class="glyphicon glyphicon-user"></i> &nbsp;客户管理
                            </li>
                            </shiro:hasAnyRoles>
                            <shiro:hasRole name="超级管理员">
                            <li class="list-group-item" name="adminSet" id="manager-set">
                                <i class="glyphicon glyphicon-globe"></i> &nbsp;系统用户管理
                            </li>
                          </shiro:hasRole>
                        </ul>
                    </div>
                    <div class="col-xs-10" id="userPanel">
                        <iframe id="frame-id" src="<%=request.getContextPath()%>/backend/productType/findAll" width="100%" height="100%" frameborder="0" scrolling="no">
                        </iframe>
                    </div>

                </div>
            </div>
            <!-- content end-->
        </div>
    </div>
    <!-- footers start -->
    <div class="footer">
        版权所有：广州米苏
    </div>
    <!-- footers end -->
</body>

</html>