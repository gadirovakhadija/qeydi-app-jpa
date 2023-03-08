package org.example.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.dao.inter.UserDaoInter;
import org.example.entity.User;
import org.example.main.Context;
import org.example.util.ControllerUtil;
import org.example.util.CustomVerifyer;

import java.io.IOException;

@WebServlet(name = "ResetController", value = "/reset")
public class ResetController extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();
    private static BCrypt.Verifyer verifyer = BCrypt.verifyer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("reset.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            CustomVerifyer.passwordVerifyer(email, password);

            int userId = userDao.getIdByEmail(email);

            String new1Password = request.getParameter("new1Password");
            String new2Password = request.getParameter("new2Password");

            if (!new1Password.equals(new2Password)) {
                throw new IllegalArgumentException("Yeni parollar eynileshmir");
            }
            User u = new User(userId, new2Password);
            userDao.updatePassword(u);

            response.sendRedirect("users");

        } catch (Exception ex) {
            ControllerUtil.errorMessage(response, ex);

        }
    }
}
