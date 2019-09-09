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

            } else if (oneChar == '/') {

                currentValue = 10 - prevValue;
                score = checkSpareAndStrike(score, currentValue);

                remainingExtras +=1;
            } else if (oneChar == 'X') {
                currentValue = 10;
                score = checkSpareAndStrike(score, currentValue);

                remainingExtras +=2;
            }


            score += currentValue;

        }
        return score;
    }

    private int checkSpareAndStrike(int score, int currentValue) {

        if(remainingExtras > 2) {
            score += currentValue;
        }

        if(remainingExtras > 0) {
            score += currentValue;
            remainingExtras--;
        }


        return score;
    }

}
