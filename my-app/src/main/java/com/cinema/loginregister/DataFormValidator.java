package com.cinema.loginregister;

import com.cinema.model.User;
import com.cinema.service.UserService;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DataFormValidator {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailValidator emailValidator;

    public ValidationResult validate(LoginDataForm form){

        ValidationResult result = new ValidationResult();

        User user = userService.getUser(form.getEmail());

        if(user == null){
            result.getResults().put("incorrect-email", "");
        } else if (!form.getPassword().equals(user.getPassword())){
            result.getResults().put("incorrect-password", "");
        }

        return result;
    }

    public ValidationResult validate(RegisterDataForm form){
        ValidationResult result = new ValidationResult();

        User temp = userService.getUser(form.getEmail());
        if (temp != null) {
            result.getResults().put("user-exists", "");
        } else {
            if(form.getFirstName().length() < 3 || form.getFirstName().length() > 50){
                result.getResults().put("incorrect-firstname", "");
            }
            if (form.getLastName().length() < 3 || form.getLastName().length() > 50){
                result.getResults().put("incorrect-lastname", "");
            }
            if(!emailValidator.isValid(form.getEmail(), null)){
                result.getResults().put("incorrect-email", "");
            }
            if(!form.getPassword().equals(form.getConfirmpassword())){
                result.getResults().put("passwords-not-same","");
            }
            if(form.getPassword().length() < 8){
                result.getResults().put("incorrect-password", "");
            }
            if(form.getPhoneNumber().length() != 9){
                result.getResults().put("incorrect-phoneNumber", "");
            }
        }

        return result;
    }
}
