package main.java.it.razzolodevs.razzolo.model;

import main.java.it.razzolodevs.razzolo.Dictionary;

import java.io.*;
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

    private void _buildTrie()
    {
        final RandomAccessFile randomAccessFile = Dictionary.getInstance();
        final BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(randomAccessFile.getFD()));
            randomAccessFile.seek(0);
            while(bufferedReader.ready()){
                final String s = bufferedReader.readLine();
                this._insert(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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