package com.example.review.controller;

import com.example.review.domain.Member;
import com.example.review.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/members/new", method = RequestMethod.GET)
    public String memberForm(){
        return "members/createMemberForm";
    }

    @RequestMapping(value = "/members/new", method = RequestMethod.POST)
    public String save(@RequestParam String name){

        Member newMember = new Member();
        newMember.setName(name);

        memberService.join(newMember);

        return "home";
    }

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public String memberList(Model model){

        List<Member> members = memberService.findMembers();

        model.addAttribute("members",members);

        return "members/memberList";
    }
}
