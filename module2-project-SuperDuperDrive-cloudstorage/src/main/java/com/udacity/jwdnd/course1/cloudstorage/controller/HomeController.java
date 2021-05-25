package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final UserService userService;
    private final static String default_view = "home";

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getHomePage(Model model, RedirectAttributes redirectAttributes, Authentication authentication){
        String username = authentication.getName();
        User user = userService.getUser(username);

        model.addAttribute("username", user.getUsername());
        return default_view;
    }
}
