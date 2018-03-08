package com.crud.tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class StaticWebPageController {

    @RequestMapping("/")
    public String index(Map<String,Object> model) {
        model.put("variable","My thymeleaf variable");
        model.put("two",2);
        model.put("minusTwo", -2);
        //model.put("one",1);
        model.put("multiply","*");
        model.put("equals","=");
        model.put("plus","+");
        model.put("minus","-");
        return "index";
    }
}
