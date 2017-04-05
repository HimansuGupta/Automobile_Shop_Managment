<%@page import="com.auto.pojo.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
/* function product_list()
{
	//alert("Onlooad")
	// window.location = "/getproductforupdate"
	// document.location.href = 'showProduct';
	 document.location.href = 'getproductfordelete'
} */

</script>
</head>
<!-- <body onload="return product_list()"> -->
<body>
<form action="getproductfordelete" method="get">

<input type="submit" value="Show Products">
</form>
<form action="getproductfordelete" method="post">
<%
	//Object result  = request.getAttribute("Data");
	
	List<Product> resultset  = (List<Product>) request.getAttribute("Data");
	
	if(null != resultset)
	{
		
%>
		<TABLE BORDER="1">
        <TR>
            <TH>Product Company</TH>
            <TH>Product Name</TH>
            <TH>Product Price</TH>
            <TH>Product Address</TH>
          	<TH>Product ID</TH>
          	<TH>Mark for Delete</TH>
        </TR>
        <%
        	for(int i =0; i<resultset.size(); i++)
            {
        %>
          	<TR>
          		<TD align="center"><input type="text" name="company" id="textbox" value=<% out.print(resultset.get(i).getPrd_company());%> readonly></input></TD>
            	<TD align="center"><input type="text" name="product" id="textbox" value="<%out.print(resultset.get(i).getPrd_name());%>" readonly></input></TD>
           		<TD align="center"><input type="text" name="price" id="textbox" value=<%out.print(resultset.get(i).getPrd_price());%> readonly></input></TD>
        		<TD align="center"><input type="text" name="address" id="textbox" value=<%out.print(resultset.get(i).getAddress());%> readonly></input></TD>
              	<TD align="center"><input type="text" name="id" id="textbox" value=<%out.print(resultset.get(i).getPrd_id());%> readonly></input></TD>
              	<%-- <TD><% out.print(resultset.get(i).getPrd_company());%></TD>
            	<TD><%	out.print(resultset.get(i).getPrd_name());%></TD>
            	<TD><%	out.print(resultset.get(i).getPrd_price());%></TD>
            	<TD><%	out.print(resultset.get(i).getAddress());%></TD> 
            	<TD><input type="Checkbox" name="checkbox" value="checkbox">--%>
            	<TD> <input type="checkbox" name="checkbox" value=<%out.print(resultset.get(i).getPrd_id());%>></input>
             	</TD>  
            </TR>
      <%  } 
         %>
     
       
    	</TABLE>
<%	} %>
    	
  <br><br>
  <input type="submit" name="Delete Product" value="Delete"></input>
</form>
Delete Product
</body>
</html>