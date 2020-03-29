package com.perks.stuart.sorting;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertionSortTest {

    @Test
    void sort() {
        InsertionSort sort = new InsertionSort();

        // calls (A,2) then recursive (A/4)

        var data = new int[]{5, 1, 2, 4, 3};

        sort.sort(data);

        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, data);
    }

}