package com.codurance.bowling;

public class Bowling {

    private boolean digit;

    public int score(String input) {
        int score = 0;
        int prevValue = 0;
        boolean isSpare = false;
        boolean isStrike = false;

        for (char oneChar : input.toCharArray()) {
            int currentValue = 0;
            if (Character.isDigit(oneChar)) {
                currentValue = Character.getNumericValue(oneChar);
                prevValue = currentValue;

                if (isSpare || isStrike) {
                    isSpare = false;
                    if(isStrike) {
                        isStrike = false;
                        isSpare = true;
                    }
                    score += currentValue;
                }

            } else if (oneChar == '/') {

                currentValue = 10 - prevValue;
                if (isSpare || isStrike) {
                    isSpare = false;
                    if(isStrike) {
                        isStrike = false;
                        isSpare = true;
                    }
                    score += currentValue;
                }

                isSpare = true;
            } else if (oneChar == 'X') {
                currentValue = 10;
                if (isSpare || isStrike) {
                    isSpare = false;
                    if(isStrike) {
                        isStrike = false;
                        isSpare = true;
                    }
                    score += currentValue;
                }

                isStrike = true;
            }


            score += currentValue;

        }
        return score;
    }

}
