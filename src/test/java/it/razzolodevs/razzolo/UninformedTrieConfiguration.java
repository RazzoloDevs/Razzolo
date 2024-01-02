package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.model.Trie;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;

public abstract class UninformedTrieConfiguration extends Configuration {
    protected Trie trie;

    @BeforeEach
    protected void init() {
        trie = Trie.getInstance();
        foundWords = new HashSet<>();
        start = System.nanoTime();
    }
}
