package com.softserve.dto;

import com.softserve.models.Game;

public class GameDto extends Game {
    private float avgMark;
    private int marksCount;

    public int getMarksCount() {
        return marksCount;
    }

    public void setMarksCount(int marksCount) {
        this.marksCount = marksCount;
    }

    public double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }
}
