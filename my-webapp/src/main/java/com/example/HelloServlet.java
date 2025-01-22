package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private String userName;

    public HelloServlet(String userName) {
        this.userName = userName;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // HTML output with a red container
        out.println("<html><head>");
        out.println("<style>");
        out.println(".red-container {");
        out.println("    background-color: blue;");
        out.println("    color: white;");
        out.println("    padding: 20px;");
        out.println("    border-radius: 5px;");
        out.println("    text-align: center;");
        out.println("}");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<div class='red-container'>");
        out.println("<h1>Hello, " + userName + "!</h1>");
        out.println("</div>");
        out.println("</body></html>");
    }
}