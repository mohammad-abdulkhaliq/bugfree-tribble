package service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

import model.Account;

/**
 * Created by mohammad-abdulkhaliq on 1/4/14.
 */
public class Accounts {

    private static int ACCOUNT_ID;
    private static Hashtable<Integer, ArrayList<Account>> CACHE;

    public static void init() {
        ACCOUNT_ID = 0;
        CACHE = new Hashtable<Integer, ArrayList<Account>>();
    }

    public static Hashtable<Integer, ArrayList<Account>> get() {
        return CACHE;
    }

    public static ArrayList<Account> get(int user_id) {

        return CACHE.get(user_id);
    }

    public static Account get(int user_id, int account_id) {


        int i = Collections.binarySearch(CACHE.get(user_id), new Account(account_id,"",""));

        return CACHE.get(user_id).get(i);
    }

    public static void remove(int user_id, int account_id) {
        int i = Collections.binarySearch(CACHE.get(user_id), new Account(account_id,"",""));
        CACHE.get(user_id).remove(i);
    }

    public static int generateAccountId() {

        return ACCOUNT_ID++;
    }
}
