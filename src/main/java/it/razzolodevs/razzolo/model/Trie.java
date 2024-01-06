package main.java.it.razzolodevs.razzolo.model;

import java.util.HashMap;
import java.util.Set;

public class Trie
{
    private final TrieNode root;
    private static Trie trie;

    private Trie()
    {
        this.root = new TrieNode();

        _buildTrie();
    }

    public static Trie getInstance()
    {
        if(trie == null)
            trie = new Trie();
        return trie;
    }

    private void _insert(String word)
    {
        var children = root.getChildren();
        var node = new TrieNode();

        for (final var c : word.toCharArray())
        {
            if (children.containsKey(c))
                node = children.get(c);
            else
            {
                node = new TrieNode();
                children.put(c, node);
            }

            children = node.getChildren();
        }

        node.setLeaf(true);
    }

    private TrieNode traverse(String str) {
        TrieNode current = root;
        for (char c : str.toCharArray()) {
            if (!current.getChildren().containsKey(c)) {
                return null;
            }
            current = current.getChildren().get(c);
        }
        return current;
    }

    public boolean search(String word) {
        TrieNode node = traverse(word);
        return node != null && node.isLeaf();
    }

    public Set<Character> searchBySubstring(String substring) {
        TrieNode node = traverse(substring);
        if (node == null) {
            return null;
        }
        return node.getChildren().keySet();
    }

    private void _buildTrie()
    {
        final var hashDictionary = HashDictionary.getInstance();
        for(final var s : hashDictionary)
            this._insert(s);
    }

    private static class TrieNode
    {
        private final HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean isLeaf;

        public TrieNode() {}

        public HashMap<Character, TrieNode> getChildren()
        {
            return this.children;
        }

        public boolean isLeaf()
        {
            return this.isLeaf;
        }

        public void setLeaf(boolean isLeaf)
        {
            this.isLeaf = isLeaf;
        }

    }
}