package com.perks.stuart.trees;

class Node {
    int key;
    int satelliteData;
    Node left;
    Node right;
    Node parent;
}


// What is this good for?
// Time complexities
public class BinarySearchTree {

    // Prints all keys in sorted order
    void inOrderTreeWalk(Node x) {
        if (x != null) {
            inOrderTreeWalk(x.left);
            System.out.println("Key is " + x.key);
            inOrderTreeWalk(x.right);
        }

    }

    // O (h) where we want this log n for search as expected height is usually log n
    // not guaranteed for binary search tree
    int search(Node root, int k) {
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
    int minimum(Node node) {
        int found = node.key;
        while (node.left != null) {
            found = minimum(node.left);
        }
        return found;
    }

    // O (h) where we want this log n for search as expected height is usually log n
    // not guaranteed for binary search tree
    int maximum(Node node) {
        int found = node.key;
        while (node.right != null) {
            found = minimum(node.right);
        }
        return found;
    }


}
