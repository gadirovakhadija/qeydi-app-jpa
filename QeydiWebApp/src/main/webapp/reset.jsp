<%--
  Created by IntelliJ IDEA.
  User: Khadija Gadirova
  Date: 2/17/2023
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reset Password</title>
    <link rel="stylesheet" href="assets/css/reset.css">
</head>
<body>
<div class="login-page">
    <div class="form">
        <form action="reset" method="post">
            <input type="email" placeholder="Email..." name="email"/>
            <input type="password" placeholder="Current password" name="password"/>
            <input type="password" placeholder="New password" name="new1Password"/>
            <input type="password" placeholder="Repeat New password" name="new2Password"/>

            <button>Update password</button>
        </form>
    </div>
</div>

</body>
</html>
