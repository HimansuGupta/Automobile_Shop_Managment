<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
</head>
<script type="text/javascript">

function validateform()
{  
	var password=document.myform.password.value;  
	var username=document.myform.username.value;
	 
	if (username == null || username == "") 
	{
		alert("Username can't be blank");
		return false;
	}
	else if (password == null || password == "") 
	{
		alert("Password can't be blank");
		return false;
	} 
}
</script>
	
<body style="background-color:#D8BFD8;">
<form action="UserAuthentication" name="myform" method="get" onsubmit="return validateform()">
<br/>  <br/>
<center style="font-size:27px;"><b>User Login Details</b>
<br/>  <br/>
<table>
<tr>
<td>UserName</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input type="text" name="username" style="font-size:18px;height:20px;width:250px;"></td>
</tr>
<tr>
<td>Password</td>
<td></td>
<td><input type="password" name="password" style="font-size:18px;height:20px;width:250px;"></td>
</tr>
<tr>
<td colspan="3"><center>
<a href="userprofileleft.jsp" target="leftFrame">
<a href="userprofilemain.jsp" target="mainFrame">

<input type="submit" value="Login" style="font-weight:bold;font-size:16px;height:30px;width:100px;">

<%
	if(null!=request.getAttribute("Error_Message"))
	{
		out.println(request.getAttribute("Error_Message"));
	}	
%>
</a>
</a>
</center></td>
</tr>
</table>
</center>
</form>
</body>
</html>