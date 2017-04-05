<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.auto.pojo.*"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Profile</title>
<script type="text/javascript">
function product_list()
{
	//alert("Onlooad")
	// window.location = "/getproductforupdate"
	// document.location.href = 'showProduct';
}
</script>
</head>
<body style="background-color:#D8BFD8"; onload="return product_list()">
<form action="UpdateProduct" method="get" name="update" >

<input type="submit" value="Show Products">
<%
	
	List<Product> resultset  = (List<Product>) request.getAttribute("Data");
		
	if(null!=request.getAttribute("Message"))
	{
		out.println(request.getAttribute("Message"));
	}	

	
	if(null != resultset)
	{
		
%>
		<TABLE BORDER="1">
        <TR>
            <TH>Product Company</TH>
            <TH>Product Name</TH>
            <TH>Product Price</TH>
          	<TH>Product Available</TH>
          	<TH>Product sold</TH>
          	<TH>Product Total</TH>
          	<TH>Product Address</TH>
        </TR>
        
        <%
        	for(int i =0; i<resultset.size(); i++)
            { %>
            <TR>
            
            <TD><% out.print(resultset.get(i).getPrd_company());%></TD>
            <TD><%	out.print(resultset.get(i).getPrd_name());%></TD>
        	<TD><%out.print(resultset.get(i).getPrd_price());%>
        	<TD><%out.print(resultset.get(i).getUnits_available());%>
        	<TD><%out.print(resultset.get(i).getUnits_sold());%>
        	<TD><%out.print(resultset.get(i).getUnits_total());%>
        	<TD><%out.print(resultset.get(i).getAddress());%>
        	</TD>
        	</TR>
          <% } %>
        	 </TABLE>
    	<%
    	} %>

<br></br>

<h1><A HREF="updateproduct.jsp"><strong>Update Product</strong></A></h1>

<h1><A HREF="addproduct.jsp"><strong>Add Product</strong></A></td></h1>

<h1><A HREF="deleteproduct.jsp"><strong>Delete Product</strong></A></td></h1>
</form>
</body>
</html>