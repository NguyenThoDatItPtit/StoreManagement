<%@page import="java.util.*,model.Product"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

<%
List<Product> list = (List<Product>) request.getAttribute("list");
%>

<div class="container">

	<h2>Product Management</h2>

	<table class="product-table">

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
			<td>$ <%=p.getPrice()%></td>
			<td><%=p.getQuantity()%></td>

			<td class="action">
				<div class="action-group">

					<a class="action-a" href="products?action=edit&id=<%=p.getId()%>"><button>Edit</button></a>
					<a href="products?action=delete&id=<%=p.getId()%>"
						onclick="return confirm('Delete this product?')"><button>Delete</button></a>

				</div>
			</td>

		</tr>

		<%
		}
		%>

	</table>

	<br> <a href="home.jsp"><button>Home</button></a>

</div>