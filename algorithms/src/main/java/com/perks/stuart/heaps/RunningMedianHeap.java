package com.perks.stuart.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

class RunningMedianHeap {

    double[] runningMedian(int[] a) {
        PriorityQueue<Integer> minHeap =
                new PriorityQueue();

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue(Collections.reverseOrder());

        double currentMedian = 0;
        double[] results = new double[a.length];
        for (int i = 0; i < a.length; i++) {

            int nextValue = a[i];

            if (nextValue < currentMedian) {
                maxHeap.add(nextValue);
            } else {
                minHeap.add(nextValue);
            }

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            } else if (minHeap.size() < maxHeap.size()) {
                minHeap.add(maxHeap.poll());
            }

            if (minHeap.size() == maxHeap.size()) {
                currentMedian = (minHeap.peek() + maxHeap.peek()) / 2.0;
                results[i] = currentMedian;
                System.out.println(currentMedian);
            } else if (minHeap.size() > maxHeap.size()) {
                currentMedian = minHeap.peek();
                results[i] = currentMedian;
                System.out.println(currentMedian);
            } else {
                currentMedian = maxHeap.peek();
                results[i] = currentMedian;
                System.out.println(currentMedian);
            }
        }

        return results;
    }
}