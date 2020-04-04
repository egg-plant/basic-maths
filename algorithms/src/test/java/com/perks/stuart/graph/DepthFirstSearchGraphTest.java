package com.perks.stuart.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DepthFirstSearchGraphTest {

    @Test
    void depthFirstSearch() {

        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        zero.addAdjacentNode(one);
        zero.addAdjacentNode(two);
        two.addAdjacentNode(zero);
        two.addAdjacentNode(three);
        three.addAdjacentNode(three); // loop to itself
        one.addAdjacentNode(two);

        DepthFirstSearchGraph dfs = new DepthFirstSearchGraph();

        assertTrue(dfs.depthFirstSearch(two).containsAll(Arrays.asList(0, 1, 2, 3)));

    }

    @Test
    void depthFirstSearchAdjacencyList() {
        // node 0 points to 1 and 2. Node 1 points to 2 ... Node 3 points to itself 3
        int[][] adjacencyList = new int[][]{{1, 2}, {2}, {0, 3}, {3}};

        DepthFirstSearchGraph dfs = new DepthFirstSearchGraph();
        assertArrayEquals(new int[]{
                0, 1, 2, 3
        }, dfs.depthFirstSearch(adjacencyList, 2));

        // iterative approach
        //  dfs.depthFirstSearchIterative(adjacencyList, 2);

    }
}