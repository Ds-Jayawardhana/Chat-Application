/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.tute8ans.tute8ans.resources;

import java.util.ArrayList;
import java.util.List;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author user
 */
@Path("/students")
public class StudentResource {
    private static final ConcurrentHashMap<String,Student> studentStore = new ConcurrentHashMap<>();

    static {
        addInitialStudents();
    }
    
    private static void addInitialStudents() {
        Student student1 = new Student(UUID.randomUUID().toString(), "Alice", "Smith");
        Student student2 = new Student(UUID.randomUUID().toString(), "Bob", "Johnson");
        Student student3 = new Student(UUID.randomUUID().toString(), "Charlie", "Brown");
         
        studentStore.put(student1.getId(), student1);
        studentStore.put(student2.getId(), student2);
        studentStore.put(student3.getId(), student3);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudent() {
        return new ArrayList<>(studentStore.values());
    } 
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentById(@PathParam("id") String id) {
       Student student = studentStore.get(id);
       if (student != null) {
           return Response.ok(student).build();
       } else {
           return Response.status(Response.Status.NOT_FOUND)
                   .entity("Student Not Found for ID: " + id)
                   .build();
       }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudent(Student student) {
        if (student.getFirstName() == null && student.getLastName() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("First Name and Last Name are Required")
                    .build();
        } else {
            String id = UUID.randomUUID().toString();
            student.setId(id);
            studentStore.put(id, student);
        }
        
        return Response.status(Response.Status.CREATED)
                .entity("New Student Created with ID: " + student.getId())
                .build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudent(@PathParam("id") String id, Student updatedStudent) {
        Student existingStudent = studentStore.get(id);
        
        if (existingStudent == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Student not found with ID: " + id)
                    .build();
        }
        
        if (updatedStudent.getFirstName() != null) {
            existingStudent.setFirstName(updatedStudent.getFirstName());
        }
        
        if (updatedStudent.getLastName() != null) {
            existingStudent.setLastName(updatedStudent.getLastName());
        }
        
        studentStore.put(id, existingStudent);
        return Response.ok(existingStudent).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") String id) {
        Student student = studentStore.remove(id);
        
        if (student != null) {
            return Response.status(Response.Status.NO_CONTENT)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Student with ID: " + id + " Not Found in the Student List")
                    .build();
        }
    }
}