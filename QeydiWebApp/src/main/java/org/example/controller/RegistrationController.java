package org.example.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.dao.impl.UserDaoImpl;
import org.example.dao.inter.UserDaoInter;
import org.example.entity.Subject;
import org.example.entity.Teachway;
import org.example.entity.User;
import org.example.main.Context;
import org.example.util.ControllerUtil;
import org.example.util.CustomVerifyer;

import java.io.IOException;

@WebServlet(name = "RegistrationController", value = "/registration")
public class RegistrationController extends HttpServlet {
    UserDaoInter userDao = Context.instanceUserDao();

    private static BCrypt.Verifyer verifyer = BCrypt.verifyer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            CustomVerifyer.passwordVerifyer(email, password);

            int userId = userDao.getIdByEmail(email);

            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String university = request.getParameter("university");
            String experience = request.getParameter("experience");
            String code = request.getParameter("code");
            int age = Integer.parseInt(request.getParameter("age"));
            int point = Integer.parseInt(request.getParameter("point"));
            int teachwayId = Integer.parseInt(request.getParameter("teachway"));
            int subjectId = Integer.parseInt(request.getParameter("subject"));
            double cost = Double.parseDouble(request.getParameter("cost"));

            User u = new User(userId, name, surname, age, university, point, experience, teachwayId, subjectId, code, cost);
            userDao.updateUser(u);

            response.sendRedirect("users");

        } catch (Exception ex) {
            ControllerUtil.errorMessage(response, ex);
        }
    }
}
