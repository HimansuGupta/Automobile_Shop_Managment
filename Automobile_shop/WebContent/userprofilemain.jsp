<%@page import="com.auto.pojo.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
</head>
<body style="background-color:#D8BFD8;">
<%
	Object value  = request.getAttribute("userName");
	HttpSession Session=request.getSession();
	Session.setAttribute("userName", value);
%>


<form action="showProduct" method="get">
<h1>Welcome :<%= value %></h1>
<input type="submit" value="Show Products">
<%
	
	List<Product> resultset  = (List<Product>) request.getAttribute("Data");
	
	if(null != resultset)
	{
		
%>
		<TABLE BORDER="1">
        <TR>
            <TH>Product Company</TH>
            <TH>Product Name</TH>
            <TH>Product Price</TH>
            <TH>Product Available</TH>
            <TH>Adress of Product Available Showroom</TH>
            
          
        </TR>
        <%
        	for(int i =0; i<resultset.size(); i++)
            {
        %>
          	<TR>
              	<TD><% out.print(resultset.get(i).getPrd_company());%></TD>
            	<TD><%	out.print(resultset.get(i).getPrd_name());%></TD>
            	<TD><%	out.print(resultset.get(i).getPrd_price());%></TD>
            	<TD><%	out.print(resultset.get(i).getUnits_available());%></TD>
            	<TD><%	out.print(resultset.get(i).getAddress());%></TD>
            </TR>
      <%  } 
         %>
     
       
    	</TABLE>
<%	} %>

</form>

</body>
</html>