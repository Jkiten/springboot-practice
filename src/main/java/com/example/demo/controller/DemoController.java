package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name")String name, Model model) {
        model.addAttribute("name", name);
        return "hello-mvc";
    }

    @GetMapping("hello-api")
    @ResponseBody
    public User helloApi(@RequestParam("name")String name){
        User user = new User();
        user.setName(name);
        return user;
    }

    static class User{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
