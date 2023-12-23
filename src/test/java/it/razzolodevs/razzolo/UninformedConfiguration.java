package test.java.it.razzolodevs.razzolo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public abstract class UninformedConfiguration extends Configuration {

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