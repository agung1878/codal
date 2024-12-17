package com.elearning.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/course")
public class CourseController {

    @GetMapping("/list")
    public String list() {
        return "course/list";
    }

}
