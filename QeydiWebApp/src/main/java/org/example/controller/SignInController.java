package org.example.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.example.dao.inter.UserDaoInter;
import org.example.entity.User;
import org.example.main.Context;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.util.ControllerUtil;
import org.example.util.CustomVerifyer;


import java.io.IOException;

@WebServlet(name = "SignInController", value = "/sign-in")
public class SignInController extends HttpServlet {
    private UserDaoInter userDao = Context.instanceUserDao();
    private static BCrypt.Verifyer verifyer = BCrypt.verifyer();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = userDao.getByEmail(email);

            if (user == null) {
                throw new IllegalArgumentException("Istifadeci tapilmadi");
            }

            BCrypt.Result rs = verifyer.verify(password.toCharArray(), user.getPassword().toCharArray());
            if (!rs.verified) {
                throw new IllegalArgumentException("Parol yanlishdir");
            }

            request.getSession().setAttribute("loggedInUser", user);
            response.sendRedirect("users");

        } catch (Exception ex) {
            ControllerUtil.errorMessage(response, ex);
        }
    }
}
