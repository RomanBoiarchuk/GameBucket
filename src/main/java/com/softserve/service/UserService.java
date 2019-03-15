package com.softserve.service;

import com.softserve.models.User;
import com.softserve.utilities.DataBaseUtilities;

public class UserService {

    public static boolean authenticate(String email, String password) {
        boolean userFound = true;
        try {
            User user = DataBaseUtilities.getUsersDao()
                    .getByEmail(email);
            if (!user.getPassword().trim().equals(password.trim())) {
                userFound = false;
            }
        } catch (IllegalArgumentException ex) {
            userFound = false;
        }
        return userFound;
    }

}
