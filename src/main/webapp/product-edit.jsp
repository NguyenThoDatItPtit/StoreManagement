<%@page import="model.Product"%>

<link rel="stylesheet" href="css/style.css">

<%
Product p = (Product)request.getAttribute("product");
%>

<div class="container form-card">

    <h2>Edit Product</h2>

    <form action="products" method="post" class="form">

        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%=p.getId()%>">

        <label>Product Name</label>
        <input name="name" value="<%=p.getName()%>" required>

        <label>Price</label>
        <input type="number" step="0.01"
               name="price"
               value="<%=p.getPrice()%>" required>

        <label>Quantity</label>
        <input type="number"
               name="quantity"
               value="<%=p.getQuantity()%>" required>

        <div class="form-action">
            <button class="btn update">Update</button>
            <a href="products" class="btn cancel"><button>Cancel</button></a>
        </div>

    </form>

</div>