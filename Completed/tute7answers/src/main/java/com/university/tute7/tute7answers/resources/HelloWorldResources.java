/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.tute7.tute7answers.resources;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author user
 */
@Path("/hello")
public class HelloWorldResources {
    // Static list to store users
    private static final List<User> users = new ArrayList<>();

    // Static block to initialize users
    static {
        users.add(new User(1, "Alice Smith", "alice.smith@example.com"));
        users.add(new User(2, "Bob Johnson", "bob.johnson@example.com"));
        users.add(new User(3, "Carol Williams", "carol.williams@example.com"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return users;
    }
}