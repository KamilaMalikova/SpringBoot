package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;

@Controller
@RequestMapping("/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @PostMapping(value="/add")
    public String addNewUser(
            @ModelAttribute User user
            //@RequestParam String name, @RequestParam String email
    ){
//        System.out.println(name+" "+email);
//        User n = new User();
//        n.setName(name);
//        n.setEmail(email);
        userRepository.save(user);
        return "redirect:/demo/all";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        Iterable<User> users = userRepository.findAll();
        for (User user: users) {
            System.out.println(user);
        }
        return userRepository.findAll();
    }
}
