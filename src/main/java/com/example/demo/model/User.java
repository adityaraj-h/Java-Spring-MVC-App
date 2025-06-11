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

    public Long getid(){return id;}
    public void setid(Long id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public LocalDate getDob(){return dob;}
    public void setDob(LocalDate dob){this.dob=dob;}

    public String getContact(){return contact;}
    public void setContact(String contact){this.contact=contact;}

    public String getEmail(){return email;}
    public void setId(String email){this.email=email;}

}