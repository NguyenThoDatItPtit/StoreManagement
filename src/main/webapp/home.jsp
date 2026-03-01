<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home - Store Management</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<div class="navbar">
		<a href="home.jsp" class="active">Home</a> <a href="products">Products</a>
		<a href="product-add.jsp">Add Product</a>
	</div>

	<!-- CONTENT -->
	<div class="container">
		<h2>Store Management System</h2>

		<p style="text-align: center;">Welcome to Product Management
			Website</p>

		<div class="action-group">
			<a href="products" class="btn">View Products</a> <a
				href="product-add.jsp" class="btn">Add Product</a>
		</div>
	</div>

</body>
</html>