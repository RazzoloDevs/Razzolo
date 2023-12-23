package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.LoadFile;
import main.java.it.razzolodevs.razzolo.model.trie.Trie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public abstract class TrieConfiguration extends Configuration {
    protected Trie trie;

    @BeforeEach
    protected void init(){
        bufferedReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
        foundWords = new HashSet<>();
        start = System.nanoTime();

        trie = new Trie();
    }

    @AfterEach
    protected void teardown() throws IOException {
    }
}