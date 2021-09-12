package com.example.demo.controller;

import com.example.demo.service.MemverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemverService memverService ;

    @Autowired
    public MemberController(MemverService memverService){
        this.memverService = memverService;
    }
}
