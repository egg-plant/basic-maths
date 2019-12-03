package com.perks.stuart.sorting;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] data) {
        for (int j = 1; j < data.length; j++) {
            int key = data[j];
            System.out.println("Key is " + key);
            int i = j - 1;
            System.out.println("i is " + i);

            while (i >= 0 && data[i] > key) {
                System.out.println("data[" + i + "] is " + data[i] + " data[" + (i + 1) + "] is " + data[i + 1]);
                data[i + 1] = data[i];
                i = i - 1;
                System.out.println("i is counting down and is now " + i);
            }
            data[i + 1] = key;
            System.out.println("data[" + (i + 1) + "] is " + key);

            Arrays.stream(data).forEach(it -> {
                System.out.print(it);
                System.out.print(",");
            });
            System.out.println();
        }
    }

}
