package com.codurance.bowling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingShould {

    @Test
    void score_0_if_miss_all_balls() {
        String input = "--|--|--|--|--|--|--|--|--|--||";
        Bowling bowling = new Bowling();
        assertEquals(0, bowling.score(input));
    }

    @Test
    void score_1_if_only_score_at_first_ball() {
        String input = "1-|--|--|--|--|--|--|--|--|--||";
        Bowling bowling = new Bowling();
        assertEquals(1, bowling.score(input));
    }

    @ParameterizedTest
    @CsvSource({
            "--|--|--|--|--|--|--|--|--|--||, 0",
            "1-|--|--|--|--|--|--|--|--|--||, 1",
    })
    void score(String input, int expectedScore) {
        Bowling bowling = new Bowling();
        assertEquals(expectedScore, bowling.score(input));
    }
}
