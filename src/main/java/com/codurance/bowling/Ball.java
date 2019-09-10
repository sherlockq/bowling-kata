package com.codurance.bowling;

public abstract class Ball {
    protected final Bowling bowling;

    public Ball(Bowling bowling) {
        this.bowling = bowling;
    }

    abstract void scoreBall();

    void processBall(int currentValue, int roundRemainingExtras) {
        addExtraScore(currentValue);

        if (!bowling.isBonusRound()) {
            bowling.addRemainingExtras(roundRemainingExtras);
            bowling.addScore(currentValue);
        }
    }

    void addExtraScore(int currentValue) {

        if (bowling.hasDoubleStrike()) {
            bowling.addScore(currentValue);
            bowling.reduceRemainingExtras();;
        }

        if (bowling.hasExtra()) {
            bowling.addScore(currentValue);
            bowling.reduceRemainingExtras();;
        }

    }
}
