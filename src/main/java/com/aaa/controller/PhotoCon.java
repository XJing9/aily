package com.aaa.controller;

import com.aaa.dao.PhotoDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("PhotoCon")
public class PhotoCon {
    @Resource
    PhotoDao photoDao;
    @RequestMapping("queryAll")
    public String queryAll(Model model){
        return "";
    }
}
