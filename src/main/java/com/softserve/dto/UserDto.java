package com.softserve.dto;

import com.softserve.models.User;

public class UserDto extends User {
    private int playLaterGames;
    private int gamesMarked;
    private float avgMark;

    public int getPlayLaterGames() {
        return playLaterGames;
    }

    public void setPlayLaterGames(int playLaterGames) {
        this.playLaterGames = playLaterGames;
    }

    public int getGamesMarked() {
        return gamesMarked;
    }

    public void setGamesMarked(int gamesMarked) {
        this.gamesMarked = gamesMarked;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }
}
