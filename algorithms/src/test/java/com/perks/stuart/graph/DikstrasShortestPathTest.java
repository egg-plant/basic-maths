package com.perks.stuart.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DikstrasShortestPathTest {

    @Test
    void search() {
        DikstrasShortestPath dijkstras = new DikstrasShortestPath(4);

        int[][] adjacencyList = new int[][]{{1, 2}, {2, 3}, {1, 3}, {}};
        // primitive way to represent weights for connections
        // non links are set to -1
        int[][] adjacencyMatrix = new int[][]{
                {-1, 6, 2, -1},
                {-1, -1, -1, 1},
                {-1, 3, -1, 5},
                {-1, -1, -1, -1}};

        assertEquals(new HashSet<>(Arrays.asList(0, 2, 1, 3)), dijkstras.search(0, adjacencyMatrix));

        dijkstras = new DikstrasShortestPath(4);
        int graph[][] = new int[][]{
                {-1, 5, 2, -1, -1, -1},
                {-1, -1, -1, 4, 2, -1},
                {-1, 8, -1, -1, 7, -1},
                {-1, -1, -1, -1, 6, 3},
                {-1, -1, -1, -1, -1, 1},
                {-1, -1, -1, -1, -1, -1}};

        assertEquals(new HashSet<>(Arrays.asList(0, 1, 4, 5)), dijkstras.search(0, graph));

        int graph2[][] = new int[][]{
                {-1, 10, -1, -1, -1},
                {-1, -1, 1, 20, -1},
                {-1, 1, -1, -1, -1},
                {-1, -1, 1, -1, 30},
                {-1, -1, -1, -1, -1}};

        assertEquals(new HashSet<>(Arrays.asList(0, 1, 3, 4)), dijkstras.search(0, graph2));


    }
}