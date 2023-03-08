<%@ page import="org.example.dao.inter.UserDaoInter" %>
<%@ page import="org.example.main.Context" %>
<%@ page import="org.example.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Khadija Gadirova
  Date: 2/22/2023
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="http://yui.yahooapis.com/2.7.0/build/reset-fonts-grids/reset-fonts-grids.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="assets/css/resume.css" media="all"/>
    <title>About me</title>
</head>
<body>
<% User u = (User) session.getAttribute("loggedInUser");%>
<div id="doc2" class="yui-t7">
    <div id="inner">

        <div id="hd">
            <div class="yui-gc">
                <div class="yui-u first">
                    <h1><%=u.getName()%> <%=u.getSurname()%>
                    </h1>
                    <h2><%=u.getTeachway().getTeachway()%>, <%=u.getSubject().getSubject()%>
                    </h2>
                </div>

                <div class="yui-u">
                    <div class="contact-info">
                        <h2>Email:<%=u.getEmail()%>
                        </h2>
                        <h2>Discord code:#<%=u.getCode()%>
                        </h2>
                    </div>
                </div>
            </div>
        </div>

        <div id="bd">
            <div id="yui-main">
                <div class="yui-b">
                    <div class="yui-gf">
                        <div class="yui-u first">
                            <h2>Personal Info</h2>
                        </div>
                        <div class="yui-u">

                            <div class="talent">
                                <h2>Experience</h2>
                                <p><%=u.getExperience()%>
                                </p>
                            </div>
                            <div class="talent">
                                <h2>Age</h2>
                                <p><%=u.getAge()%>
                                </p>
                            </div>


                        </div>
                    </div>

                    <div class="yui-gf">
                        <div class="yui-u first">
                            <h2>Education Info</h2>
                        </div>
                        <div class="yui-u">
                            <div class="talent">
                                <h2>University</h2>
                                <p><%=u.getUniversity()%>
                                </p>
                            </div>

                            <div class="talent">
                                <h2>University Point</h2>
                                <p><%=u.getPoint()%>
                                </p>
                            </div>

                        </div>
                    </div>


                    <div class="yui-gf">
                        <div class="yui-u first">
                            <h2>Training Info</h2>
                        </div>
                        <div class="yui-u">

                            <div class="talent">
                                <h2>Teachway</h2>
                                <p><%=u.getTeachway().getTeachway()%>
                                </p>
                            </div>
                            <div class="talent">
                                <h2>Subject</h2>
                                <p><%=u.getSubject().getSubject()%>
                                </p>
                            </div>

                            <div class="talent">
                                <h2>Cost</h2>
                                <p><%=u.getCost()%>Azn</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
