package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) {
        AllRequestsServlet frontend = new AllRequestsServlet();


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(frontend), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        try {
            server.start();
            java.util.logging.Logger.getGlobal().info("Server started");
            server.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}