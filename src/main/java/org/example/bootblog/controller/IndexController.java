package org.example.bootblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diary")
public class IndexController {

    @GetMapping
    public String form(Model model) {
        model.addAttribute("message", "곧 함");
        return "diary/form";
    }
}
