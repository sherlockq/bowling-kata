package com.codurance.bowling;

public class Bowling {

    private boolean digit;

    public int score(String input) {
        int score = 0;
        int prevValue = 0;
        boolean isSpare = false;

        for (char oneChar : input.toCharArray()) {
            int currentValue = 0;
            if (Character.isDigit(oneChar)) {
                currentValue = Character.getNumericValue(oneChar);
                prevValue = currentValue;

                if(isSpare) {
                    isSpare = false;
                    score += currentValue;
                }

            } else if (oneChar == '/') {
                isSpare = true;
                currentValue = 10 - prevValue;
            }


            score += currentValue;

        }
        return score;
    }

}
