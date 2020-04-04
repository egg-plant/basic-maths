package com.perks.stuart.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RunningMedianHeapTest {

    @Test
    void runningMedian() {
        int[] data = new int[]{12, 4, 5, 3, 8, 7};

        RunningMedianHeap runningMedianHeap = new RunningMedianHeap();


        assertArrayEquals(new double[]{12.0, 8.0, 5.0, 4.5, 5.0, 6.0}, runningMedianHeap.runningMedian(data));

    }
}