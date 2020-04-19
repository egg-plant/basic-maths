package com.perks.stuart.trees;

// Redblack Tree is a binary tree that satisfies given critieria
// 1) Every node is either red or black
// 2) Root node is always black
// 3) Every leaf (NIL) is black
// 4) If node is red then both its children are black
// 5) For each node all the simple paths to its descendant leaves contain the same number of black nodes.
public class RedBlackTree {

    enum Colour {
        RED,
        BLACK
    }

    static class RedBlackTreeNode {
        Colour colour;
        int key;
        RedBlackTreeNode left;
        RedBlackTreeNode right;
        RedBlackTreeNode parent;

    }

    void leftRotate(RedBlackTreeNode root, RedBlackTreeNode x) {
        RedBlackTreeNode y = x.right;
        x.right = x.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;


    }


}
