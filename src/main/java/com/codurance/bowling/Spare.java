package com.codurance.bowling;

class Spare extends Ball{

    private static final int EXTRA_FOR_SPARE = 1;

    Spare(Bowling bowling, int ballValue) {
        super(bowling,  ballValue);
    }

    void scoreBall() {
        super.processBall(EXTRA_FOR_SPARE);
    }
}