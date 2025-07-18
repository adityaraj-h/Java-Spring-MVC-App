package com.example.demo.model;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;


public class UserDocument {
    @Field
    private String id;

    @Field
    private String name;

    @Field
    private String email;

    @Field
    private String contact;

    @Field
    private Date dob;

    // Constructors
    public UserDocument() {}

    public UserDocument(String id, String name, String email, String contact, Date dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.dob = dob;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
}



