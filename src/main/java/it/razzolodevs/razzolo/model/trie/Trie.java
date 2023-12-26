package main.java.it.razzolodevs.razzolo.model.trie;

import main.java.it.razzolodevs.razzolo.LoadFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Set;

public class Trie {
    private final TrieNode root;

    public Trie() throws IOException {
        root = new TrieNode();
        _buildTrie();
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

        TrieNode node;
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

    private void _buildTrie() throws IOException {
        final var file = LoadFile.getInstance();
        final var bufferedReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
        while(bufferedReader.ready()){
            this.insert(bufferedReader.readLine());
        }
        /*
        BufferedReader bufferedReader = null;
        String s;
        final var file = LoadFile.getInstance();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
            while((s = bufferedReader.readLine()) != null)
                this.insert(s);
        } catch (IOException e){
            throw new RuntimeException(e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            file.getChannel().position(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
    }
}