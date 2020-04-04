package com.perks.stuart.graph;

import java.util.*;

public class BreadthFirstSearchGraph {

    // OOP Node version
    List<Integer> breadthFirstSearch(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        // Hold a list of visited nodes to protected against cycles
        List<Node> visited = new ArrayList<>();
        List<Integer> foundKeys = new ArrayList<>();
        // Queue to hold the nodes visiting
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // loop over queue items.
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.key);
            foundKeys.add(current.key);
            visited.add(current);

            // only check those not already visited
            for (Node adjacentNode : current.adjacentNodes) {
                if (!visited.contains(adjacentNode)) {
                    queue.add(adjacentNode);
                }
            }
        }
        return foundKeys;
    }

}
