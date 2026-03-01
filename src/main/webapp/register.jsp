<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="container form-card">

    <h2>Register</h2>

    <!-- ERROR MESSAGE -->
    <%
        String error = (String) request.getAttribute("error");
        if(error != null){
    %>
        <p style="color:red; text-align:center;">
            <%=error%>
        </p>
    <%
        }
    %>

    <form action="register" method="post" class="form">

        <label>Username</label>
        <input name="username" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Phone</label>
        <input name="phone" required>

        <div class="form-action">
            <button type="submit" class="btn update">
                Register
            </button>

            <a href="login.jsp" class="btn cancel">
                Back to Login
            </a>
        </div>

    </form>

</div>

</body>
</html>