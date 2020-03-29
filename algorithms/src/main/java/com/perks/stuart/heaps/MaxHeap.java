package com.perks.stuart.heaps;

class MaxHeap {

    // should hold lenght of arry
    // and the number of items in the array.

    void heapSort(int[] data) {
        int n = data.length;
        buildMaxHeap(data, n);
        for (int i = n - 1; i >= 0; i--) {
            swap(data, 0, i);
            maxHeapify(data, i, 0);
        }
    }


    // Note only start at the leaves. Hence length/2
    // Leaves are good are automatically max heaps.
    // Start small tree of leaves, then up again. Starting at L1 to L2,
    // and work your way up to the root only working with max heaps to satisfy the pre condition
    // of tree rooted at left(i) and right(i) are max heaps to the Root.
    // You would think time complexity is worst case O(n log n) due to going other each element via loop and recursion
    // and each maxHeapify is log n.
    // Actually you can get Order N Big(N) as it can be bounded by a constant.
    // As MaxHeapify takes constant time for nodes that are one level above leaves.
    // In general O(l) times for n levels above the leaves.
    // n/4 nodes with level1, n/8 for level 2 ... and one node a log n level which is the root node.
    // Sum these for each level so total amount of work in for loop is
    // n/4(1c) // level above leaves + n/8(2c) + n/16(3c) + .... 1(log n * c) // arithmetic expression of above
    // SET n/4 = 2^k then we have identically with substitution and distributive law
    // C2^k( 1/(2^0) /*This left half is equal to 1*/ + 2/(2^1) + 3/(2^2) + .... + (k+1)/2^k) // the last bit is the replacement term for sum.
    // TODO sort this substituion
    // THis is a convergent series bounded by a constant makes its way to something less than 3. Even if k tends to infinity.
    // so we are left with a constant * 2^k * constant as this is asymptotic we ignore the constants and 2^k = n/4
    // hence with have Big Theta(n)
    void buildMaxHeap(int[] data, int heapsize) {
        for (int i = heapsize / 2; i >= 0; i--) {
            maxHeapify(data, heapsize, i);
        }
    }


    // Correct single violation of heap property in subtree root.
    // Assumes tree rooted at left(i) and right(i) are max heaps.
    // Key precondition for time complexity and algorithm.
    // Leaves by definition are max heaps.
    // Time complexity
    // We visulazie this as a nearly complete binary tree.
    // Therefore the height is log n. Good news.
    // There for we only work through the number of nodes thats the height of the tree.
    // So as nearly complete binary tree its O(log n).
    void maxHeapify(int[] data, int heapsize, int index) {

        var leftNodes = left(index);
        var rightNode = right(index);
        int largest;
        // Left node exists and the root node is smaller than the left node of the subtree.
        if (leftNodes < heapsize && data[index] < data[leftNodes]) {
            largest = leftNodes;
        } else {
            largest = index; // Otherwise current largest is the root of the subtree.
        }

        // less than length due to zero index and current largest is less than the right node.
        if (rightNode < heapsize && data[largest] < data[rightNode]) {
            largest = rightNode;
        }

        // If we are making a change the rootnode is not the largest swap and then check again
        // On the swapped node index.
        if (largest != index) {
            swap(data, largest, index);
            maxHeapify(data, heapsize, largest);
        }

    }

    void swap(int[] data, int i, int j) {
        int temp = data[j];
        data[j] = data[i];
        data[i] = temp;
    }

    public int maximum(int[] data) {
        return data[0];
    }

    int extractMaximum(int[] data) {
        int max = data[0];
        data[0] = data[data.length - 1];
        int length = data.length - 2;
        maxHeapify(data, length, 0);
        return max;
    }

    // TODO check algorithm book for this
    // O(log n)
    int[] insert(int[] data, int value) {
        // TODO starting size? How it works so we can grow in chunks?
        int[] copy = new int[data.length + 1];
        System.arraycopy(data, 0, copy, 0, data.length);
        copy[copy.length - 1] = (int) Double.NEGATIVE_INFINITY;
        increaseKey(copy, copy.length - 1, value);
        return copy;
    }

    void increaseKey(int[] data, int index, int key) {
        data[index] = key;
        while (index > 0 && data[parent(index)] < data[index]) {
            swap(data, parent(index), index);
            index = parent(index);
        }
    }

    int parent(int i) {
        return (int) Math.floor(i - 1 / 2.0); // minus one due to zero index;
    }

    int left(int i) {
        return 2 * i + 1; // extra plus one due to zero index
    }

    int right(int i) {
        return 2 * i + 1 + 1; // extra plus one due to zero index
    }

}
