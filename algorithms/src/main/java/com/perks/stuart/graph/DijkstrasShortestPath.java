package com.perks.stuart.graph;

import java.util.*;

public class DijkstrasShortestPath {

    //stores parent of every vertex in shortest distance
    private Queue<DistanceNode> q;
    // Holds the shortest total distance of getting to node (key) from source
    private Map<Integer, Integer> distance = new HashMap<>();
    // holds Node and its parent.
    private Map<Integer, Integer> parent = new HashMap<>();

    // initialize all to parent null and distance MAX value except source node which is distance 0
    // as starting point
    private void initializeSingleSource(int[][] adjacencyMatrix, int source) {

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (i != source) {
                q.add(new DistanceNode(i, Integer.MAX_VALUE));
                distance.put(i, Integer.MAX_VALUE);
            } else {
                // set the starting node so 0
                q.add(new DistanceNode(i, 0));
                distance.put(i, 0);
            }
        }
    }

    public Set<Integer> search(int source, int targetNode, int[][] adjacencyMatrix) {
        // is the vertices key by distance value
        q = new PriorityQueue<>(new DistanceNodeComparator());
        // Initialize the Q with all infinity values
        initializeSingleSource(adjacencyMatrix, source);
        Set<Integer> s = new HashSet<>();

        // TODO this works with either priority queue is empty or this
        // Ideally S just contains the shortest path.
        // could also be s.size() != adjacencyMatrix.length
        while (!q.isEmpty()) {
            DistanceNode u = q.poll(); // take smallest weight from Q
            s.add(u.key); // could add whole node here
            for (int i = 0; i < adjacencyMatrix[u.key].length; i++) {

                int weight = adjacencyMatrix[u.key][i];
                if (weight != -1) {
                    // TODO could optimise and store the distance node in the cost
                    DistanceNode iInQueue = new DistanceNode(i, distance.get(i));

                    // non links are set to -1
                    // add distance of current adjVertex to edge weight to get distance of adjacent adjVertex from source adjVertex
                    // when it goes through current adjVertex
                    int newDistance = u.distance + weight;
                    relax(u, iInQueue, newDistance);
                }
            }

        }

        int node = targetNode;
        Set<Integer> shortestPath = new HashSet<>();
        while (node != source) {
            int nodeParent = parent.get(node);
            shortestPath.add(node);
            node = nodeParent;
        }
        shortestPath.add(source);

        System.out.println("Shortest path cost is " + distance.get(targetNode - 1));
        System.out.println("Shortest path is " + Arrays.toString(shortestPath.toArray()));

        return shortestPath;
    }

    private void relax(DistanceNode u, DistanceNode v, int newDistance) {
        if (v.distance > newDistance) {
            q.remove(v);
            DistanceNode vNode = new DistanceNode();
            vNode.key = v.key;
            vNode.distance = newDistance;
            q.add(vNode);
            parent.put(v.key, u.key);
            distance.put(v.key, newDistance);
            System.out.println("v " + v.key + " u" + u.key + " v.distance " + v.distance + " new distance " + newDistance);
        } else {
            System.out.println("Ignored v " + v.key + " u" + u.key + " v.distance " + v.distance + " new distance " + newDistance);
        }
    }

    public class DistanceNodeComparator implements Comparator<DistanceNode> {

        @Override
        public int compare(DistanceNode o1, DistanceNode o2) {
            return Integer.compare(o1.distance, o2.distance);
        }
    }

    static class DistanceNode {
        int distance;
        int key;

        public DistanceNode() {
        }

        public DistanceNode(int key, int distance) {
            this.key = key;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DistanceNode that = (DistanceNode) o;
            return key == that.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

}
