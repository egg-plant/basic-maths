package com.perks.stuart.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public int key;
    public List<Node> adjacentNodes = new ArrayList<>();

    public Node(int key) {
        this.key = key;
    }

    public void addAdjacentNode(Node child) {
        this.adjacentNodes.add(child);
    }
}
