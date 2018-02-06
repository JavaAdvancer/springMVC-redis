<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
  function $(id){
	  return document.getElementById(id);  
  }
  function check(){
	  var foodId=$("foodId").value;
	  var foodNumber=$("foodNumber").value;
	  if(foodId==""){
		  alert("编码不能为空 ");
		  $("foodId").focus();  
		  return false;
	  }
	  if(foodNumber==""){
		  alert("数量不能为空 ");
		  $("foodNumber").focus();  
		  return false;  
	  }
	  if(!foodNumber.match(/^([1-9]\d*|[0]{1,1})$/)){
		  alert("请输入0或者整数");
		  $("foodNumber").focus();  
		  return false;
	  }
	   
  }

</script>
</head>
<body>
	<form action="init.do" method="post" onsubmit="return check()">
		菜品编号：<input type="text" name="foodId" id="foodId">
		<br> 
		数量：<input type="text" name="foodNumber" id="foodNumber"> 
		<br>
			<input type="submit" value="保存" >
	</form>

</body>
</html>