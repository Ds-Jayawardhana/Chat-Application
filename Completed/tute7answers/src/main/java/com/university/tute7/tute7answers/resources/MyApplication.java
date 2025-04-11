package com.university.tute7.tute7answers.resources;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(HelloWorldResources.class);
    }
}