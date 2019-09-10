package com.codurance.bowling;

public class Bowling {


    private static final int TOTAL_FRAME = 10;
    private char[] ballChars;

    public int score(String input) {
        ballChars = input.replace("|", "").toCharArray();

        int ballIndex = 0;
        int score = 0;

        for (int frame = 0; frame < TOTAL_FRAME; frame++) {
            if (isStrikeFrame(ballIndex)) {
                score += 10 + strikeBonus(ballIndex);
                ballIndex += 1;

            } else if (isSpareFrame(ballIndex)) {
                score += 10 + spareBonus(ballIndex);
                ballIndex += 2;

            } else {
                score += sumOfBalls(ballIndex);
                ballIndex += 2;

            }
        }
        return score;
    }

    private int sumOfBalls(int ballIndex) {
        return getBallValue(ballIndex) + getBallValue(ballIndex + 1);
    }

    private int spareBonus(int ballIndex) {
        return getBallValue(ballIndex + 2);
    }

    private int strikeBonus(int ballIndex) {
        return getBallValue(ballIndex + 1) + getBallValue(ballIndex + 2);
    }

    private boolean isSpareFrame(int ballIndex) {
        return ballChars[ballIndex + 1] == '/';
    }

    private boolean isStrikeFrame(int ballIndex) {
        return ballChars[ballIndex] == 'X';
    }

    private int getBallValue(int index) {
        char ballChar = ballChars[index];
        if (Character.isDigit(ballChar)) {
            return Character.getNumericValue(ballChar);
        }
        switch (ballChar) {
            case '/':
                return 10 - getBallValue(index - 1);
            case 'X':
                return 10;
        }
        return 0;
    }


}
