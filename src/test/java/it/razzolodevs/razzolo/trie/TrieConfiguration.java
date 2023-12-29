package test.java.it.razzolodevs.razzolo.trie;

import main.java.it.razzolodevs.razzolo.model.Trie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class TrieConfiguration {
    protected Trie trie;

    @BeforeEach
    protected void init() {
        trie = Trie.getInstance();
    }

    @AfterEach
    protected void teardown() {
    }
}