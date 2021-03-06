<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.css" />
<link rel="stylesheet" href="<%=basePath%>css/index.css" />
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/bootstrap.js"></script>
<script src="<%=basePath%>js/userSetting.js"></script>
<script src="<%=basePath%>js/bootstrap-paginator.js"></script>
<script src="<%=basePath%>layer/layer.js"></script>
<script type="text/javascript">
			$(function(){
				$("#pagination").bootstrapPaginator({
					bootstrapMajorVersion:3,
					currentPage:${pageInfo.pageNum},
					totalPages:${pageInfo.pages},
					pageUrl: function(type, page, current){
	                     return "<%=basePath%>backend/productType/findAll?pageIndex="+page; 
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
			
			/**
	    	 * 添加商品类型
	    	 */
	    	function addProductType(){
	    		console.log($("#productTypeName").val());
	    		$.ajax({
	    			type:"post",
	    			url:"<%=basePath%>backend/productType/addProductType",
	    			data:"name="+$("#productTypeName").val(),
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
			
			//根据id查找某个商品类型
	    	function showProductType(id){
	    		$.ajax({
	    			type:"get",
	    			url:"<%=basePath%>backend/productType/showProductType",
	    			data:"id="+id,
	    			success:function(result){
	    				console.log(result);
	    				$("#proTypeNum").val(result.id);
	    				$("#proTypeName").val(result.name);
	    			}
	    		});
	    	}
		    //删除某个商品类型
	    	function deleteProductType(id){
	    		layer.confirm('您确定要删除该类商品吗?删除后类所有商品将被清空!!',{btn: ['确定', '取消'],title:"删除商品类型"}, function(){
	    		$.ajax({
	    			type:"get",
	    			url:"<%=basePath%>backend/productType/deleteProductType",
	    			data:"id="+id,
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
	    		});
	    	}
	    	//更新商品类型
	    	function updateProductType(){
	    		if($("#proTypeName").val()==''){
	    			return;
	    		}
	    		$.ajax({
	    			type:"post",
	    			url:"<%=basePath%>backend/productType/updateProductType",
	    			data:{
	    				id:$("#proTypeNum").val(),
	    				name:$("#proTypeName").val(),
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
	    	//更新商品状态，是否启用
	    	function updateStatus(id,status){
	    		console.log(id,status);
	    		layer.confirm('您确定要更新该类商品的状态吗?',{btn: ['确定', '取消'],title:"更新商品类型状态"}, function(){
	    		$.ajax({
	    			type:"post",
	    			url:"<%=basePath%>backend/productType/updateProductStatus",
	    			data:{
	    				id:id,
	    				status:status
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
	    		});
	    	}
    </script>
</head>

<body>
	<div class="panel panel-default" id="userSet">
		<div class="panel-heading">
			<h3 class="panel-title">商品类型管理</h3>
		</div>
		<div class="panel-body">
			<input type="button" value="添加商品类型" class="btn btn-primary"
				id="doAddProTpye"> <br> <br>
			<div class="show-list text-center">
				<table class="table table-bordered table-hover"
					style='text-align: center;'>
					<thead>
						<tr class="text-danger">
							<th class="text-center">编号</th>
							<th class="text-center">类型名称</th>
							<th class="text-center">状态</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody id="tb">
						<c:forEach items="${pageInfo.list }" var="productType">
							<tr>
								<td>${productType.id }</td>
								<td>${productType.name }</td>
								<c:if test="${productType.status==0 }">
									<td>禁用</td>
								</c:if>
								<c:if test="${productType.status==1 }">
									<td>启用</td>
								</c:if>
								<td class="text-center"><input type="button"
									class="btn btn-warning btn-sm doProTypeModify" value="修改" onclick="showProductType(${productType.id })">
									<input type="button"
									class="btn btn-warning btn-sm doProTypeDelete" value="删除" onclick="deleteProductType(${productType.id })">
									<c:if test="${productType.status==1 }">
									<input type="button"
									class="btn btn-danger btn-sm doProTypeDisable" value="禁用" onclick="updateStatus(${productType.id },0)">
								</c:if>
								<c:if test="${productType.status==0 }">
									<input type="button" class="btn btn-success btn-sm doDisable" value="启用" onclick="updateStatus(${productType.id },1)">
								</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="<%=basePath %>product.xlsx"><input style="float: right;" type="button" value="下载到本地" class="btn btn-primary"
				id="doAddProTpye"> <br> <br></a>
				<ul id="pagination"></ul>
			</div>
		</div>
	</div>

	<!-- 添加商品类型 start -->
	<div class="modal fade" tabindex="-1" id="ProductType">
		<!-- 窗口声明 -->
		<div class="modal-dialog modal-lg">
			<!-- 内容声明 -->
			<div class="modal-content">
				<!-- 头部、主体、脚注 -->
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">添加商品类型</h4>
				</div>
				<div class="modal-body text-center">
					<div class="row text-right">
						<label for="productTypeName" class="col-sm-4 control-label">类型名称：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="productTypeName">
						</div>
					</div>
					<br>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary addProductType" onclick="addProductType()">添加</button>
					<button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加商品类型 end -->

	<!-- 修改商品类型 start -->
	<div class="modal fade" tabindex="-1" id="myProductType">
		<!-- 窗口声明 -->
		<div class="modal-dialog modal-lg">
			<!-- 内容声明 -->
			<div class="modal-content">
				<!-- 头部、主体、脚注 -->
				<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">修改商品类型</h4>
				</div>
				<div class="modal-body text-center">
					<div class="row text-right">
						<label for="proTypeNum" class="col-sm-4 control-label">编号：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="proTypeNum" readonly>
						</div>
					</div>
					<br>
					<div class="row text-right">
						<label for="proTypeName" class="col-sm-4 control-label">类型名称</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="proTypeName">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-warning updateProType" onclick="updateProductType()">修改</button>
					<button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 修改商品类型 end -->
</body>

</html>