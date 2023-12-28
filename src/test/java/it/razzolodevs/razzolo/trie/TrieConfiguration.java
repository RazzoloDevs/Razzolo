package test.java.it.razzolodevs.razzolo.trie;

import main.java.it.razzolodevs.razzolo.LoadFile;
import main.java.it.razzolodevs.razzolo.model.Trie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public abstract class TrieConfiguration {
    protected Trie trie;
    protected BufferedReader bufferedReader;

    @BeforeEach
    protected void init() throws IOException {
        trie = new Trie();
        FileInputStream file = LoadFile.getInstance();
        file.getChannel().position(0);
        bufferedReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
    }

    @AfterEach
    protected void teardown() {
    }
}