package com.example.demo.model;

import java.time.LocalDate;
public class User{
    
    private Long id;
    private String name;
    private LocalDate dob;
    private String contact;
    private String email;

    User(Long id,String name, LocalDate dob, String contact, String email ){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.contact = contact;
        this.email = email;

    }

    // No argument constructor to create an empty User object to bind form fields.
    public User(){}

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public LocalDate getDob(){return dob;}
    public void setDob(LocalDate dob){this.dob=dob;}

    public String getContact(){return contact;}
    public void setContact(String contact){this.contact=contact;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

}