package com.tmp;

import org.eclipse.jetty.ee10.webapp.WebAppContext;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.ProtectionDomain;

public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            LOG.error("Cannot start server app", e);
            System.exit(1);
        }
    }

    private static void run() throws Exception {
        final Server          server    = new Server();
        final ServerConnector connector = new ServerConnector(server);
        connector.setPort(1221);
        server.addConnector(connector);

        final WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/abc");

        final ProtectionDomain protectionDomain   = App.class.getProtectionDomain();
        final String           classesLocationUrl = protectionDomain.getCodeSource().getLocation().toExternalForm();
        LOG.info("classesLocationUrl original = {}", classesLocationUrl);
        webAppContext.setWar(classesLocationUrl);
        server.setHandler(webAppContext);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                server.stop();
                server.join();
            } catch (Exception e) {
                LOG.error("Cannot stop server", e);
            }
        }));

        LOG.info(">>> STARTING EMBEDDED JETTY SERVER");
//            server.setDumpAfterStart(true);
        server.start();
        server.join();
    }

}
