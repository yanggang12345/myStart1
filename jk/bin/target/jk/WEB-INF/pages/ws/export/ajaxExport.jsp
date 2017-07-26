<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
    	/*
    		开发步骤：
    		1、创建xmlHttpRquest对象
    		2、open('POST', url, true)链接
    		3、设置请求头
    		4、send(xml)
    		5、回调函数，接受响应xml
    		6、从返回xml中抓取相关字段的信息
    	*/
    	var xmlHttpRequest = null;	//创建XMLHTTP对象IE
    	if(window.XMLHttpRequest) 
    		 
        {
     
            // 针对非IE的标准浏览器
     
            xmlHttpRequest = new XMLHttpRequest();
     
        }
     
     else if(window.ActiveXObject)
     
     {
     
            // 针对IE
     
      try
     
      {
     
    	  xmlHttpRequest = new ActiveXObject("MSXML2.XMLHTTP");
     
      }
     
      catch(e)
     
      {
     
    	  xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
     
      }
     
     }
    	//alert(xmlHttpRequest);
    	/* var xmlHttpRequest = new CreateXMLHttp()
    	function CreateXMLHttp(){  
         //创建一个新变量并赋值false，使用false作为判断条件说明还没有创建XMLHTTPRequest对象   
         var flag=true;  
           
         var xmlhttp = null;  
         try{  
             //尝试创建 XMLHttpRequest 对象，除 IE 外的浏览器都支持这个方法。  
             xmlhttp=new XMLHttpRequest();  
         }catch(e){  
             try{  
                 //使用较新版本的 IE 创建 IE 兼容的对象（Msxml2.XMLHTTP）。  
                 xmlhttp=ActiveXobject("Msxml12.XMLHTTP");  
             }catch(e1){  
                 try{  
                     //使用较老版本的 IE 创建 IE 兼容的对象（Microsoft.XMLHTTP）。  
                     xmlhttp=ActiveXobject("Microsoft.XMLHTTP");  
                 }catch(e2){  
                     flag=false;   
                 }   
             }  
         }  
          
        //判断是否成功的例子：  
         if(!flag){  
             throw new RuntimeExecption("创建XMLHTTPRequest 对象失败");  
         }else{  
             return xmlhttp;  
         }  
     } */
    	//发送信息
    	function s(){
    		var id = document.getElementById("id").value;				//用户输入的条件
    		
	    	var url = "http://localhost:8080/jk/cxf/ExportServiceImpl";			//webService访问链接
	    	var requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q0=\"http://impl.service.jk.itcast.cn/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
	    					+ "<soapenv:Body><q0:get><arg0>"+id+"</arg0></q0:get></soapenv:Body></soapenv:Envelope>";
	    	
	    	
	    	xmlHttpRequest.open("POST", url, true);										//打开链接
	    	xmlHttpRequest.setRequestHeader("Content-Type","text/xml;charset=utf-8");	//设置请求头
	    	
	    	xmlHttpRequest.send(requestBody);											//发生soap请求
	    	
	    	
	    	xmlHttpRequest.onreadystatechange = _back;									//在onreadystatechange事件绑定回调函数
	    }
    	
    	//回调函数
    	function _back(){
    		if(xmlHttpRequest.readyState==4){				//提交完成后
    			if(xmlHttpRequest.status==200){				//调用成功
    				alert(xmlHttpRequest);
    				var retXml = xmlHttpRequest.responseXML;
    				alert(retXml);
    				
    				var ret = retXml.getElementsByTagName("return")[0];	//获取return节点信息
    				alert(ret);
    				if(ret!=null){
	    				var customerContract = retXml.getElementsByTagName("customerContract")[0].textContent;	//获取到报运号
	    				document.getElementById("customerContract").innerHTML = customerContract;
	    				
	    				var inputDate =  ret.getElementsByTagName("inputDate")[0].textContent;	//获取到报运号
	    				document.getElementById("inputDate").innerHTML = inputDate.substring(0,10);
	    				
	    				var lcno =  ret.getElementsByTagName("lcno")[0].textContent;
	    				document.getElementById("lcno").innerHTML = lcno;
	    				
	    				var consignee =  ret.getElementsByTagName("consignee")[0].textContent;
	    				document.getElementById("consignee").innerHTML = consignee;
	    				
	    				var shipmentPort =  ret.getElementsByTagName("shipmentPort")[0].textContent;
	    				document.getElementById("shipmentPort").innerHTML = shipmentPort;
	    				
	    				var destinationPort =  ret.getElementsByTagName("destinationPort")[0].textContent;
	    				document.getElementById("destinationPort").innerHTML = destinationPort;
	    				
	    				var transportMode =  ret.getElementsByTagName("transportMode")[0].textContent;
	    				document.getElementById("transportMode").innerHTML = transportMode;
	    				
	    				var priceCondition =  ret.getElementsByTagName("priceCondition")[0].textContent;
	    				document.getElementById("priceCondition").innerHTML = priceCondition;
	    				
	    				var marks =  ret.getElementsByTagName("marks")[0].textContent;
	    				document.getElementById("marks").innerHTML = marks;
	    				
	    				var remark =  ret.getElementsByTagName("remark")[0].textContent;
	    				document.getElementById("remark").innerHTML = remark;
	    				
	    				var state =  ret.getElementsByTagName("state")[0].textContent;
	    				if(state=='1'){
	    					state = "已上报，待装箱";
	    				}else if(state=='2'){
	    					state = "已装箱，待委托";
	    				}else if(state=='3'){
	    					state = "已委托，待发票通知";
	    				}else if(state=='4'){
	    					state = "已发票，流程顺利完成!";
	    				}
	    				document.getElementById("state").innerHTML = "<font color='orange'>"+state+"</font>";
    				}else{
    					//清空所有框中数据
    					alert("没有查询到数据!");
    				}
    			
    			}else{
    				// 无法正确访问出口报运服务!
    			}
    		}
    	}
    	
    </script>
</head>
<body>
<form method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="s();">查看</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		出口报运跟踪
    </div> 
    </div>
    </div>
<div>

     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		状态：<span id="state"></span>
    </div> 
    </div>
    </div>
<div>

    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">报运编号：</td>
	            <td class="tableContent"><input type="text" name="id" id="id" value="a81f5a3f-386d-4b31-a03f-e81a8fe28a1d"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">报运号：</td>
	            <td class="tableContent" id="customerContract"></td>
	            <td class="columnTitle_mustbe">制单日期：</td>
	            <td class="tableContent" id="inputDate"></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">信用证号：</td>
	            <td class="tableContent" id="lcno"></td>
	            <td class="columnTitle_mustbe">收货人及地址：</td>
	            <td class="tableContent" id="consignee"></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">装运港：</td>
	            <td class="tableContent" id="shipmentPort"></td>
	            <td class="columnTitle_mustbe">目的港：</td>
	            <td class="tableContent" id="destinationPort"></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">运输方式：</td>
	            <td class="tableContentAuto" id="transportMode"></td>
	            <td class="columnTitle_mustbe">价格条件：</td>
	            <td class="tableContentAuto" id="priceCondition"></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">唛头：</td>
	            <td class="tableContent" id="marks"></td>
	            <td class="columnTitle_mustbe">备注：</td>
	            <td class="tableContent" id="remark"></td>
	        </tr>
		</table>
	</div>
</div>

 
</form>
</body>
</html>

