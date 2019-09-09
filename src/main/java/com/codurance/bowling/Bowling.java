package com.codurance.bowling;

public class Bowling {

    private boolean digit;

    public int score(String input) {
        int score = 0;
        int prevValue= 0;

        for (char oneChar : input.toCharArray()) {
            int valueOfCurrentChar = 0;
            if (Character.isDigit(oneChar)) {
                valueOfCurrentChar = Character.getNumericValue(oneChar);
            } else {
                if (oneChar == '/') {
                    valueOfCurrentChar = 10 - prevValue;
                }
            }

            score += valueOfCurrentChar;
            if(valueOfCurrentChar != 0) prevValue = valueOfCurrentChar;
        }
        return score;
    }

}
