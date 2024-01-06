package main.java.it.razzolodevs.razzolo.model;

import main.java.it.razzolodevs.razzolo.dictionary.HashDictionary;

import java.util.HashMap;
import java.util.Set;

public class Trie
{
    private final TrieNode root;
    private static Trie _instance = null;

    private Trie()
    {
        this.root = new TrieNode();

        _buildTrie();
    }

    public static Trie getInstance()
    {
        if (_instance == null)
            _instance = new Trie();

        return _instance;
    }

    private void _buildTrie()
    {
        for (final var s : HashDictionary.getSet())
            _insert(s);
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

    private TrieNode traverse(String str)
    {
        var current = root;

        for (final var c : str.toCharArray())
        {
            if (!current.getChildren().containsKey(c))
                return null;

            current = current.getChildren().get(c);
        }

        return current;
    }

    public boolean search(String word)
    {
        final var node = traverse(word);

        return node != null && node.isLeaf();
    }

    public Set<Character> searchBySubstring(String substring)
    {
        final var node = traverse(substring);

        if (node == null)
            return null;

        return node.getChildren().keySet();
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