package com.perks.stuart.trees;


// What is this good for?
// Time complexities
public class BinarySearchTree {

    // Prints all keys in sorted order
    void inOrderTreeWalk(BinaryNode x) {
        if (x != null) {
            inOrderTreeWalk(x.left);
            System.out.println("Key is " + x.key);
            inOrderTreeWalk(x.right);
        }

    }

    // O (h) where we want this log n for search as expected height is usually log n
    // not guaranteed for binary search tree
    int search(BinaryNode root, int k) {
        // If the root is null return nothing to search
        if (root == null) {
            return k;
        } else if (k < root.key) {
            // k is less than root.key look in the left node of the tree
            return search(root.left, k);
        } else {
            // k is greater than or equal too root.key look in the right node of the tree
            return search(root.right, k);
        }
    }

    // O (h) where we want this log n for search as expected height is usually log n
    // not guaranteed for binary search tree
    int minimum(BinaryNode node) {
        int found = node.key;
        while (node.left != null) {
            found = minimum(node.left);
        }
        return found;
    }

    // O (h) where we want this log n for search as expected height is usually log n
    // not guaranteed for binary search tree
    int maximum(BinaryNode node) {
        int found = node.key;
        while (node.right != null) {
            found = minimum(node.right);
        }
        return found;
    }

    int maxDepth(BinaryNode root) {
        if (root == null) {
            return -1; // -1 as we check below the root node.
        } else {
            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);

            return Math.max(lDepth, rDepth) + 1; // To account for the negative value put + 1
        }
    }

    // Replace a nodes parent used for deletion
    void transplant(BinaryNode root, int oldKey, int newKey) {

    }




}
