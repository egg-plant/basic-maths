package com.perks.stuart.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    @Test
    void inOrderTreeWalk() {

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        BinaryNode b = new BinaryNode(5);

        BinaryNode a = new BinaryNode(6);
        a.left = b;

        binarySearchTree.inOrderTreeWalk(a);

    }

    @Test
    void searchForKeyinTree() {

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        BinaryNode b = new BinaryNode(5);

        BinaryNode a = new BinaryNode(6);
        a.left = b;

        assertEquals(5, binarySearchTree.search(a, 5));

    }

    @Test
    void maxHeightTree() {

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        BinaryNode b = new BinaryNode(5);
        BinaryNode c = new BinaryNode(5);
        BinaryNode d = new BinaryNode(5);
        BinaryNode e = new BinaryNode(5);

        BinaryNode a = new BinaryNode(6);
        a.left = b;
        b.left = c;
        c.left = d;
        a.right = e;

        assertEquals(3, binarySearchTree.maxDepth(a));

    }
}