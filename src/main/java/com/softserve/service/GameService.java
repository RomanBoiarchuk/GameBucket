package com.softserve.service;

import com.softserve.utilities.DataBaseUtilities;

public class GameService {

    public static boolean gameExists(long gameId) {
        try {
            DataBaseUtilities.getGamesDao().getById(gameId);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
