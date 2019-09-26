package com.huben.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author koishi
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "/index";
    }
}
