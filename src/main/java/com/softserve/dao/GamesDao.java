package com.softserve.dao;

import com.softserve.models.Game;

import java.util.Set;

public interface GamesDao {
    Game getById(long id);
    Set<Game> getAll();
    boolean add(Game game);
    boolean update(Game game);
    void deleteById(long gameId);
}

