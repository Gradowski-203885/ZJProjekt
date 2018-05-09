package com.cinema.controller;

import com.cinema.loginregister.DataFormValidator;
import com.cinema.loginregister.RegisterDataForm;
import com.cinema.loginregister.ValidationResult;
import com.cinema.model.User;
import com.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataFormValidator dataFormValidator;

    @RequestMapping("/register-page")
    public String index(){
        return "register-page";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute("registerform")RegisterDataForm form){
        ValidationResult result = dataFormValidator.validate(form);

        if(result.getResults().containsKey("user-exists")){
            return "redirect:/register-page?exists=true";
        }

        if (result.getResults().containsKey("incorrect-firstname")
                || result.getResults().containsKey("icorrect-lastname")
                || result.getResults().containsKey("incorrect-email")
                || result.getResults().containsKey("icorrect-password")
                || result.getResults().containsKey("incorrect-phoneNumber")){
            return "redirect:/register-page?data=true";
        }

        if (result.getResults().containsKey("passwords-not-same")){
            return "redirect:/register-page?passwords=true";
        }

        User user = new User();
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPhoneNumber(form.getPhoneNumber());
        user.setPassword(form.getPassword());

        userService.addUser(user);

        return "main";
    }
}
