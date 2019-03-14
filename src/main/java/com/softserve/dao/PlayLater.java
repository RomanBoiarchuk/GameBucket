package com.softserve.dao;

import com.softserve.models.PlayLaterNote;

import java.util.Set;

public interface PlayLater {
    Set<PlayLaterNote> getAll();
    Set<PlayLaterNote> getByUserId(long userId);
    boolean add(PlayLaterNote playLaterNote);
    void delete(PlayLaterNote playLaterNote);
}

