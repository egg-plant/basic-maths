package com.perks.stuart.trees;


// https://www.geeksforgeeks.org/trie-insert-and-search/
// Retrieval data structure for finding and mapping words
public class TrieTree {

    private static final int ALPHABET_SIZE = 26;
    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int level;
        int length = word.length();
        int index;

        TrieNode currentNode = root;

        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a'; // Use the char int value but start at the first letter of the Alphabet.
            if (currentNode.children[index] == null)
                currentNode.children[index] = new TrieNode();
            // stores the character as the integer representation in the index
            currentNode = currentNode.children[index];
            // Keeps track of the current times this node is called so when inserting so we know how many children it has
            // including itself as 1 so hac when we search for it c is found and its one.
            currentNode.currentSize++;
        }

        // mark last node as leaf
        currentNode.isEndOfWord = true;

    }

    public int search(String word) {
        int level;
        int length = word.length();
        int index;
        TrieNode currentNode = root;

        for (level = 0; level < length; level++) {
            index = word.charAt(level) - 'a'; // a is the starting index

            if (currentNode.children[index] == null)
                return 0;

            currentNode = currentNode.children[index];
        }

        return currentNode.currentSize;
    }


    public static class TrieNode {
        // Alternatively use a Map<Character, TrieNode>
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        // Holds itself being set and counts how many times its called to add next items.
        int currentSize = 0;
        // end of a word
        boolean isEndOfWord;

        public TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

}
