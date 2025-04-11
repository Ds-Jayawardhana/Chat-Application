/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.tute7.tute7answers.resources;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author user
 */
@Path("/hello")
public class HelloWorldResources {
    // Static list to store users
    private static final Map<Integer, User>users =new HashMap<>();

    // Static block to initialize users



    
    
    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public User getUserById(@PathParam("userID")int userId){
            
        }
    
 }

