package com.perks.stuart.problem.solving;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleProblemsTest {

    private ExampleProblems exampleProblems = new ExampleProblems();

    @Test
    void iterativeSum() {
        int[] data = new int[]{2, 5, 11, 22, 2};
        assertEquals(42, exampleProblems.iterativeSum(data));
    }

    @Test
    void recursiveSum() {
        int[] data = new int[]{2, 5, 11, 22, 2};
        assertEquals(42, exampleProblems.recursiveSum(data));
    }

    @Test
    void lengthOfArrayRecursively() {
        int[] data = new int[]{2, 5, 11, 22, 2};
        assertEquals(5, exampleProblems.recursiveLengthOfArray(data));
    }

    @Test
    void maxRecursively() {
        int[] data = new int[]{2, 5, 11, 22, 2};
        assertEquals(22, exampleProblems.max(data));
    }
}