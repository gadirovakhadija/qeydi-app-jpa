package org.example.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.dao.inter.UserDaoInter;
import org.example.entity.User;
import org.example.main.Context;

import java.io.IOException;

@WebServlet(name = "SignupController", value = "/sign-up")
public class SignUpController extends HttpServlet {
    private UserDaoInter userDao = Context.instanceUserDao();
    private static BCrypt.Verifyer verifyer = BCrypt.verifyer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userId = 1;
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User u = new User(userId,name, surname, email, password);
            userDao.addUser(u);

            response.sendRedirect("users");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
