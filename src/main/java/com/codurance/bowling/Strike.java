package com.codurance.bowling;

public class Strike extends Ball {
    private static final int EXTRA_FOR_STRIKE = 2;
    private static final int SCORE_FOR_STRIKE = 10;

    Strike(Bowling bowling) {
        super(bowling, SCORE_FOR_STRIKE);
    }

    @Override
    void scoreBall() {
        processBall(EXTRA_FOR_STRIKE);
    }

}