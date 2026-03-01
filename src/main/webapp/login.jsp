<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="container">
    <h2>Login</h2>

    <form action="login" method="post" class="form">
        <label>Username</label>
        <input name="username">

        <label>Password</label>
        <input type="password" name="password">

        <div class="form-action">
            <button class="btn">Login</button>
        </div>
    </form>

    <br>

    <a href="register.jsp" class="btn">Create Account</a>

</div>

</body>
</html>