package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
    @RequestMapping("main")
    public String showMain(){
        return "main";
    }
    @RequestMapping("test")
    public String test(){
        return "";
    }
}
