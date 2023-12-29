package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.model.HashDictionary;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;

public abstract class UninformedConfiguration extends Configuration {
    protected HashSet<String> dictionary;

    @BeforeEach
    protected void init() {
        foundWords = new HashSet<>();
        dictionary = HashDictionary.getInstance();
        start = System.nanoTime();
    }

    @AfterEach
    protected void teardown() {
        final var end = System.nanoTime();
        System.out.format("Found words: %s\n", foundWords);
        System.out.format("Number of words: %d\n", foundWords.size());
        System.out.format("Elapsed time: %g s\n", ((double)(end-start))/1000000000);
        for(String s : trueWords)
            if(!foundWords.contains(s))
                System.out.format("%s not found\n",s);
    }
}