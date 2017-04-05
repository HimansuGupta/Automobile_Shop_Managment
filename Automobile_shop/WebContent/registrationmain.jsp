<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<script>
function validateform()
{  
	var name=document.myform.name.value;  
	var password=document.myform.password.value;  
	var username=document.myform.username.value;
	var cpassword=document.myform.cpassword.value;
	var contact=document.myform.contact.value;
	
	
	if (name == null || name == "") 
	{
		alert("Name can't be blank");
		return false;
	}
	else if (username == null || username == "") 
	{
		alert("Username can't be blank");
		return false;
	}
	else if (password.length < 6) 
	{
		alert("Password must be at least 6 characters long.");
		return false;
	} 
	else if (password != cpassword) 
	{
		alert("Password and does not match");
		return false;
	}
	else if ((/^\d{10}$/.test(contact))==false) 
	{
	    alert("Invalid number; must be ten digits");
	    return false;
	}
}
</script>
<body style="background-color:#D8BFD8;">
<form action="userregistration" name="myform" method="post" onsubmit="return validateform()">
<br/>  <br/>
<center style="font-size:27px;"><b>User Registration Details</b>
<br/>  <br/>
<table>
<!-- <tr>
<td>Employee ID</td>
<td></td>
<td><input type="text" name="empid" style=font-size:18px;height:20px;width:250px;></td>
</tr> -->
<tr>
<td>Name</td>
<td></td>
<td><input type="text" name="name" style=font-size:18px;height:20px;width:250px;></td>
</tr>
<tr>
<td>UserName</td>
<td></td>
<td><input type="text" name="username" style=font-size:18px;height:20px;width:250px;></td>
</tr>
<tr>
<td>Password</td>
<td></td>
<td><input type="password" name="password" style=font-size:18px;height:20px;width:250px;></td>
</tr>
<tr>
<td>Confirm Password</td>
<td></td>
<td><input type="password" name="cpassword" style=font-size:18px;height:20px;width:250px;></td>
</tr>
<!-- <tr>
<td>Position</td>
<td></td>
<td><select style=font-size:18px;height:28px;width:255px;>
<option value="" >asdas</option>
<option value="" >asd</option>
</select>
</td>
</tr> -->
<tr>
<td>Contact Number</td>
<td></td>
<td><input type="text" name="contact" style=font-size:18px;height:20px;width:250px;></td>
</tr>
<tr>
<td>Address of Store</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input type="text" name="address" style=font-size:18px;height:20px;width:250px;></td>
</tr>
<tr>
<!-- <td>Admin ID</td>
<td><input type="text"></td>
</tr>
<tr> -->
<td colspan="3"><center><input type="submit" value="Register" style=font-weight:bold;font-size:16px;height:30px;width:100px;></center></td>
</tr>
</table></center>
</form>
</body>
</html>