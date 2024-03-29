package org.lcrosby.ghostwordapi.service;

import java.util.HashMap;
import java.util.Map;

/**
 * The Trie data structure that contains the strings to be optimally retrieved.
 * This is a well known data structure.
 *
 * https://en.wikipedia.org/wiki/Trie
 *
 * @author lcrosby (this implementation) et al (the algorithm).
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word to the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            if (i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    // Returns true if the word is located in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        return t != null && t.isLeaf;
    }

    // Returns true if there is some word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }

    static class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;

        TrieNode() {
        }

        TrieNode(char c) {
            this.c = c;
        }
    }
}

