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
                int currentValue = Character.getNumericValue(oneChar);
                processBall(currentValue, 0);
                prevValue = currentValue;
            } else if (oneChar == '/') {
                int currentValue = ballValueForSpare(prevValue);
                processBall(currentValue, 1);

            } else if (oneChar == 'X') {
                int currentValue = 10;
                processBall(currentValue, 2);

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

    private void processBall(int currentValue, int roundRemainingExtras) {
       addExtraScore( currentValue);

        if (isBonusRound()) {
            return;
        } else {
            remainingExtras += roundRemainingExtras;
            score += currentValue;
        }
    }

    private boolean isBonusRound() {
        return round > 9;
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
