package com.perks.stuart.graph;

public class Representation {

    // Represents each connection with starting node and ending node.
    private int[][] edgeList = {{0, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 5}, {4, 5}};
    // Rows are the nodes with the index matching and a 1 is representing a connection.
    private int[][] adjMatrix = {
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0}};
    // Index is node and list is values associated. Most efficient memory wise.
    private int[][] adjList = {{2}, {3}, {3, 4}, {5}, {5}, {}};

}
