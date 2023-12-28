package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.model.Trie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.HashSet;

public abstract class UninformedTrieConfiguration extends Configuration {
    protected Trie trie;

    @BeforeEach
    protected void init() throws IOException {
        trie = new Trie();
        foundWords = new HashSet<>();
        start = System.nanoTime();
    }

    @AfterEach
    protected void teardown() {
        final var end = System.nanoTime();
        System.out.format("Found words: %s\n", foundWords);
        System.out.format("Elapsed time: %g s\n", ((double)(end-start))/1000000000);
        for(String s : trueWords)
            if(!foundWords.contains(s))
                System.out.format("%s not found\n",s);
    }
}
