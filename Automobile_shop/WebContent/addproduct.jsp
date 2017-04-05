<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<SCRIPT language="javascript">
		function addRow(tableID)
		{
				
			var table = document.getElementById(tableID);

			var rowCount = table.rows.length;
			var row = table.insertRow(rowCount);

			var cell1 = row.insertCell(0);
			var element1 = document.createElement("input");
			element1.type = "text";
			element1.name = "id";
			cell1.appendChild(element1);

			var cell2 = row.insertCell(1);
			var element2 = document.createElement("input");
			element2.type = "text";
			element2.name = "company";
			cell2.appendChild(element2);
			
			var cell3 = row.insertCell(2);
			var element3 = document.createElement("input");
			element3.type = "text";
			element3.name = "name";
			cell3.appendChild(element3);
			
			var cell4 = row.insertCell(3);
			var element4 = document.createElement("input");
			element4.type = "text";
			element4.name = "price";
			cell4.appendChild(element4);
			
			var cell5 = row.insertCell(4);
			var element5 = document.createElement("input");
			element5.type = "text";
			element5.name = "available";
			cell5.appendChild(element5);
			
			var cell6 = row.insertCell(5);
			var element6 = document.createElement("input");
			element6.type = "text";
			element6.name = "sold";
			element6.value = "0";
			cell6.appendChild(element6);
			
			var cell7 = row.insertCell(6);
			var element7 = document.createElement("input");
			element7.type = "text";
			element7.name = "total";
			cell7.appendChild(element7);
			
			var cell8 = row.insertCell(7);
			var element8 = document.createElement("input");
			element8.type = "text";
			element8.name = "address";
			cell8.appendChild(element8);
		}
</SCRIPT>

</head>
<body style="background-color:#D8BFD8;">
<form action="SaveInDB" method="post">
<h1>Add New Product Into DB</h1>
<INPUT type="button" value="Add Row" onclick="addRow('dataTable')" />
<%
	if(null!=request.getAttribute("Error_Message"))
	{
		out.println(request.getAttribute("Error_Message"));
	}	
%>
	
	<TABLE id="dataTable" width="350px" border="1">
		<TR>
			<TH>Product ID</TH>
            <TH>Product Company</TH>
            <TH>Product Name</TH>
            <TH>Product Price</TH>
          	<TH>Product Available</TH>
          	<TH>Product sold</TH>
          	<TH>Product Total</TH>
          	<TH>Product Address</TH>
        </TR>
        <TR>
			<Td><INPUT type="text" name="id"/> </Td>
			<Td><INPUT type="text" name="company"/></Td>
			<Td><INPUT type="text" name="name"/> </Td>
			<Td><INPUT type="text" name="price"/> </Td>
			<Td><INPUT type="text" name="available"/> </Td>
			<Td><INPUT type="text" name="sold" value="0"/> </Td>
			<Td><INPUT type="text" name="total"/> </Td>
			<Td><INPUT type="text" name="address"/></Td>
        </TR>
        
	</TABLE>
	<br>
	<br>
	<INPUT type="submit" value="Save Row"/>
</form>
</body>
</html>