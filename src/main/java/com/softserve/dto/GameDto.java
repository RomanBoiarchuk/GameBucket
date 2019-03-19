package com.softserve.dto;

import com.softserve.models.Game;

public class GameDto extends Game {
    private double avgMark;

    public double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(double avgMark) {
        this.avgMark = avgMark;
    }
}
