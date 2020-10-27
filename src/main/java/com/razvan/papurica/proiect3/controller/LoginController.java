package com.razvan.papurica.proiect3.controller;

import com.razvan.papurica.proiect3.entity.User;
import com.razvan.papurica.proiect3.security.SecurityAuthorizer;
import com.razvan.papurica.proiect3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @GetMapping("/")
    public String redirectToLogin() {
        if(!SecurityAuthorizer.isUserAuthenticated())
            return "redirect:/login";

        return "redirect:/medic";
    }

    @GetMapping("/login")
    public ModelAndView showLogin(ModelAndView model) {
        model.setViewName("login/login");
        return model;
    }

    @PostMapping("/processLogin")
    public String processLogin(HttpServletRequest request) {
        Map<String, String[]> formRequestMap = request.getParameterMap();
        String[] usernameArr = null;
        String[] passwordArr = null;

        for(Map.Entry<String, String[]> entry : formRequestMap.entrySet()) {
            if(entry.getKey().equals("username"))
                usernameArr = entry.getValue();
            if(entry.getKey().equals("password"))
                passwordArr = entry.getValue();
        }

        assert usernameArr != null;
        String username = usernameArr[0];
        assert passwordArr != null;
        String password = SecurityAuthorizer.encrypt(passwordArr[0]);

        boolean isLoginValid = userService.checkLogin(username, password);

        System.out.println(isLoginValid);

        if(isLoginValid) {
            return "redirect:/medic";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/showRegister")
    public ModelAndView showRegister(ModelAndView model) {
        User user = new User();
        model.addObject("newUser", user);
        model.setViewName("login/register");
        return model;
    }

    @PostMapping("/processRegister")
    public String processRegister(@ModelAttribute("newUser") User user) {
        userService.addUser(user);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityAuthorizer.unsetUser();
        return "redirect:/login";
    }

}
