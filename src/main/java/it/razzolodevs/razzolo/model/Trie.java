package main.java.it.razzolodevs.razzolo.model;

import main.java.it.razzolodevs.razzolo.Dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Set;

public class Trie
{
    private final TrieNode root;

    public Trie() throws IOException
    {
        this.root = new TrieNode();

        _buildTrie();
    }

    public void insert(String word)
    {
        var children = root.getChildren();
        var node = new TrieNode();

        for (final var c : word.toCharArray())
        {
            if (children.containsKey(c))
                node = children.get(c);
            else
            {
                node = new TrieNode(c);
                children.put(c, node);
            }

            children = node.getChildren();
        }

        node.setLeaf(true);
    }

    public boolean search(String word)
    {
        var children = root.getChildren();
        var node = new TrieNode();

        for (final var c : word.toCharArray())
        {
            if (children.containsKey(c))
            {
                node = children.get(c);
                children = node.getChildren();
            }
            else
                return false;
        }

        return node.isLeaf();
    }

    public Set<Character> searchBySubstring(String substring)
    {
        var children = root.getChildren();

        for (final var c : substring.toCharArray())
        {
            if (children.containsKey(c))
            {
                final var node = children.get(c);
                children = node.getChildren();
            }
            else
                return null;
        }

        return children.keySet();
    }

    private void _buildTrie() throws IOException
    {
        final var file = Dictionary.getInstance();
        try (final var channel = file.getChannel())
        {
            channel.position(0);

            final var bufferedReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
            while (bufferedReader.ready())
                this.insert(bufferedReader.readLine());
        }
    }

    private static class TrieNode
    {
        private char val;
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean isLeaf;

        public TrieNode() {}

        public TrieNode(char c)
        {
            this.val = c;
        }

        public HashMap<Character, TrieNode> getChildren()
        {
            return this.children;
        }

        public void setChildren(HashMap<Character, TrieNode> children)
        {
            this.children = children;
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