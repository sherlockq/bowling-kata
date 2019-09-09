package com.codurance.bowling;

public class Bowling {
    private boolean digit;

    public int score(String input) {
        int score = 0;
        for(char oneChar : input.toCharArray()){
            if (Character.isDigit(oneChar)) {
                score += Character.getNumericValue(oneChar);
            }
        }
        return score;
    }

}
