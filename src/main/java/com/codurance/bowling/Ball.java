package com.codurance.bowling;

public class Ball {
    int ballValue;
    protected final Bowling bowling;

    public Ball(Bowling bowling, int ballValue) {
        this.bowling = bowling;
        this.ballValue = ballValue;
    }

    void scoreBall() {
        processBall(0);
    }

    void processBall(int roundRemainingExtras) {
        addExtraScore();

        if (!bowling.isBonusRound()) {
            bowling.addRemainingExtras(roundRemainingExtras);
            bowling.addScore(ballValue);
        }
    }

    void addExtraScore() {

        if (bowling.hasDoubleStrike()) {
            bowling.addScore(ballValue);
            bowling.reduceRemainingExtras();;
        }

        if (bowling.hasExtra()) {
            bowling.addScore(ballValue);
            bowling.reduceRemainingExtras();;
        }

    }
}
