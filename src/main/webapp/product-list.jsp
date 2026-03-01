<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.Product"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Management</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<%
List<Product> list =
        (List<Product>) request.getAttribute("list");
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
if(list != null){
    for(Product p : list){
%>

        <tr>
            <td><%=p.getId()%></td>
            <td><%=p.getName()%></td>
            <td>$ <%=p.getPrice()%></td>
            <td><%=p.getQuantity()%></td>

            <td class="action">
                <div class="action-group">

                    <a href="products?action=edit&id=<%=p.getId()%>"
                       class="btn-icon edit-btn">
                        Edit
                    </a>

                    <a href="products?action=delete&id=<%=p.getId()%>"
                       class="btn-icon delete-btn"
                       onclick="return confirm('Delete this product?')">
                        Delete
                    </a>

                </div>
            </td>

        </tr>

<%
    }
}
%>

    </table>

    <br>

    <div style="text-align:center;">
        <a href="home.jsp" class="btn">Home</a>
    </div>

</div>

</body>
</html>