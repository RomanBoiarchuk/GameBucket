package com.softserve.controllers;

import com.softserve.models.Game;

import java.util.Set;

@FunctionalInterface
public interface GamesGetter {
    Set<Game> getGames(long offset, int limit,
                       String seek, int fromYear, int toYear);
}
