package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.model.HashDictionary;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;

public class RandomUninformedConfiguration extends RandomConfiguration {

    protected HashSet<String> dictionary;

    protected static Set<String> foundWordsBfs;

    protected static Set<String> foundWordsDfs;

    protected static Set<String> foundWordID;

    @BeforeAll
    static void beforeAllTest() {
        RandomConfiguration.randomConfiguration();
        foundWordsBfs = new HashSet<>();
        foundWordsDfs = new HashSet<>();
        foundWordID = new HashSet<>();
    }

    @BeforeEach
    protected void init() {
        foundWords = new HashSet<>();
        dictionary = HashDictionary.getInstance();
        start = System.nanoTime();
    }

    @AfterAll
    static void afterAllTest() {
        if(foundWordsBfs.equals(foundWordsDfs) && foundWordsBfs.equals(foundWordID))
            System.out.println("Bfs, Dfs and ID returned the same sets of words");
        else
            System.out.println("Bfs, Dfs and ID returned different sets of words");
    }

}
