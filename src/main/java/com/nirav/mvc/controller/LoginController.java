package com.nirav.mvc.controller;

import com.nirav.mvc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String displayLoginPage() {
        System.out.println("Inside displayLoginPage");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String performLogin(@RequestParam(name = "name") String name, @RequestParam(name = "password") String password, ModelMap modelMap) {
        System.out.println("Inside performLogin");
        if (loginService.validateLogin(name, password)) {
            modelMap.addAttribute("name", name);
            modelMap.addAttribute("password", password);
            return "welcome";
        }
        modelMap.addAttribute("error", "You entered Invalid Credentials!");
        return "login";
    }

}
