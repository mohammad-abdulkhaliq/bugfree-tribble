package controller;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import model.Account;
import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.Accounts;
import service.Users;

@Controller
@RequestMapping("/users")
public class UsersController {



    @RequestMapping("/signIn")
    public @ResponseBody User signIn(@RequestParam(value="email", required=true) String email, @RequestParam(value="password", required=true) String password ) {

        int user_id = Users.search(email, password);
        if(user_id == -1)
            return new User("Login Failure", "-1");

        return new User(user_id, "Login Sucess", "xxxxx");
    }

    @RequestMapping("/signUp")
    public @ResponseBody User signUp(@RequestParam(value="email", required=true) String email, @RequestParam(value="password", required=true) String password ) {

        int user_id = Users.search(email, password);
        if(user_id != -1)
            return new User("SignUp Failure", "-1");

        User u = new User(Users.generateUserId(), email, password);
        Users.get().add(u);
        Accounts.get().put(u.getId(), new ArrayList<Account>());

        return new User(u.getId(),"SignUp Sucess", "xxxxx");
    }

}
