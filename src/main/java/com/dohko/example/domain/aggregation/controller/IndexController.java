package com.dohko.example.domain.aggregation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luxiaohua
 * @create 2021-09-07 11:35
 */
@Controller
public class IndexController {


    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("slogan", "Hello, human!");
        return "index";
    }
}
