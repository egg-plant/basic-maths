package com.perks.stuart.sorting;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] data) {
        for (int j = 1; j < data.length; j++) {
            int key = data[j];
            int i = j - 1;

            while (i >= 0 && data[i] > key) {
                data[i + 1] = data[i];
                i = i - 1;
            }
            data[i + 1] = key;

            Arrays.stream(data).forEach(it -> {
                System.out.print(it);
                System.out.print(",");
            });
        }
    }

}
