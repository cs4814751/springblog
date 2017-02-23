package com.leibro.controller;

import com.leibro.service.VisitService;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by leibro on 2017/1/1.
 */
@Controller
public class HomeController {
    @Autowired
    VisitService visitService;

    @RequestMapping("/")
    public String test(Model model) {
        visitService.getBlogsForHomeByOffset(model,0);
        visitService.getHotestBlogs(model);
        visitService.getHotestTags(model);
        return "home";
    }

    @RequestMapping("/home")
    public String visitHome(Model model) {
        visitService.getBlogsForHomeByOffset(model,0);
        visitService.getHotestBlogs(model);
        visitService.getHotestTags(model);
        return "home";
    }

    @RequestMapping(value = "/home",params = {"offset"})
    public String visitHomeWithOffset(Model model, @RequestParam("offset") int offset) {
        visitService.getBlogsForHomeByOffset(model,offset);
        return "home :: #card-wrapper";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login",params = {"error"})
    public String loginError(Model model) {
        model.addAttribute("error",true);
        return "login";
    }

    @RequestMapping("/404")
    public String pageNotFound() {
        return "404";
    }

    @RequestMapping("/error")
    public String internalError() {
        return "error";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
