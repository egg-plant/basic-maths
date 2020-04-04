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
            }

            for (Node adjacent : popped.adjacentNodes) {
                if (!visited.contains(adjacent)) {
                    stack.addFirst(adjacent);
                }
            }

        }
        return foundKeys;
    }

}
