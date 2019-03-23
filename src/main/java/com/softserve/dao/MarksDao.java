package com.softserve.dao;

import com.softserve.models.Game;
import com.softserve.models.Mark;

import java.util.Set;

public interface MarksDao {
    Mark getById(long userId, long gameId);
    boolean exists(long userId, long gameId);
    Set<Mark> getAll();
    Set<Mark> getByuserId(long userId);
    boolean add(Mark mark);
    boolean update(Mark mark);
    void delete(Mark mark);
    Set<Game> getGames(long userId, long offset, int limit);
}

