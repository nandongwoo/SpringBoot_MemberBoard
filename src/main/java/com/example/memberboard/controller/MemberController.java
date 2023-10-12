package com.example.memberboard.controller;

import com.example.memberboard.dto.MemberDTO;
import com.example.memberboard.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/save")
    public String save() {
        return "/memberPages/memberSave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) throws IOException {
        System.out.println(memberDTO.getMemberProfile());
        memberService.save(memberDTO);
        return "index";
    }

    @PostMapping("/login/")
    public String login(@ModelAttribute MemberDTO memberDTO) {
//        memberService.login(memberDTO);
        return "/boardPages/boardList";
    }


    @PostMapping("/findByEmail")
    public ResponseEntity findByEmail(@RequestBody MemberDTO memberDTO) {
        boolean result = memberService.findByEmail(memberDTO.getMemberEmail());
        if (result) {
            return new ResponseEntity<>("사용가능",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("사용불가능", HttpStatus.CONFLICT);
        }

    }

}
