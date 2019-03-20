package com.softserve.dto;

import com.softserve.models.Game;

public class GameDto extends Game {
    private float avgMark;

    public double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }
}
