package fi.academy.todomon.controller;

import fi.academy.todomon.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class TodomonController {

//    @Autowired
//    private UsersRepository repo;

//    @RequestMapping(value = "/hellosecurity")
//    public String helloSecurity() {
//        return "annintesti";
//    }
//
//    @GetMapping(value = "/login")
//    public String customLogin() {
//
//        return "customlogin";
//    }
//
//    @PostMapping("/login")
//    public String pirkkaSisaan() {
//        return "redirect:/annintesti.html";
//    }

//    @GetMapping(value="/")
//    public String home(){
//        return "home";
//    }
//
//    @GetMapping(value="/user")
//    public String user(){
//        return "annintesti";
//    }
//
//    @GetMapping(value="/admin")
//    public String admin(){
//        return "annintesti";
//    }
//
//    @GetMapping(value="/login")
//    public String login(){
//        return "customlogin";
//    }
//
//    @GetMapping(value="/403")
//    public String Error403(){
//        return "403";
//    }
//
////    @PostMapping(value="/login")
////    public String login() {
////        return:redirect
////    }
@RequestMapping(value="/")
public String home(){
    return "home";
}

    @RequestMapping(value="/user")
    public String user(){
        return "annintesti";
    }

    @RequestMapping(value="/admin")
    public String admin(){
        return "annintesti";
    }

    @GetMapping(value="/login")
    public String login(){
        return "customlogin";
    }

    @PostMapping(value="/login")
    public String forward() {
        System.out.println("mitä vittua");
    return "redirect:/annintesti";
    }

    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
}






