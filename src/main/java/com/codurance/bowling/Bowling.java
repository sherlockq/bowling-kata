package com.codurance.bowling;

public class Bowling {

    private int remainingExtras = 0;
    private int score = 0;
    private int round = 0;

    public int score(String input) {
        int prevValue = 0;
        remainingExtras = 0;

        for (char oneChar : input.toCharArray()) {

            if (isDigit(oneChar)) {
                int ballValue = Character.getNumericValue(oneChar);
                prevValue = ballValue;

                Ball ball = new Ball(this, ballValue);
                ball.scoreBall();

            } else if (oneChar == '/') {
                new Spare(this, 10 - prevValue).scoreBall();

            } else if (oneChar == 'X') {
                new Strike(this).scoreBall();

            } else if (oneChar == '|') {
                round++;

            } else if (oneChar == '-') {
                remainingExtras--;
                if (remainingExtras < 0) remainingExtras = 0;
            }
        }

        return score;
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
    }


}
