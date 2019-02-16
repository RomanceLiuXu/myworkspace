<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	//协议://+IP:+端口号+/+工程名+/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>商品汇总</title>
<style type="text/css">
/* body{ */
/* position: relative */
/* } */
/* #main{ */
/*   width: 50%; */
/*   height: 50%; */
/*   overflow: auto; */
/*   margin: auto; */
/*   position: absolute; */
/*   top: 0; left: 0; bottom: 0; right: 0; */
/* } */
</style>
</head>
<body>
<div id="main" style="width: 30%;height: 500px;margin-bottom:100px;margin-left: 100px;display: inline-block;" ></div> 
<div id="main1" style="width: 30%;height: 500px;margin-bottom:100px;margin-left: 200px;display: inline-block;" ></div>
</body>
<script type="text/javascript" src="<%=basePath %>js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/echarts.common.min.js"></script>
<script type="text/javascript">
window.onload = function(){
 	$.ajax({
		url:"<%=basePath%>backend/product/selectNum", 
		type:"get",
		success:function(data){
			console.log(data);
			var name = new Array();
			var value = new Array();
			
			for (var i = 0; i < data.length; i++) {
				name[i] = data[i].productTypeName;
				value[i] = data[i].num;
			}

			console.log(name);
			console.log(value);

			var myChart = echarts.init(document.getElementById("main"));
			var option={
					/* 标题 */
					title:{
					text:'商品类型统计图'	
					},
					/* 图例 */
					legend:{
						data:['数量']
					},
					/* x轴 */
					xAxis : {
						data:name
					},
					/* y轴 */
					yAxis : {
					},
					label:{
						show:true
					},
					itemStyle:{
						color:'#9AD932'
// 						borderColor:'bule',
// 						borderWidth:5
					},
					/* 数据源 */
					series : [{
						name: 'ZSHOP',
						type:'bar',
						data :value
					}]
					/*  tooltip:{
						trigger:'item',
						formatter:"{a}<br/>{b} : {c}({d}%)",
					},
					series:[{
						name:'数据来源:ZSHOP',
						type:'pie',
						radius:'70%',
						data:data
					}]  */
			};
			myChart.setOption(option);
		}
	});
	
	$.ajax({
		url:"<%=basePath%>backend/product/selectNumber",
		type:"get",
		success:function(data){
			var myChart = echarts.init(document.getElementById("main1"));
			var option={
					/* 标题 */
					title:{
					text:'商品类型统计图'	
					},
					/* 图例 */
					legend:{
						data:['数量']
					},
// 					itemStyle:{
// 						color: {
// 						    type: 'linear',
// 						    x: 0,
// 						    y: 0,
// 						    x2: 0,
// 						    y2: 1,
// 						    colorStops: [{
// 						        offset: 0, color: 'red' // 0% 处的颜色
// 						    }, {
// 						        offset: 1, color: 'blue' // 100% 处的颜色
// 						    }],
// 						    globalCoord: false // 缺省为 false
// 						}
// 					},
					  tooltip:{
						trigger:'item',
						formatter:"{a}<br/>{b} : {c}({d}%)",
					},
					series:[{
						name:'数据来源:ZSHOP',
						type:'pie',
						radius:'70%',
						data:data
					}]  
			};
			myChart.setOption(option);
		}
	});
	
}
</script>
</html>