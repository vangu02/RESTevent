
package com.ca.field.restevent;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.threadpool.ThreadPoolConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the REST2UIM HTTP server will listen on
    public static final String BASE_URI = "http://192.168.1.5:8080/REST/";

    /**
     * @return REST2UIM HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.ca.field.restevent package
        final ResourceConfig rc = new ResourceConfig().packages("com.ca.field.restevent");
 
        // create and start a new instance of http server
        // exposing the Jersey application at BASE_URI
         HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
        //HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc, false);
        //server.getListener("UIMREST").getTransport().getAsyncQueueIO();
        
       // ThreadPoolConfig tpConfig = null;
       // ThreadPoolConfig.defaultConfig() .setPoolName("App1Pool") .setCorePoolSize(5) .setMaxPoolSize(10);
        
        // server.getListener("UIMREST").getTransport().setKernelThreadPoolConfig(ThreadPoolConfig.defaultConfig() .setPoolName("App1Pool") .setCorePoolSize(5) .setMaxPoolSize(10)); 

        //org.glassfish.grizzly.Transport.getWorkerThreadPool();
        return server;
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("REST2event app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.shutdown();
        //server.stop();
    }
}

