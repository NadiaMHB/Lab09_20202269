package org.example.lab9_20202269.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lab9_20202269.beans.Usuario;
import org.example.lab9_20202269.daos.UsuarioDao;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action") != null ? "logout" : "login";
        if (action.equals("logout")) {
            HttpSession httpSession = request.getSession();
            request.getSession().invalidate();
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");
        UsuarioDao usuarioDao = new UsuarioDao();

        if (usuarioDao.validarUsuarioPassword(username, password)) {

            Usuario usuario1 = usuarioDao.obtenerUsuario(username);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("userSession", usuario1);
            System.out.println("Correo y contraseña válidos");
            int IdRol = usuario1.getRol_idrol();
            switch (IdRol) {
                case 1:
                    response.sendRedirect(request.getContextPath() + "/UsuarioOperativoServlet");
                    break;
                case 2:
                    response.sendRedirect(request.getContextPath() + "/AdminServlet");
                    break;
                case 3:
                    response.sendRedirect(request.getContextPath());
            }
        } else {
            System.out.println("Usuario o contraseña inválidos");
            request.setAttribute("err", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
}