<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.auto.pojo.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <script language="javascript" type="text/javascript">
var i=1;
function addRow()
{
      var tbl = document.getElementById('table');
      var lastRow = tbl.rows.length;
      var iteration = lastRow - 1;
      var row = tbl.insertRow(lastRow);
      var firstCell = row.insertCell(0);
      var el = document.createElement('input');

      el.type = 'text';
      el.name = 'name_' + i;
      el.id = 'name_' + i;
      el.size = 20;
      el.maxlength = 20;
      firstCell.appendChild(el);

      alert(i);
      i++;
      frm.h.value=i;
    //  alert(i);
} -->
</script>
</head>
<body>
<form action="UpdateProductDB" method="get" name="update" >
<!-- <input type="button" value="Add New Item" onclick="addRow();" /> -->
<%
	
	
	List<Product> resultset  = (List<Product>) request.getAttribute("Data");
	
	if(null != resultset)
	{
		
%>
		<TABLE BORDER="1" id="table">
        <TR>
        	
            <TH>Product Company</TH>
            <TH>Product Name</TH>
            <TH>Product Price</TH>
            <TH>Product Available</TH>
            <TH>Product Sold</TH>
            <TH>Product Total</TH>
            <TH>Product Address</TH>
          
        </TR>
        
        <%
        	
        	for(int i =0; i<resultset.size(); i++)
            { %>
            <TR>
           
            	<TD><input type="text" name="company" id="textbox" value=<% out.print(resultset.get(i).getPrd_company());%> readonly></input></TD>
            	<TD><input type="text" name="product" id="textbox" value="<%out.print(resultset.get(i).getPrd_name());%>" readonly></input></TD>
           		<TD><input type="text" name="price" id="textbox" value=<%out.print(resultset.get(i).getPrd_price());%>></input></TD>
        		<TD><input type="text" name="available" id="textbox" value=<%out.print(resultset.get(i).getUnits_available());%>></input></TD>
        		<TD><input type="text" name="sold" id="textbox" value=<%out.print(resultset.get(i).getUnits_sold());%>></input></TD>
        		<TD><input type="text" name="toatal" id="textbox" value=<%out.print(resultset.get(i).getUnits_total());%>></input></TD>
        		<TD><input type="text" name="address" id="textbox" value=<%	out.print(resultset.get(i).getAddress());%> readonly></input></TD>
        	
        	</TR>
        	
          <% } %>
        	 </TABLE>
    	<%
    	} %>
    	
  <br><br>

<input type="submit" value="Update_Into_DB">
</form>
</body>
</html>