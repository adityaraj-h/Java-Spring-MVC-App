package com.example.demo.controller;

// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;



@Controller
public class UserController{

    @Autowired
    private UserService userService;

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

    
}