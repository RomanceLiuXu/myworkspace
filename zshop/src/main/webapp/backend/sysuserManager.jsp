<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    <title>backend</title>
    <link rel="stylesheet"  href="<%=basePath %>css/bootstrap.css" />
    <link rel="stylesheet"  href="<%=basePath %>css/index.css" />
    <script src="<%=basePath %>js/jquery.js"></script>
    <script src="<%=basePath %>js/bootstrap.js"></script>
    <script src="<%=basePath%>js/bootstrap-paginator.js"></script>
    <script src="<%=basePath %>js/userSetting.js"></script>
    <script src="<%=basePath %>layer/layer.js"></script>
    <script type="text/javascript">
    $(function(){
		$("#pagination").bootstrapPaginator({
			bootstrapMajorVersion:3,
			currentPage:${pageInfo.pageNum},
			totalPages:${pageInfo.pages},
			pageUrl: function(type, page, current){
                 return "<%=basePath%>backend/sysuser/findAll?pageIndex="+page; 
         },
         itemTexts: function (type, page, current) {
        	                 switch (type) {
        	                     case "first":
        	                         return "首页";
        	                     case "prev":
        	                         return "上一页";
        	                     case "next":
        	                         return "下一页";
        	                     case "last":
        	                         return "末页";
        	                     case "page":
        	                         return page;
        	                 }
		}
	
    	})
	}
    );
    
    function showSysuser(id){
    	$.ajax({
    		type:"get",
    		url:"<%=basePath%>backend/sysuser/showSysuser",
    		data:"id="+id,
    		success:function(result){
    			console.log(result);
    			$("#MargerStaffId").val(result.id);
    			$("#MargerStaffname").val(result.name);
    			$("#MargerLoginName").val(result.loginName);
    			$("#MargerPhone").val(result.phone);
    			$("#Margeradrees").val(result.address);
    			$("#MargerAdrees").val(result.email);
//     			$("#MargerRole").val(result.role.roleName);
    		}
    		
    	});
    }
    
    function updateSysuser(){
    	$.ajax({
    		type:"post",
    		url:"<%=basePath%>backend/sysuser/updateSysuser",
    		data:$("#updatefrom").serialize(),
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
    function updateStatus(id,isValid){
    	$.ajax({
    		type:"post",
    		url:"<%=basePath%>backend/sysuser/updateStatus",
    		data:{
    			id:id,
    			isValid:isValid
    		},
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
    function addSysuser(){
    	$.ajax({
    		type:"post",
    		url:"<%=basePath%>backend/sysuser/addSysuser",
    		data:$("#addform").serialize(),
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
    </script>
</head>

<body>
    <!-- 系统用户管理 -->
    <div class="panel panel-default" id="adminSet">
        <div class="panel-heading">
            <h3 class="panel-title">系统用户管理</h3>
        </div>
        <div class="panel-body">
            <div class="showmargersearch">
                <form class="form-inline" action="<%=basePath%>backend/sysuser/findAll" method="post">
				  <div class="form-group">
				    <label for="userName">姓名:</label>
				    <input type="text" class="form-control" id="userName" name="name" placeholder="请输入姓名">
				  </div>
				  <div class="form-group">
				    <label for="loginName">帐号:</label>
				    <input type="text" class="form-control" id="loginName" name="loginName" placeholder="请输入帐号">
				  </div>
				  <div class="form-group">
				    <label for="phone">电话:</label>
				    <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入电话">
				  </div>
				  <div class="form-group">
				    <label for="role">角色</label>
	                    <select class="form-control" name="role" id="role">
	                        <option value="-1">全部</option>
	                        <c:forEach items="${roles }" var="role">
                            <option value="${role.id }">${role.roleName }</option>
                            </c:forEach>
	                    </select>
				  </div>
				  <div class="form-group">
				    <label for="status">状态</label>
	                    <select class="form-control" name="isValid" id="status">
	                        <option value="-1">全部</option>
	                        <option value="1">---有效---</option>
	                        <option value="0">---无效---</option>
	                    </select>
				  </div>
				  <input type="submit" value="查询" class="btn btn-primary" id="doSearch">
				</form>
            </div>
            <br>
            <input type="button" value="添加系统用户" class="btn btn-primary" id="doAddManger">
            <div class="show-list text-center" style="position: relative; top: 10px;">
                <table class="table table-bordered table-hover" style='text-align: center;'>
                    <thead>
                        <tr class="text-danger">
                            <th class="text-center">序号</th>
                            <th class="text-center">姓名</th>
                            <th class="text-center">帐号</th>
                            <th class="text-center">电话</th>
                            <th class="text-center">邮箱</th>
                            <th class="text-center">状态</th>
                            <th class="text-center">注册时间</th>
                            <th class="text-center">角色</th>
                            <th class="text-center">操作</th>
                        </tr>
                    </thead>
                    <tbody id="tb">
                    <c:forEach items="${pageInfo.list }" var="sysuser">
                        <tr>
                            <td>${sysuser.id }</td>
                            <td>${sysuser.name }</td>
                            <td>${sysuser.loginName }</td>
                            <td>${sysuser.phone }</td>
                            <td>${sysuser.email }</td>
                            <c:if test="${sysuser.isValid eq 1}">
                            <td>有效</td>
                            </c:if>
                            <c:if test="${sysuser.isValid eq 0 }">
                            <td>无效</td>
                            </c:if>
                            <td><fmt:formatDate value="${sysuser.createDate }" type="both"/></td>
                            <td>${sysuser.role.roleName }</td>
                            <c:if test="${sysuser.isValid eq 1 }">
                            <td class="text-center">
                                <input type="button" class="btn btn-warning btn-sm doMangerModify" value="修改" onclick="showSysuser(${sysuser.id })">
                                <input type="button" class="btn btn-danger btn-sm doMangerDisable" value="禁用" onclick="updateStatus(${sysuser.id },${sysuser.isValid })">
                            </td>
                            </c:if>
                             <c:if test="${sysuser.isValid eq 0 }">
                            <td class="text-center">
                                <input type="button" class="btn btn-warning btn-sm doMangerModify" value="修改" onclick="showSysuser(${sysuser.id })">
                                <input type="button" class="btn btn-success btn-sm doMangerDisable" value="启用" onclick="updateStatus(${sysuser.id },${sysuser.isValid })">
                            </td>
                            </c:if>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                    <ul id="pagination"><ul/>
            </div>
        </div>
    </div>

    <!-- 添加系统用户 start -->
    <div class="modal fade" tabindex="-1" id="myMangerUser">
        <!-- 窗口声明 -->
        <div class="modal-dialog">
            <!-- 内容声明 -->
            <div class="modal-content">
                <!-- 头部、主体、脚注 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">添加系统用户</h4>
                </div>
                <form id="addform" method="post" action="<%=basePath%>backend/sysuser/addSysuser">
                <div class="modal-body text-center">
                    <div class="row text-right">
                        <label for="marger-username" class="col-sm-4 control-label">用户姓名：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="marger-username" name="name">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="marger-loginName" class="col-sm-4 control-label">登录帐号：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="marger-loginName" name="loginName">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="marger-password" class="col-sm-4 control-label">登录密码：</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="marger-password" name="password">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="marger-phone" class="col-sm-4 control-label">联系电话：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="marger-phone" name="phone">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="marger-adrees" class="col-sm-4 control-label">联系邮箱：</label>
                        <div class="col-sm-4">
                            <input type="email" class="form-control" id="marger-email" name="email">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="role" class="col-sm-4 control-label">角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</label>
                        <div class=" col-sm-4">
                            <select class="form-control" name="roleId">
                               <option value="-1">请选择</option>
                               <c:forEach items="${roles }" var="role">
                               <option value="${role.id }">${role.roleName }</option>
                               </c:forEach>
                            </select>
                        </div>
                    </div>
                    <br>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary add-Manger" type="submit"">添加</button>
                    <button class="btn btn-primary cancel" data-dismiss="modal" type="button">取消</button>
                </div>
                </form>
            </div>
        </div>
    </div>
    <!-- 添加系统用户 end -->

    <!-- 修改系统用户 start -->
    <div class="modal fade" tabindex="-1" id="myModal-Manger">
        <!-- 窗口声明 -->
        <div class="modal-dialog">
            <!-- 内容声明 -->
            <div class="modal-content">
                <!-- 头部、主体、脚注 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">系统用户修改</h4>
                </div>
                <form id="updatefrom">
                <div class="modal-body text-center">
                    <div class="row text-right">
                        <label for="MargerUsername" class="col-sm-4 control-label">用户编号：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="MargerStaffId" name="id"  readonly="readonly">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="MargerUsername" class="col-sm-4 control-label">用户姓名：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="MargerStaffname" name="name"> 
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="MargerLoginName" class="col-sm-4 control-label">登录帐号：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="MargerLoginName" readonly="readonly" name="loginName">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="MargerPhone" class="col-sm-4 control-label">联系电话：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="MargerPhone" name="phone">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="MargerAdrees" class="col-sm-4 control-label">联系邮箱：</label>
                        <div class="col-sm-4">
                            <input type="email" class="form-control" id="MargerAdrees" name="email">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="MargerRole" class="col-sm-4 control-label">角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</label>
                        <div class=" col-sm-4">
                            <select class="form-control" id="MargerRole" name="roleId">
                                <option value="-1">请选择</option>
                                <c:forEach items="${roles }" var="role">
                               <option value="${role.id }">${role.roleName }</option>
                               </c:forEach>
                            </select>
                        </div>
                    </div>
                    <br>
                </div>
                </form>
                <div class="modal-footer">
                    <button class="btn btn-primary doMargerModal" onclick="updateSysuser()">修改</button>
                    <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 修改系统用户 end -->

</body>

</html>