package com.codurance.bowling;

public class Bowling {

    private final Strike strike = new Strike(this);
    int remainingExtras;
    int prevValue;
    int score;
    int round;

    public int score(String input) {
        score = 0;
        prevValue = 0;
        remainingExtras = 0;
        round = 0;

        for (char oneChar : input.toCharArray()) {

            if (isDigit(oneChar)) {
                int currentValue = Character.getNumericValue(oneChar);
                strike.processBall(currentValue, 0);
                prevValue = currentValue;
            } else if (oneChar == '/') {
                int currentValue = ballValueForSpare(prevValue);
                strike.processBall(currentValue, 1);

            } else if (oneChar == 'X') {
                strike.scoreBall();

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

    private int ballValueForSpare(int prevValue) {
        return 10 - prevValue;
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


    /*
        Game (remainingExtras)
        Round
        Ball scoreBall(Game)
     */

}
