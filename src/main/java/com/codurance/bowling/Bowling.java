package com.codurance.bowling;

public class Bowling {


    private static final int TOTAL_FRAME = 10;
    private char[] ballChars;

    public int score(String input) {
        ballChars = input.replace("|", "").toCharArray();
        int ballIndex = 0;
        int score = 0;
        for (int frame = 0; frame < TOTAL_FRAME; frame++) {
            if(ballChars[ballIndex] == 'X') {
                score += 10 + getBallValue(ballIndex + 1) + getBallValue(ballIndex + 2);
                ballIndex += 1;
            }
            else if(ballChars[ballIndex + 1 ] == '/') {
                score += 10 + getBallValue(ballIndex + 2);
                ballIndex += 2;
            } else {
                score += getBallValue(ballIndex) + getBallValue(ballIndex + 1);
                ballIndex += 2;
            }

        }
        return score;
    }

    int getBallValue(int index) {
        char ballChar = ballChars[index];
        if (Character.isDigit(ballChar)) {
            return Character.getNumericValue(ballChar);
        }
        switch (ballChar) {
            case '/':
                return 10 - getBallValue(index-1);
            case 'X':
                return 10;
        }
        return 0;
    }


}
