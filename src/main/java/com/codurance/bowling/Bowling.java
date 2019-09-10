package com.codurance.bowling;

public class Bowling {

    private int remainingExtras;
    private int prevValue;
    private int score;
    private int round;

    public int score(String input) {
        score = 0;
        prevValue = 0;
        remainingExtras = 0;
        round = 0;

        for (char oneChar : input.toCharArray()) {

            if (isDigit(oneChar)) {
                processDigit(oneChar);

            } else if (oneChar == '/') {
                processSpare();

            } else if (oneChar == 'X') {
                processStrike();

            } else if (oneChar == '|') {
                round++;

            } else if (oneChar == '-') {
                remainingExtras--;
                if(remainingExtras < 0) remainingExtras = 0;
            }
        }

        return score;
    }

    private boolean isDigit(char oneChar) {
        return Character.isDigit(oneChar);
    }

    private void processStrike() {
        int currentValue;
        currentValue = 10;
       addExtraScore( currentValue);

        if (isBonusRound()) {
            return;
        } else {
            remainingExtras += 2;
            score += currentValue;
        }
    }

    private boolean isBonusRound() {
        return round > 9;
    }

    private void processSpare() {
        int currentValue;
        currentValue = ballValueForSpare(prevValue);
        addExtraScore( currentValue);

        if (isBonusRound()) {
            return;
        } else {
            remainingExtras += 1;
            score += currentValue;
        }
    }

    private void processDigit(char oneChar) {
        int currentValue;
        currentValue = Character.getNumericValue(oneChar);
        prevValue = currentValue;

        addExtraScore(currentValue);
        if (isBonusRound()) {
            return;
        } else {
            remainingExtras += 0;
            score += currentValue;
        }
    }

    private int ballValueForSpare(int prevValue) {
        return 10 - prevValue;
    }

    private void addExtraScore(int currentValue) {

        if (hasDoubleStrike()) {
            score = consumeOneExtra(score, currentValue);
        }

        if (hasExtra()) {
            score = consumeOneExtra(score, currentValue);
        }

    }

    private boolean hasExtra() {
        return remainingExtras > 0;
    }

    private boolean hasDoubleStrike() {
        return remainingExtras > 2;
    }

    private int consumeOneExtra(int score, int currentValue) {
        score += currentValue;
        remainingExtras--;
        return score;
    }

}
