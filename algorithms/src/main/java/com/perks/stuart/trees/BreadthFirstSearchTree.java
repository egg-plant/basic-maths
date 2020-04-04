package com.perks.stuart.trees;

import com.perks.stuart.graph.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchTree {

    List<Integer> breadthFirstSearchBinaryTree(BinaryNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> foundKeys = new ArrayList<>();
        // Queue to hold the nodes visiting
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        // loop over queue items.
        while (!queue.isEmpty()) {
            BinaryNode current = queue.remove();
            System.out.println(current.key);
            foundKeys.add(current.key);
            // Only works for binary tree.
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return foundKeys;
    }


    List<Integer> breadthFirstSearchBinaryTree(Node root) {
        if (root == null) {
            return null;
        }

        //Holdes results
        List<Integer> foundKeys = new ArrayList<>();

        // Queue to hold the nodes visiting
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // loop over queue items.
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.key);
            foundKeys.add(current.key);
            queue.addAll(current.adjacentNodes);
        }
        return foundKeys;
    }

}
