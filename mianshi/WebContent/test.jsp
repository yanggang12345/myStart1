<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
	<script src="js/jquery-3.1.1.js" type="text/javascript" charset="utf-8"></script>

	<style type="text/css">
	*{	
		padding: 0;
		margin: 0;
	}
	 a {
 			 	text-decoration: none;
 			 	padding-left: 10px;
 			 	color: black;
				line-height:139px ;
 				font-size: 40px;
 			}
		.main{
			width: 1080px;
			height: 1925px;
			border: 2px solid white;
			background-image: url(img/答题.png);
			margin: 0px auto;
			background-repeat: no-repeat;
			}
			.top{
			width: 1048px;
			height: 588px;	
			margin-top: 60px;
			margin-left: 20px;
			}
			.body{
				width: 1077px;
			    height: 1130px;	
			    border: 1px solid white;
			}
			.an{
				width: 769px;
				height: 102px;
				border-radius:20px;
				margin-top:5px;
				margin-left: 150px;
				margin-bottom: 70px;
				line-height: 103px;
				font-size:30px;
				background-color: white;
				border: 1px solid white;
			}
			 
			.timu{
				width: 830px;
				height: 210px;
				margin-top: 90px;
				margin-left: 105px;
				line-height: 60px;
				font-size: 40px;

 			}
 			.foot .foot1{
 				float: left;
 				width: 155px;				
 				height: 139px;
 			}
 			.foot .foot2{
 				width: 300px;
 				height: 139px;
 				float: left;
 				background-color: #f5f5f5;
 			}
 			checkbox{
				width:100px;height:100px;
			}
			.btn{
 				width:200px;
 				height:70px;
 				line-height: 70px;
 				border-radius:25px;
 				margin-left: 120px;
 				float:left;
 				background-color: white;
 			}
 			 
	</style>
	<style type="text/css">

#banner {
	position:relative;
	width:1048px;
	height:588px;
	overflow:hidden;}
#banner_list img {
	border:0px;
	}
#banner_bg {
	position:absolute;
	 bottom:0;
	 background-color:#000;
	 height:30px;filter: Alpha(Opacity=30);
	 opacity:0.3;z-index:1000;
	cursor:pointer;
 	width:478px;
}
#banner_info{
	  position:absolute;
	  bottom:0;
	  left:5px;
	  height:22px;
	  color:#fff;
	  z-index:1001;
	  cursor:pointer}
#banner_text {
	position:absolute;
	width:120px;
	z-index:1002; 
	right:3px; 
	bottom:3px;
	}
#banner ul {
	position:absolute;
	list-style-type:none;
	filter: Alpha(Opacity=80);
	opacity:0.8; 
	border:1px solid #fff;
	z-index:1002;
    margin:0; 
    padding:0; 
    bottom:3px; 
    right:5px;
    }
#banner ul li {
	 padding:0px 8px;
	 float:left;
	 display:block;
	 color:#FFF;
	 border:#e5eaff 1px solid;
	 background:#6f4f67;
	 cursor:pointer;
	 }
#banner ul li.on { 
	background:#900;
	}
#banner_list a{
	position:absolute;
	} <!-- 让四张图片都可以重叠在一起-->
</style>
	<script type="text/javascript">
 
    window.onload =function() {
    var i = 9;
            setInterval(function(){               
            if(i == 0) {
                    /* location.href = "${pageContext.request.contextPath }/product?id1=${product2.id}&&remark=true"; */
                    $("body form").submit();
                }
                document.getElementById("test").innerHTML = i--; 
            },1000);
        };
    </script>
	<script type="text/javascript">
		
		var t=0;
		var y=12,n=0;
		$(function(){
			t = setInterval("showAuto()", 2000);
        	$("#banner").hover(function(){clearInterval(t)}, function(){t = setInterval("showAuto()", 2000);});
			$("#banner li").click(function(){
				n=$(this).text()-1;
				console.log(n);
				showAuto();
			});
		});
		
		function showAuto(){
			
			if(y<15){
			y=12+n;
			
			var i=$(".top li").eq(n).css({background:'red',color:'#FFF'});
			$(".top li").filter(':not(:eq('+n+'))').css({background:'#6f4f67',color:'#FFF'});
			console.log(i);
			
        	n++;
        	console.log(n);
        	}else{
        		y=12;
        		n=0;
        	}
        	$("#img").attr('src','img/p'+y+'.jpg');
    }

	</script>
	<body>
		<div class="main">
			<div class="top">
				<div id="banner">
					<ul>
					<li class="on">1</li>
					<li>2</li>
					<li>3</li>
					<li>4</li>
					</ul>
					<div id="banner_list">
						<a href="#"><img src="img/p15.jpg" id="img"/></a>
					</div>
				</div>
			</div>
		<div>
			<div class="body">
				<form action="${pageContext.request.contextPath }/product" method="post">
				<input type="hidden" name="id1" value="${product2.id }"/><br/>
					<div class="timu">
						${product2.title }
							</div>
					<div class="an">
					<input   type="checkbox" name="remark" value="a" style="width:30px;height:30px;"/>
						A.&nbsp;&nbsp;${product2.a }
					</div>
					<div class="an">
					<input   type="checkbox" name="remark" value="b" style="width:30px;height:30px;"/>
						B.&nbsp;&nbsp;${product2.b}
					</div>
					<div class="an">
					<input  type="checkbox" name="remark" value="c" style="width:30px;height:30px;" />
						C.&nbsp;&nbsp;${product2.c }
					</div>
					<div class="an">
					<input   type="checkbox" name="remark" value="d" style="width:30px;height:30px;"/>
						D.&nbsp;&nbsp;${product2.d }
					</div>
				<div class="btn">&nbsp;&nbsp;<span id='test' style="color: red;font-size: 40px;">10</span>后自动提交</div>		
 				<div class="btn">第 ${count} 题！</div>
 				<div class="btn">共  ${num} 题</div>
				</form>
					
			</div>
				
			<div class="foot">
				<div class="foot1">
					<a href="#"><img src="img/11.png"/></a>
				</div>
				<div class="foot2">
				&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;	
				<a class="aaa" href="#">咨询</a>
				</div>
				<div class="foot2">
				&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;	
				<a class="aaa" href="#">分数</a>		
				</div>
				<div class="foot2">
				&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;	
				<a class="aaa" href="#">兑换奖券</a>
				</div>
			</div>
		</div>
		</div>
	</body>
</html>