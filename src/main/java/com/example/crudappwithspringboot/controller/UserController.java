package com.example.crudappwithspringboot.controller;

import com.example.crudappwithspringboot.model.User;
import com.example.crudappwithspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value ="/")
    public String openStartPage(ModelMap model) {
        List<User> users = userService.findAllUsers();


        model.addAttribute("users", users);
        return "/index";
    }

    @GetMapping("addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "/addUser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.findUserById(id));
        return "editUser";
    }

//    @PatchMapping("/{id}")
//    public String updateUpdate(@ModelAttribute("user") User user, @PathVariable("id") long id) {
//        userService.updateUser(id, user);
//        return "redirect:/";
//    }

    @PutMapping("/{id}")
    public String updateUpdate(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }
}
