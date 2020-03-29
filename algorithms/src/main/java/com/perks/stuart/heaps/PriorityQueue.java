package com.perks.stuart.heaps;

// Example if using Max Heap as Priority Queue
// takes O(log n) time to delete and insert into the heap
public class PriorityQueue {

    private MaxHeap maxHeap;
    private int[] queue;


    public PriorityQueue() {
        this.maxHeap = new MaxHeap();
        this.queue = new int[0];
    }

    // O(log n)
    int poll() {
        return this.maxHeap.extractMaximum(queue);
    }

    // O(1)
    int peek() {
        return this.maxHeap.maximum(queue);
    }

    // O(log n)
    boolean add(int value) {
        this.queue = maxHeap.insert(queue, value);
        return true;
    }

}
