package com.codurance.bowling;

public class Strike extends Ball {
    private static final int EXTRA_FOR_STRIKE = 2;
    private static final int SCORE_FOR_STRIKE = 10;

    Strike(Bowling bowling) {
        super(bowling);
    }

    @Override
    void scoreBall() {
        processBall(SCORE_FOR_STRIKE, EXTRA_FOR_STRIKE);
    }

}