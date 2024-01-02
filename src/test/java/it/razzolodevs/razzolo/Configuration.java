package test.java.it.razzolodevs.razzolo;

import org.junit.jupiter.api.AfterEach;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Configuration {
    protected final char[][] matrix = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'M', 'M', 'N'},
            {'O', 'P', 'Q', 'R'}
    };

    protected Set<String> foundWords;
    protected final Set<String> trueWords = new HashSet<>(Arrays.asList("GLEBA", "AFELIO", "FELPI", "FELPO", "POLI", "LEI", "FLIP", "FLOP"));
    protected long start;

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