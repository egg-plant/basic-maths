package com.perks.stuart.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MaxHeapTest {

    @Test
    void sort() {
        MaxHeap maxHeap = new MaxHeap();

        // Meets precondition
        var data = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        maxHeap.heapSort(data);
        assertArrayEquals(new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16}, data);
        // TODO sort in descending is min heap
    }

    @Test
    void sort2() {
        MaxHeap maxHeap = new MaxHeap();

        // Meets precondition
        var data = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1, 1421};

        maxHeap.heapSort(data);
        assertArrayEquals(new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16, 1421}, data);
        // TODO sort in descending is min heap
    }

    @Test
    void sortSingleElement() {
        MaxHeap maxHeap = new MaxHeap();

        // Meets precondition
        var data = new int[]{16};

        maxHeap.heapSort(data);
        assertArrayEquals(new int[]{16}, data);
    }

    @Test
    void maxHeapify() {

        MaxHeap maxHeap = new MaxHeap();

        // Meets precondition
        var data = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        maxHeap.maxHeapify(data, data.length, 1);
        assertArrayEquals(new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1}, data);
    }

    @Test
    void buildMaxHeap() {

        MaxHeap maxHeap = new MaxHeap();

        // Meets precondition
        var data = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        maxHeap.buildMaxHeap(data, data.length);
        assertArrayEquals(new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1}, data);
    }

    @Test
    void insertValueIntoMaxHeap() {

        MaxHeap maxHeap = new MaxHeap();

        // Meets precondition
        var data = new int[]{16, 4, 10, 14, 7, 9, 2, 8, 1};

        maxHeap.buildMaxHeap(data, data.length);
        int[] dataInserted = maxHeap.insert(data, 3);
        assertArrayEquals(new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1}, dataInserted);
    }

}