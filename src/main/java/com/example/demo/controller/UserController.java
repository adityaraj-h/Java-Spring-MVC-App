package com.example.demo.controller;

// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.model.UserDocument;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Controller
public class UserController{

    @Autowired
    private UserService userService;

    @Autowired
    private SolrClient solrClient;

    @GetMapping("/")
    @ResponseBody
    public String home(){
        return "Welcome to Delicacy";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        return String.format("Hello %s!", name);
    }


    // Lists all users
    @GetMapping("/users")
    public String listUsers(Model model){
        List<User>users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    //deletes data from db and UI
    @GetMapping("/users/delete/confirm/{id}")
    public String deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    //Shows form for user creation
    @GetMapping("users/new")
    public String showCreateForm(Model model){
        model.addAttribute("user", new User());
        return "user_form";
    }

    //Handles create User
    @PostMapping("/users")
    public String registerUser(@ModelAttribute User user){
        userService.createUser(user);
        return "redirect:/users";
    }

    // Show update form
    @GetMapping("users/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        User user = userService.getUserById(id);
        //debug statement for date issue
        System.out.println("DOB: " + user.getDob());
        model.addAttribute("user", user);
        return "user_form";
    }

    //Handles update user
    @PostMapping("/users/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user){
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/users";
    }

    //Handles searching of a user by name,id,email
    
    @GetMapping("/users/search")
    public String searchUsers(
        @RequestParam(required = false) String id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String contact,
        Model model) throws SolrServerException, IOException {

        // Build Solr query string based on non-null parameters
        StringBuilder query = new StringBuilder();
        SolrQuery solrQuery = new SolrQuery();

        if (id != null && !id.isEmpty()) query.append("id:").append(id).append(" ");
        if (name != null && !name.isEmpty()) query.append("name:").append(name).append(" ");
        if (email != null && !email.isEmpty()) query.append("email:").append(email).append(" ");
        if (contact != null && !contact.isEmpty()) query.append("contact:").append(contact).append(" ");
        if (!query.isEmpty()) query = new StringBuilder(String.join(" AND ", query));

        // Use SolrJ to query Solr
        
        String q = query.toString().trim();
        if (q.isEmpty()) q = "*:*";
        solrQuery.set("q", q);
        solrQuery.set("wt", "json");
        solrQuery.set("indent", "true");
        solrQuery.set("wt", "json");
        QueryResponse response = solrClient.query("users", solrQuery);
        List<UserDocument> results = response.getBeans(UserDocument.class);

        model.addAttribute("results", results);
        return "search_results"; // This is the name of your results page
    }
    
}