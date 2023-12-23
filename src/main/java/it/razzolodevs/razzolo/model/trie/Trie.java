package main.java.it.razzolodevs.razzolo.model.trie;

import java.util.HashMap;
import java.util.Set;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode node = new TrieNode();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c))
                node = children.get(c);
            else{
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.getChildren();
        }
        node.setLeaf(true);
    }

    public boolean search(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode node = new TrieNode();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                node = children.get(c);
                children = node.getChildren();
            }
            else
                return false;
        }
        return node.isLeaf();
    }

    public Set<Character> searchBySubstring(String substring){
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode node = new TrieNode();
        for(int i = 0; i < substring.length(); i++) {
            char c = substring.charAt(i);
            if(children.containsKey(c)) {
                node = children.get(c);
                children = node.getChildren();
            }
            else
                return null;
        }
        return children.keySet();
    }
}