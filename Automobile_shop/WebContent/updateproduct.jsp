<%@page import="com.auto.pojo.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function product_list()
{
	//alert("Onlooad")
	// window.location = "/getproductforupdate"
	 document.location.href = 'getproductforupdate';
}

</script>
</head>
<body onload="return product_list()">
</body>
</html>