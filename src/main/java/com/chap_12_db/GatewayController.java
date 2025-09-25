package com.chap_12_db;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@WebServlet("/execute")
public class GatewayController extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = getServletContext();

        String statement=req.getParameter("statement");
        GatewayDAO gatewayDAO=new GatewayDAO();
        String result = gatewayDAO.executeStatement(statement);


        req.setAttribute("result", result);
        req.setAttribute("statement", statement);

        sc.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
