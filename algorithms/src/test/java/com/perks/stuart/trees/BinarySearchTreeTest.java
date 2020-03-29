package com.perks.stuart.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    @Test
    void inOrderTreeWalk() {

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        Node b = new Node();
        b.key = 5;

        Node a = new Node();
        a.key = 6;
        a.left = b;

        binarySearchTree.inOrderTreeWalk(a);

    }

    @Test
    void searchForKeyinTree() {

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        Node b = new Node();
        b.key = 5;

        Node a = new Node();
        a.key = 6;
        a.left = b;

        assertEquals(5, binarySearchTree.search(a, 5));

    }
}