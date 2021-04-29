package com.example.demo.controller.member;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    private static final Logger log =
            LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService service;

    @GetMapping("/register")
    public String getMemberRegister(Member member) {
        log.info("getMemberRegister()");

        return "spring/member/register";
    }

    @PostMapping("/register")
    public String doMemberRegister(Member member, Model model)
            throws Exception {
        log.info("doMemberRegister()");

        service.register(member);

        model.addAttribute("msg",
                "회원 가입 완료");

        return "spring/member/success";
    }
}
