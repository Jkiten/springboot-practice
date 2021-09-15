package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemverService memverService ;

    @Autowired
    public MemberController(MemverService memverService){
        this.memverService = memverService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memverService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memverService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
