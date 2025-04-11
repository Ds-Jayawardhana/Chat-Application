/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.tute7.tute7answers.resources;

/**
 *
 * @author user
 */
public class User {
    private int userId;
    private String userName;


    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;

    }

    // Getters and setters
    public int getId() {
        return userId;
    }

    public void setId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    
}
