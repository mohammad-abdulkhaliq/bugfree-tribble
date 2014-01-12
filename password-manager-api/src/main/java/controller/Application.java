package controller;

import model.Account;
import model.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import service.Accounts;
import service.Users;

import javax.annotation.PostConstruct;

import java.util.ArrayList;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {




        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public static void init() {
        /* Mock Data */
    Users.init();
    Users.get().add(new User(Users.generateUserId(), "5ela", "12345"));

    Accounts.init();;
    Accounts.get().put(Users.get().get(0).getId(), new ArrayList<Account>());
    Accounts.get().get(0).add(new Account(Accounts.generateAccountId() ,"facebook", "mk1993329"));

    }
}