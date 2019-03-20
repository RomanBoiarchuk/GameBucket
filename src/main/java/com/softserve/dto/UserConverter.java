package com.softserve.dto;

import com.softserve.dao.UsersDao;
import com.softserve.models.User;
import com.softserve.utilities.DataBaseUtilities;

public class UserConverter implements Converter<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setNickname(user.getNickname());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        UsersDao dao = DataBaseUtilities.getUsersDao();
        userDto.setAvgMark(dao.calculateAvgMark(user.getId()));
        userDto.setGamesMarked(dao.calculateMarksCount(user.getId()));
        userDto.setPlayLaterGames(dao.calculatePlayLaterCount(user.getId()));
        return userDto;
    }
}
