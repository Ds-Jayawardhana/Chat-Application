/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.tute8ans.tute8ans.resources;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author user
 */
@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(StudentResource.class);
    }
    
}
