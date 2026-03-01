<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="model.Product"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<%
Product p = (Product) request.getAttribute("product");
if(p == null){
%>
    <h3 style="text-align:center;color:red;">
        Product not found!
    </h3>
<%
    return;
}
%>

<div class="container form-card">

    <h2>Edit Product</h2>

    <form action="products" method="post" class="form">

        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%=p.getId()%>">

        <label>Product Name</label>
        <input name="name"
               value="<%=p.getName()%>"
               required>

        <label>Price</label>
        <input type="number"
               step="0.01"
               name="price"
               value="<%=p.getPrice()%>"
               required>

        <label>Quantity</label>
        <input type="number"
               name="quantity"
               value="<%=p.getQuantity()%>"
               required>

        <div class="form-action">
            <button type="submit" class="btn update">
                Update
            </button>

            <a href="products" class="btn cancel">
                Cancel
            </a>
        </div>

    </form>

</div>

</body>
</html>