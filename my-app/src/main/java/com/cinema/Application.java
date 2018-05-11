package com.cinema;

import com.cinema.loginregister.DataFormValidator;
import com.cinema.manager.UserManager;
import com.cinema.service.UserService;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@EntityScan(
        basePackageClasses = {Application.class, Jsr310JpaConverters.class}
)

@SpringBootApplication
@ComponentScan(basePackages = "com.cinema")
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Java8TimeDialect java8TimeDialect(){
        return new Java8TimeDialect();
    }

    @Bean
    public DataFormValidator dataFormValidator(){
        return new DataFormValidator();
    }

    @Bean
    public EmailValidator emailValidator(){
        return new EmailValidator();
    }

    @Bean
    public UserService userService(){
        return new UserManager();
    }

}
