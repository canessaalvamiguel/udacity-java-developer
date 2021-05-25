package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.helpers.SignupTextHelper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.SignupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private final SignupService userService;
    private final static String default_view = "signup";

    public SignupController(SignupService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String signupView(){
        return default_view;
    }

    @PostMapping()
    public String signupUser(@ModelAttribute User user, Model model){
        String signupError = null;

        if(!userService.isUserNameAvailable(user.getUsername())){
            signupError = SignupTextHelper.signupError_userExists;
        }

        if(signupError == null){
            int rowsAdded = userService.createUser(user);
            if(rowsAdded < 0){
                signupError = SignupTextHelper.signupError_standarError;
            }
        }

        if(signupError == null){
            model.addAttribute(SignupTextHelper.signupModel_success,true);
        }else{
            model.addAttribute(SignupTextHelper.signupModel_error, signupError);
        }

        return default_view;
    }
}
