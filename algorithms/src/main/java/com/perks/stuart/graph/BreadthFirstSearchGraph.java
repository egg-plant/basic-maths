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

    // where key data is the vertex index
    int[] breadthFirstSearch(int[][] adjacencyList, int source) {
        if (adjacencyList == null || adjacencyList.length == 0) {
            return new int[0];
        }

        boolean[] visited = new boolean[adjacencyList.length];
        int[] foundKeys = new int[adjacencyList.length];
        Queue<Integer> queue = new LinkedList<>();

        // if disconnected graph can check BFS for each unvisited node. in loop here.
        queue.add(source);

        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();
            foundKeys[currentVertex] = currentVertex;
            System.out.println(currentVertex);
            visited[currentVertex] = true;

            // loop over adjacent nodes
            for (int adjacentNode = 0; adjacentNode < adjacencyList[currentVertex].length; adjacentNode++) {
                int adjacentNodeVertex = adjacencyList[currentVertex][adjacentNode];
                if (!visited[adjacentNodeVertex]) {
                    queue.add(adjacentNodeVertex);
                }
            }
        }

        return foundKeys;

    }

}
