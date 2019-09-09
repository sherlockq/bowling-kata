package com.codurance.bowling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingShould {

    @ParameterizedTest
    @CsvSource({
            "--|--|--|--|--|--|--|--|--|--||, 0",
            "1-|--|--|--|--|--|--|--|--|--||, 1",
            "2-|--|--|--|--|--|--|--|--|--||, 2",
            "--|--|2-|--|--|--|--|--|--|--||, 2",
            "--|--|--|-2|--|--|--|--|--|--||, 2",
            "2-|2-|--|-2|--|--|--|--|--|--||, 6",
            "1/|--|--|--|--|--|--|--|--|--||, 10",
            "2/|--|--|--|--|--|--|--|--|--||, 10",
            "1/|1-|--|--|--|--|--|--|--|--||, 12",
            "1/|1/|5-|--|--|--|--|--|--|--||, 31",
            "X|--|--|--|--|--|--|--|--|--||, 10",
            "X|1-|--|--|--|--|--|--|--|--||, 12",
            "X|11|--|--|--|--|--|--|--|--||, 14",
            "X|11|1-|--|--|--|--|--|--|--||, 15",
            "X|1/|--|--|--|--|--|--|--|--||, 30",
            "X|X|--|--|--|--|--|--|--|--||, 30",
            "X|X|1-|--|--|--|--|--|--|--||, 33",
            "X|X|X|1-|--|--|--|--|--|--||, 63",
            "X|X|X|1/|1-|--|--|--|--|--||, 83",
    })
    void score(String input, int expectedScore) {
        Bowling bowling = new Bowling();
        assertEquals(expectedScore, bowling.score(input));
    }
}
