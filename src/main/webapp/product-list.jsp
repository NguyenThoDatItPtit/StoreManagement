<%@page import="java.util.*,model.Product"%>

<%
List<Product> list = (List<Product>) request.getAttribute("list");
%>

<h2>Product List</h2>

<table border="1">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Action</th>
	</tr>

	<%
	for (Product p : list) {
	%>

	<tr>
		<td><%=p.getId()%></td>
		<td><%=p.getName()%></td>
		<td><%=p.getPrice()%></td>
		<td><%=p.getQuantity()%></td>

		<td><a href="products?action=edit&id=<%=p.getId()%>">
				<button>Edit</button>
		</a> <a href="products?action=delete&id=<%=p.getId()%>"
			onclick="return confirm('Delete?')">
				<button>Delete</button>
		</a></td>

	</tr>

	<%
	}
	%>

</table>

<br>
<a href="home.jsp">Home</a>