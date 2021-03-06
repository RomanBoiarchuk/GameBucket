package com.softserve.dao;

import com.softserve.models.User;

import java.util.Set;

public interface UsersDao {
    User getById(long id);
    User getByEmail(String email);
    User getByNickname(String nickname);
    Set<User> getAll();
    boolean add(User user);
    boolean update(User user);
    void deleteById(long userId);
    int calculatePlayLaterCount(long userId);
    int calculateMarksCount(long userId);
    float calculateAvgMark(long userId);
}

