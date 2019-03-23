package com.softserve.dao;

import com.softserve.models.Game;
import com.softserve.models.PlayLaterNote;

import java.util.Set;

public interface PlayLaterDao {
    Set<PlayLaterNote> getAll();
    Set<PlayLaterNote> getByUserId(long userId);
    boolean add(PlayLaterNote playLaterNote);
    void delete(PlayLaterNote playLaterNote);
    boolean exists(PlayLaterNote playLaterNote);
    Set<Game> getGames(long userId, long offset, int limit,
                       String seek, int fromYear, int toYear);
}

