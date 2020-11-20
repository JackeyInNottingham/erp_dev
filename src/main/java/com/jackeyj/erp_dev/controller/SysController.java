package com.jackeyj.erp_dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jiyaofei
 */
@Controller
@RequestMapping("/sys")
public class SysController {


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
