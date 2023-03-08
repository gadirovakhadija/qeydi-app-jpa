<%--
  Created by IntelliJ IDEA.
  User: Khadija Gadirova
  Date: 2/9/2023
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="assets/css/login.css" media="all"/>

    <title>Log-Sign in page </title>
</head>
<body>

<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="sign-up" method="post">
            <h1>Create Account</h1>

            <input type="text" placeholder="Name" name="name" required>
            <input type="text" placeholder="Surame" name="surname" required>
            <input type="email" placeholder="Email" name="email" required>
            <input type="password" placeholder="Password" name="password" required>
            <button class="sign" name="login">Sign Up</button>
        </form>
    </div>

    <div class="form-container sign-in-container">
        <form action="sign-in" method="post">
            <h1>Sign in</h1>
            <input type="email" placeholder="Email" name="email" required>
            <input id="passwordId" type="password" placeholder="Password" name="password" required>
            <input type="checkbox" onclick="passwordVisibility()">Show Password

            <button class="sign">Sign In</button>
        </form>
    </div>

    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Hello, User!</h1>
                <p>Please enter your personal info !</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Welcome Back!</h1>
                <p>We are happy to see you again</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/login.js"></script>
</body>
</html>
