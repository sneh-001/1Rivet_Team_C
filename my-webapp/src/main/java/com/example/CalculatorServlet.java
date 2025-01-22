package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String expression = request.getParameter("expression");
        String result = "";

        try {
            // Evaluate the expression
            result = String.valueOf(eval(expression));
        } catch (Exception e) {
            result = "Error: " + e.getMessage();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Result: " + result + "</p>");
    }

    // Method to evaluate the expression
    private double eval(String expression) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        return (double) engine.eval(expression);
    }
}