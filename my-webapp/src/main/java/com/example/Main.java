package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        // Start the Jetty server
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Add the CalculatorServlet
        context.addServlet(new ServletHolder(new CalculatorServlet()), "/calculate");

        // Serve static files (like index.html)
        context.setResourceBase("src/main/webapp");
        context.addServlet(new ServletHolder(new org.eclipse.jetty.servlet.DefaultServlet()), "/");

        // Start the server
        server.start();
        System.out.println("Server started at http://localhost:8080");
        server.join();
    }
}