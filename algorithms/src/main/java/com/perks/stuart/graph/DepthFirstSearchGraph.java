package com.perks.stuart.graph;

import java.util.*;

public class DepthFirstSearchGraph {

    List<Integer> depthFirstSearch(Node node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<Integer> foundKeys = new ArrayList<>();
        List<Node> visited = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();

        stack.addFirst(node);

        while (!stack.isEmpty()) {
            Node popped = stack.removeFirst();

            // May already have been visited from another node adjacent nodes
            if (!visited.contains(popped)) {
                System.out.println(popped.key);
                foundKeys.add(popped.key);
                visited.add(popped);

                for (Node adjacent : popped.adjacentNodes) {
                    if (!visited.contains(adjacent)) {
                        // Add children the depth of the node onto stack
                        stack.addFirst(adjacent);
                    }
                }
            }


        }
        return foundKeys;
    }

    int[] depthFirstSearch(int[][] adjacencyList, int source) {
        if (adjacencyList == null || adjacencyList.length == 0) {
            return new int[0];
        }

        int[] foundKeys = new int[adjacencyList.length];
        boolean[] visited = new boolean[adjacencyList.length];
        Deque<Integer> stack = new LinkedList<>();

        // Disconnected graph can check for any not visited in array and start them as source. If want to see all.
        stack.addFirst(source);

        while (!stack.isEmpty()) {
            int i = 0;
            for (int elem : stack) {
                System.out.println("Stack index " + i++ + " value " + elem);
            }
            Integer popped = stack.removeFirst();

            // May already have been visited from another node adjacent nodes
            if (!visited[popped]) {
                System.out.println(popped);
                foundKeys[popped] = popped;
                visited[popped] = true;

                for (int adjacentNodeIndex = 0; adjacentNodeIndex < adjacencyList[popped].length; adjacentNodeIndex++) {
                    int adjacentNodeVertex = adjacencyList[popped][adjacentNodeIndex];
                    if (!visited[adjacentNodeVertex]) {
                        // Add children the depth of the node onto stack
                        stack.addFirst(adjacentNodeVertex);
                    }
                }
            }


        }
        return foundKeys;
    }

    void depthFirstSearchIterative(int[][] adjacencyList, int source) {
        boolean visited[] = new boolean[adjacencyList.length];

        dfsVisit(adjacencyList, source, visited);
    }

    void dfsVisit(int[][] adjacencyList, int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        for (int adjacentNodeIndex = adjacencyList[v].length; adjacentNodeIndex < adjacencyList[v].length; adjacentNodeIndex++) {
            int adjacentNodeVertex = adjacencyList[v][adjacentNodeIndex];
            if (!visited[adjacentNodeVertex])
                dfsVisit(adjacencyList, adjacentNodeVertex, visited);
        }
    }

}
