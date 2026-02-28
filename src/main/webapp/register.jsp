<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>

<link rel="stylesheet" href="css/style.css">

<div class="container">
    <h2>Register</h2>

    <!-- Thông báo lỗi -->
    <p style="color:red;">
        ${error}
    </p>

    <form action="register" method="post">

        Username:
        <input name="username" required><br><br>

        Password:
        <input type="password" name="password" required><br><br>

        Email:
        <input name="email" required><br><br>

        Phone:
        <input name="phone" required><br><br>

        <button type="submit">Register</button>

    </form>

    <br>
    <a href="login.jsp">Back to Login</a>
</div>