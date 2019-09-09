package com.codurance.bowling;

public class Bowling {

    private int remainingExtras;

    public int score(String input) {
        int score = 0;
        int prevValue = 0;
        remainingExtras = 0;

        for (char oneChar : input.toCharArray()) {

            int currentValue = 0;

            if (Character.isDigit(oneChar)) {
                currentValue = Character.getNumericValue(oneChar);
                prevValue = currentValue;

                score = checkSpareAndStrike(score, currentValue);
                score += currentValue;

            } else if (oneChar == '/') {

                currentValue = ballValueForSpare(prevValue);
                score = checkSpareAndStrike(score, currentValue);

                remainingExtras += 1;
                score += currentValue;
            } else if (oneChar == 'X') {
                currentValue = 10;
                score = checkSpareAndStrike(score, currentValue);

                remainingExtras += 2;
                score += currentValue;
            }




        }
        return score;
    }

    private int ballValueForSpare(int prevValue) {
        return 10 - prevValue;
    }

    private int checkSpareAndStrike(int score, int currentValue) {

        if (hasDoubleStrike()) {
            score = consumeOneExtra(score, currentValue);
        }

        if (hasExtra()) {
            score = consumeOneExtra(score, currentValue);
        }

        return score;
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
