package org.spring.security01.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.spring.security01.dto.MemberDto;
import org.spring.security01.service.MemberServ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;

@Log4j2
@Controller
@RequiredArgsConstructor
public class MemberControl {

    private final MemberServ memberServ;
    @GetMapping("/join")
    public String join(Model model){
        model.addAttribute("memberDto", new MemberDto());
        return "join";
    }
    @PostMapping("/join")
    public String joinOk(@Valid MemberDto memberDto, BindingResult result) throws IOException {
        if(result.hasErrors()){
            return "join";
        }
        memberServ.insertNew(memberDto);
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

//    @PostMapping("/fail")
//    public String fail(){
//        return "index";
//    }
//    --> This method is tied to .failureForwardUrl in webSecurityConfig
//        when there's a rather a '.failureUrl', it doesn't need.

    @GetMapping("/loginIndex")
    public String loginIndex(){
        return "loginIndex";
    }

    @GetMapping("/admin")
    public String admin(){return "admin";}

    @GetMapping("/manager")
    public String manager(){
        return "manager";
    }

    @GetMapping("/member")
    public String member(){
        return "member";
    }
}
