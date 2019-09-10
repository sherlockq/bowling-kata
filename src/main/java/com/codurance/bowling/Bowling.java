package com.codurance.bowling;

public class Bowling {

    private int remainingExtras = 0;
    private int score = 0;
    private int round = 0;
    private int prevValue;

    public int score(String input) {

        for (char oneChar : input.toCharArray()) {
            if (oneChar == '|') {
                round++;
                continue;
            }
            Ball ball = getBall(oneChar);
            ball.scoreBall();
        }

        return score;
    }

    private Ball getBall(char oneChar) {

        if (isDigit(oneChar)) {
            int ballValue = Character.getNumericValue(oneChar);
            prevValue = ballValue;

            return new Ball(this, ballValue);

        } else if (oneChar == '/') {
            return new Spare(this, 10 - prevValue);

        } else if (oneChar == 'X') {
            return new Strike(this);

        } else {
            return new MissedBall(this);

        }
    }

    private boolean isDigit(char oneChar) {
        return Character.isDigit(oneChar);
    }

    boolean isBonusRound() {
        return round > 9;
    }

    boolean hasExtra() {
        return remainingExtras > 0;
    }

    boolean hasDoubleStrike() {
        return remainingExtras > 2;
    }

    void addScore(int scoreToAdd) {
        score += scoreToAdd;
    }

    void addRemainingExtras(int extraToAdd) {
        this.remainingExtras += extraToAdd;
    }

    void reduceRemainingExtras() {
        this.remainingExtras--;
        if (remainingExtras < 0) remainingExtras = 0;
    }


}
