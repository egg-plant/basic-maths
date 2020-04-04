package com.perks.stuart.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;


class BreadthFirstSearchGraphTest {

    @Test
    void breadthFirstSearch() {

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

        BreadthFirstSearchGraph bfs = new BreadthFirstSearchGraph();

        assertTrue(bfs.breadthFirstSearch(two).containsAll(Arrays.asList(0, 1, 2, 3)));

    }
}