package com.softserve.service;

import com.softserve.models.User;
import com.softserve.utilities.DataBaseUtilities;
import org.apache.commons.codec.digest.DigestUtils;

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

    public static boolean existsEmail(String email) {
        try {
            DataBaseUtilities.getUsersDao()
                    .getByEmail(email);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public static boolean existsNickname(String nickname) {
        try {
            DataBaseUtilities.getUsersDao()
                    .getByNickname(nickname);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public static String encryptPassword(String password) {
        return DigestUtils.md5Hex(password);
    }
}
