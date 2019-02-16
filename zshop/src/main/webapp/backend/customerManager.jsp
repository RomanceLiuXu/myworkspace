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
    <title>backend</title>
    <link rel="stylesheet"  href="<%=basePath %>css/bootstrap.css" />
    <link rel="stylesheet"  href="<%=basePath %>css/index.css" />
    <script src="<%=basePath %>js/jquery.js"></script>
    <script src="<%=basePath %>js/bootstrap.js"></script>
    <script src="<%=basePath %>js/userSetting.js"></script>
    <script src="<%=basePath%>js/bootstrap-paginator.js"></script>
    <script src="<%=basePath %>layer/layer.js"></script>
    <script type="text/javascript">
    $(function(){
		$("#pagination").bootstrapPaginator({
			bootstrapMajorVersion:3,
			currentPage:${pageInfo.pageNum},
			totalPages:${pageInfo.pages},
			pageUrl: function(type, page, current){
                 return "<%=basePath%>backend/customer/findAll?pageIndex="+page; 
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
	});
    
    function showCustomer(id){
    	$.ajax({
    		type:"get",
    		url:"<%=basePath%>backend/customer/showCustomer",
    		data:"id="+id,
    		success:function(result){
    			console.log(result);
    			$("#id").val(result.id);
    			$("#name").val(result.name);
    			$("#loginName").val(result.login_name);
    			$("#phone").val(result.phone);
    			$("#adrees").val(result.address);
    		}
    		
    	});
    	
    }
    
    function updateCustomerStatus(id,is_valid){
    	$.ajax({
    		type:"get",
    		url:"<%=basePath%>backend/customer/updateCustomerStatus",
    		data:{
    			id:id,
    			is_valid:is_valid
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
    
    function updateCustomer(){
    	$.ajax({
    		type:"post",
    		url:"<%=basePath%>backend/customer/updateCustomer",
    		data:$("#updateform").serialize(),
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
    
    function findCustomer(){
    	$.ajax({
    		type:"post",
    		url:"",
    		data:$("form[name='searchCustomer']").serialize(),
    		success:function(){
    			
    		}
    		
    	});
    	
    }
    </script>
</head>

<body>
    <div class="panel panel-default" id="userInfo" id="homeSet">
        <div class="panel-heading">
            <h3 class="panel-title">客户管理</h3>
        </div>
        <div class="panel-body text-center">
            <div class="showusersearch">
                <form class="form-inline" method="post" action="<%=basePath%>backend/customer/findAll" name="searchCustomer">
                  <div class="form-group">
                    <label for="customer_name">姓名:</label>
                    <input type="text" class="form-control"id="customer_name" name="name" placeholder="请输入姓名" size="15px">
                  </div>
                  <div class="form-group">
                    <label for="customer_loginName">帐号:</label>
                    <input type="text" class="form-control" id="customer_loginName" name="login_name" placeholder="请输入帐号" size="15px">
                  </div>
                  <div class="form-group">
                    <label for="customer_phone">电话:</label>
                    <input type="text" class="form-control" id="customer_phone" name="phone" placeholder="请输入电话" size="15px">
                  </div>
                  <div class="form-group">
                    <label for="customer_address">地址:</label>
                    <input type="text" class="form-control" id="customer_address" name="address" placeholder="请输入地址">
                  </div>
                  <div class="form-group">
                    <label for="customer_isValid">状态:</label>
                        <select class="form-control" id="customer_isValid" name="is_valid">
                            <option value="-1">全部</option>
                            <option value="1">---有效---</option>
                            <option value="0">---无效---</option>
                        </select>
                  </div>
                  <input type="submit" value="查询" class="btn btn-primary" id="doSearch">
                </form>
            </div>
            
            <div class="show-list" style="position: relative;top: 30px;">
                <table class="table table-bordered table-hover" style='text-align: center;'>
                    <thead>
                        <tr class="text-danger">
                            <th class="text-center">序号</th>
                            <th class="text-center">姓名</th>
                            <th class="text-center">帐号</th>
                            <th class="text-center">电话</th>
                            <th class="text-center">地址</th>
                            <th class="text-center">状态</th>
                            <th class="text-center">操作</th>
                        </tr>
                    </thead>
                    <tbody id="tb">
                    <c:forEach items="${pageInfo.list }" var="customer">
                        <tr>
                            <td>${customer.id }</td>
                            <td>${customer.name }</td>
                            <td>${customer.login_name }</td>
                            <td>${customer.phone }</td>
                            <td>${customer.address }</td>
                            <c:if test="${customer.is_valid==0 }">
                            <td>无效</td>
                            <td class="text-center">
                                <input type="button" class="btn btn-warning btn-sm doModify" value="修改" onclick="showCustomer(${customer.id })">
                                <input type="button" class="btn btn-success btn-sm doDisable" value="启用" onclick="updateCustomerStatus(${customer.id },1)">
                            </td>
                            </c:if>
                            <c:if test="${customer.is_valid==1 }">
                            <td>有效</td>
                            <td class="text-center">
                                <input type="button" class="btn btn-warning btn-sm doModify" value="修改" onclick="showCustomer(${customer.id })">
                                <input type="button" class="btn btn-danger btn-sm doDisable" value="禁用" onclick="updateCustomerStatus(${customer.id },0)">
                            </td>
                            </c:if>
                        </tr>
                       </c:forEach>
                    </tbody>
                </table>
                <ul id="pagination"></ul>
            </div>
        </div>
    </div>

    <!-- 修改客户信息 start -->
    <div class="modal fade" tabindex="-1" id="myModal">
        <!-- 窗口声明 -->
        <div class="modal-dialog">
            <!-- 内容声明 -->
            <div class="modal-content">
                <!-- 头部、主体、脚注 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">修改客户</h4>
                </div>
                 <form id="updateform">
                <div class="modal-body text-center">
                    <div class="row text-right">
                        <label for="id" class="col-sm-4 control-label">编号：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="id" name="id" readonly>
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="name" class="col-sm-4 control-label">姓名：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="loginName" class="col-sm-4 control-label">帐号：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="loginName" name="login_name">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="phone" class="col-sm-4 control-label">电话：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="phone" name="phone">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right">
                        <label for="adrees" class="col-sm-4 control-label">地址：</label>
                        <div class="col-sm-4">
                            <input type="email" class="form-control" id="adrees" name="address">
                        </div>
                    </div>
                    <br>
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary updateOne" onclick="updateCustomer()">修改</button>
                    <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                </div>
            </div>
           
        </div>
    </div>
    <!-- 修改客户信息 end -->
</body>

</html>