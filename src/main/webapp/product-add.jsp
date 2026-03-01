<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="container form-card">

    <h2>Add Product</h2>

    <form action="products" method="post" class="form">

        <label>Name</label>
        <input name="name" required>

        <label>Price</label>
        <input name="price" required>

        <label>Installment</label>
        <input name="installment">

        <label>Quantity</label>
        <input name="quantity">

        <label>Category</label>
        <input name="category">

        <label>Description</label>
        <input name="description">

        <div class="form-action">
            <button class="btn update">Add Product</button>
            <a href="home.jsp" class="btn cancel">Home</a>
        </div>

    </form>

</div>

</body>
</html>