package com.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/member")
public class FeedController {

    @GetMapping("/feed")
    public String feed() {
        return "member/feed";
    }

}
