package com.perks.stuart.graph;

public class Representation {

    private int[][] edgeList = {{0, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 5}, {4, 5}};
    private int[][] adjMatrix = {
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0}};
    private int[][] adjList = {{2}, {3}, {3, 4}, {5}, {5}, {}};

}
