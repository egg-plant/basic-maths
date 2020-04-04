package com.perks.stuart.trees;

public class DepthFirstSearchTree {

    void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);
    }

    void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }

    public static void main(String[] args) {

        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(2);
        root.right = new BinaryNode(3);
        root.left.left = new BinaryNode(4);
        root.left.right = new BinaryNode(5);

        BinaryTree tree = new BinaryTree(root);

        DepthFirstSearchTree depthFirstSearchTree = new DepthFirstSearchTree();

        System.out.println("Running Pre Order on Tree");
        depthFirstSearchTree.preOrder(tree.root);
        System.out.println("Running InOrder on Tree");
        depthFirstSearchTree.inOrder(tree.root);
        System.out.println("Running Post Order on Tree");
        depthFirstSearchTree.postOrder(tree.root);

    }

}
