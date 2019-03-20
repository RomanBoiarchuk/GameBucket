package com.softserve.servlets;

import com.softserve.models.Game;

import java.util.Set;

public interface GamesGetter {
    Set<Game> getGames(long offset, int limit);
}
