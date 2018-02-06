<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
   function test(obj){
	  // alert(obj);
	  var foodnum=document.getElementById('foodnum').innerHTML;
       // alert(foodnum);
       if(foodnum>0){
    	   window.location.href = 'click.do?foodId='+obj; 
       }
       if(foodnum==0){
    	   alert("对不起，当前菜已售完");
    	   var btn = document.getElementById('testbtn');
    	   btn.disabled="true";
       }
   }
   function save(obj){
	  // alert(obj);
	   window.location.href = 'save.do?foodId='+obj;   
   }
</script>
</head>
<body>
   <div>
     菜品编号:<span id=foodid> ${foodId}</span>
   </div>
   <div>
     剩余份数 :<span id="foodnum">${foodNumber}</span>
   </div>
   <div>
     <input type="button" value="增加" onclick="save(${foodId})">
     <input type="button" value="点餐 " id="testbtn" onclick="test(${foodId})">
   </div>
</body>
</html>