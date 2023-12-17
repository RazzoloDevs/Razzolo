package it.unisa.test;

import it.unisa.LoadFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Configuration {
    protected final char[][] matrix = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'L', 'M', 'N'},
            {'O', 'P', 'Q', 'R'}
    };
    protected Set<String> foundWords;
    protected final Set<String> trueWords = new HashSet<>(Arrays.asList("GLEBA", "AFELIO", "FELPI", "FELPO", "POLI", "LEI", "FLIP", "FLOP"));
    protected final FileInputStream file = LoadFile.getInstance();
    protected BufferedReader bufferedReader;
    protected long start;

    @BeforeEach
    protected void init(){
        bufferedReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
        foundWords = new HashSet<>();
        start = System.nanoTime();
    }

    @AfterEach
    protected void teardown() throws IOException {
        final var end = System.nanoTime();
        file.getChannel().position(0);
        System.out.format("Found words: %s\n", foundWords);
        System.out.format("Elapsed time: %g s\n", ((double)(end-start))/1000000000);
        for(String s : trueWords)
            if(!foundWords.contains(s))
                System.out.format("%s not found\n",s);
    }
}