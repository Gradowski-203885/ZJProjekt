package com.cinema.controller;

import com.cinema.loginregister.DataFormValidator;
import com.cinema.loginregister.LoginDataForm;
import com.cinema.loginregister.ValidationResult;
import com.cinema.model.User;
import com.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataFormValidator dataFormValidator;

    @RequestMapping("/login-page")
    public String index(){
        return "login-page";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model,
                        HttpServletRequest request,
                        @ModelAttribute("loginform")LoginDataForm form){

        ValidationResult result = dataFormValidator.validate(form);
        if(!result.getResults().isEmpty()){
            return "redirect:/login-page?error=true";
        }

        User user = userService.getUser(form.getEmail());
        model.addAttribute("user", user);
        request.getSession().setAttribute("user", user);
        return "main";
    }

    @RequestMapping(value = "/logout-page")
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("user", null);
        return "main";
    }
}
