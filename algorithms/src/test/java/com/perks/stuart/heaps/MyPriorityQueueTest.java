package com.perks.stuart.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyPriorityQueueTest {

    @Test
    void priorityQueueByKey() {

        // As backed by max heap highest key is most important
        MyPriorityQueue queue = new MyPriorityQueue();

        queue.add(2);

        // Check max
        assertEquals(2, queue.peek());

        queue.add(3);

        // Now head is 3 due to higher key
        // Check head of queue
        assertEquals(3, queue.peek());

        // Take the top element
        assertEquals(3, queue.poll());

        queue.add(1);
        // Now highest priority is 2
        assertEquals(2, queue.poll());

        assertEquals(1, queue.poll());

    }

}