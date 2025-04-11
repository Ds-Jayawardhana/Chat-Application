/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.tute7.tute7answers.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author user
 */
@Path("/hello")
public class HelloWorldResources {
    // Static list to store users
    private static final Map<Integer, User>users =new HashMap<>();

    // Static block to initialize users
    static{
         users.put(1,new User(1,"bob"));
          users.put(2,new User(2,"John"));
           users.put(3,new User(3,"Doe"));
    
    }
       
   
    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getUserById(@PathParam("userId")int userId){
           User user = users.get(userId);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("User with ID " + userId + " not found")
                           .build();
        }
        return Response.ok(user).build();
    }
    
    
    

    @GET
    @Path("/allusers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}