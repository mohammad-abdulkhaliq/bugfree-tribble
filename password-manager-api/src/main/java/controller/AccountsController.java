package controller;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import model.Account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.Accounts;

@Controller
@RequestMapping("/accounts")
public class AccountsController {



    @RequestMapping("/all")
    public @ResponseBody
    ArrayList<Account> accounts(@RequestParam(value="userId", required=true) String userId) {
        //return new Greeting(counter.incrementAndGet(), String.format(template, name));

        int user_id = Integer.parseInt(userId);
        return Accounts.get().containsKey(user_id) ? Accounts.get().get(user_id) : null;
    }


    @RequestMapping("/create")
    public @ResponseBody
    Account create(@RequestParam(value="userId", required=true) String userId, @RequestParam(value="account", required=true) String account, @RequestParam(value="password", required=true) String password, @RequestParam(value="link", required=false) String link) {
        //return new Greeting(counter.incrementAndGet(), String.format(template, name));

        int user_id = Integer.parseInt(userId);
        int account_id = Accounts.generateAccountId();
        Accounts.get(user_id).add(new Account(account_id, account, password));

        return Accounts.get(user_id, account_id);
    }

    @RequestMapping("/remove")
    public @ResponseBody
    void remove(@RequestParam(value="userId", required=true) String userId, @RequestParam(value="accountId", required=true) String accountId ) {
        //return new Greeting(counter.incrementAndGet(), String.format(template, name));

        int user_id = Integer.parseInt(userId);
        int account_id = Integer.parseInt(accountId) ;

        Accounts.remove(user_id, account_id);

    }
}
