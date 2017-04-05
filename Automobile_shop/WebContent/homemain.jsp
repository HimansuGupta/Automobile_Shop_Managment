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
<title>Insert title here</title>
</head>
<!-- <script>
function product_list()
{
	
	
}
</script> -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>

<body style="background-color:#D8BFD8;" >
<form action="getproduct" method="get">

<input type="submit" value="Show Products">
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
          
        </TR>
        <%
        	for(int i =0; i<resultset.size(); i++)
            {
        %>
          	<TR>
              	<TD><% out.print(resultset.get(i).getPrd_company());%></TD>
            	<TD><%	out.print(resultset.get(i).getPrd_name());%></TD>
            	<TD><%	out.print(resultset.get(i).getPrd_price());%></TD>
            </TR>
      <%  } 
         %>
     
       
    	</TABLE>
<%	} %>


</form>
</body>
</html>