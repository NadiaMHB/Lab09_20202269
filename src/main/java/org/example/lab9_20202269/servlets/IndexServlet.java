package org.example.lab9_20202269.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab9_20202269.daos.UsuarioDao;

import java.io.IOException;

@WebServlet(name = "IndexServlet", urlPatterns = {"/IndexServlet", ""})
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;

        UsuarioDao usuarioDao = new UsuarioDao();

        switch (action) {
            case "lista":
                request.setAttribute("listarUsuarios", usuarioDao.listarUsuarios());
                view = request.getRequestDispatcher("listaUsuarios.jsp");
                view.forward(request, response);
                break;
        }
    }
}
