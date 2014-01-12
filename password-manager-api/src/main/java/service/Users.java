package service;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;

import model.User;

/**
 * Created by mohammad-abdulkhaliq on 1/4/14.
 */
public class Users{

    private static int USER_ID;
    private static ArrayList<User> CACHE;

    public static void init() {
        USER_ID = 0;
        CACHE = new ArrayList<User>();
    }

    public static ArrayList<User> get() {
        return CACHE;
    }

    public static int search(String email, String password) {

        User u = new User(email, password);
        int index = Collections.binarySearch(CACHE, u);
        if(index < 0)
            return -1;

        return CACHE.get(index).getId();

//        for(User u : CACHE)
//            if(u.getEmail().equals(email) && u.getPassword().equals(password))
//                return u.getId();

//        return -1;
    }
    
    public static User search(String email) {

        for(User u : CACHE)
            if(u.getEmail().equals(email))
                return u;

        return null;
    }

    public static int generateUserId() {

        return USER_ID++;
    }

}
