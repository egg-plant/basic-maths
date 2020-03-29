package com.perks.stuart.problem.solving;

import java.util.Arrays;

/**
 * Contains example problems that i have come across in my journey through learning
 */
class ExampleProblems {

    int iterativeSum(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    int recursiveSum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else {
            return arr[0] + recursiveSum(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }

    int recursiveLengthOfArray(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else {
            return 1 + recursiveLengthOfArray(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }

    int max(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        } else {
            // last element
            int last = arr[arr.length - 1];
            // Value returned by recursive call
            //       for n-1 elements.
            int lastOthers = max(Arrays.copyOfRange(arr, 0, arr.length - 1));
            // Take the max of these elements.
            return (last > lastOthers) ? last : lastOthers;
        }
    }


}
