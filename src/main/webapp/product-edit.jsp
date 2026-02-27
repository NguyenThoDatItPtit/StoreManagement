<%@page import="model.Product"%>

<%
Product p =
(Product)request.getAttribute("product");
%>

<h2>Edit Product</h2>

<form action="products" method="post">

	<input type="hidden" name="action" value="update"> <input
		type="hidden" name="id" value="<%=p.getId()%>"> Name: <input
		name="name" value="<%=p.getName()%>"><br> Price: <input
		name="price" value="<%=p.getPrice()%>"><br> Quantity: <input
		name="quantity" value="<%=p.getQuantity()%>"><br>

	<button>Update</button>

</form>

<br>
<a href="products">Back</a>