/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.tute7.tute7answers.resources;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author user
 */
@ApplicationPath("rest")
public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes =new HashSet<>();
        classes.add(HelloWorldResources.class);
        return classes;
   
    
            
        }
    
    public class MyApplicationConfig extends ResourceConfig {
    public MyApplicationConfig() {
        register(HelloWorldResources.class);
    }
    
}
}
