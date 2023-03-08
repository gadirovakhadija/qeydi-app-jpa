<%@ page import="org.example.dao.impl.UserDaoImpl" %>
<%@ page import="org.example.dao.inter.UserDaoInter" %>
<%@ page import="org.example.entity.User" %>
<%@ page import="org.example.main.Context" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>QeydiApp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>

    <link rel="stylesheet" href="assets/css/users.css" type="text/css"/>

</head>

<body id="top">
<%
    UserDaoInter userDao = Context.instanceUserDao();
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    List<User> list = userDao.getAll(name,surname,email,password);
%>
<div class="wrapper col1">
    <div id="header">
        <div id="logo">
            <h1><b><a href="users">Qeydi</a></b></h1>
            <%User us = (User)session.getAttribute("loggedInUser");%>
            <p>Welcome <%=us.getSurname()%> <%=us.getName()%></p>
        </div>
<%--        Kicik SignUp --%>
        <div id="upsignup">
            <form action="sign-up" method="post">
                <input type="text" placeholder="Name" name="name" required>
                <input type="text" placeholder="Surname" name="surname" required>
                <br>
                <input type="email" placeholder="Email" name="email" required>
                <input type="password" placeholder="Password" name="password" required>
                <br>
                <button id="sign">Sign up</button>
            </form>
        </div>
        <br class="clear"/>
    </div>
</div>

<!-- Menyu paneli -->
<div class="wrapper col2">
    <div id="topbar">
        <div id="topnav">
            <ul>
                <li class="active"><a href="users">Home</a></li>
                <li class="active"><a href="registration">Be Trainer</a></li>
                <li class="active"><a href="reset">Reset</a></li>
                <li class="active"><a href="resume">About me</a></li>
            </ul>
        </div>
        <br class="clear"/>

    </div>
</div>
<%--Trainer Melumatlari--%>
<div class="wrapper col3">
    <div id="center">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Teachway</th>
                <th>Subject</th>
                <th>Cost</th>
                <th>See more</th>

            </tr>
            </thead>
            <tbody>
            <tr>

                <%
                    for(User u:list){%>
                <%if(u.getTeachway()!=null){%>
                <td><%=u.getName()%></td>
                <td><%=u.getSurname()%></td>
                <td><%=u.getTeachway().getTeachway()%></td>
                <td><%=u.getSubject().getSubject()%></td>
                <td><%=u.getCost()%></td>
                <td><input type="button" id="gocv" value="More info" onclick="goCv('<%=u.getEmail()%>')"></td>
            </tr>
            <%}}%>

            </tbody>
        </table>
    </div>
</div>
<%--Ashagi panel--%>
<div class="wrapper col4">
    <div id="copyright">
        <h6 class="fl_left">Copyright &copy; 2023 - All Rights Reserved - Gadirova Khadija</h6>
        <br class="clear"/>
    </div>
</div>
<script src="assets/js/users.js"></script>

</body>
</html>
