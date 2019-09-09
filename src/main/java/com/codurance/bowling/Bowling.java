package com.codurance.bowling;

public class Bowling {
    private boolean digit;

    public int score(String input) {
        if(Character.isDigit(input.charAt(0))) {
            return 1;
        }
        return 0;
    }

}
