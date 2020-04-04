package com.perks.stuart.trees;

import com.perks.stuart.graph.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BreadthFirstSearchTreeTest {

    @Test
    void breadthFirstSearch() {
        Node a = new Node(6);
        Node b = new Node(5);
        Node c = new Node(11);
        Node d = new Node(7);
        a.addAdjacentNode(b);
        a.addAdjacentNode(c);
        c.addAdjacentNode(d);

        BreadthFirstSearchTree breadthFirstSearchTree = new BreadthFirstSearchTree();
        assertTrue(breadthFirstSearchTree.breadthFirstSearchBinaryTree(a).containsAll(Arrays.asList(6, 5, 11, 7)));
    }
}