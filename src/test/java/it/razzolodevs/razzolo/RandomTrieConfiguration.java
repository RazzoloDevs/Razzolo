package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.model.HashDictionary;
import main.java.it.razzolodevs.razzolo.model.Trie;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.Set;

public class RandomTrieConfiguration extends RandomConfiguration{

    protected Trie trie;

    protected static Set<String> foundWordsBfsTrie;

    protected static Set<String> foundWordsDfsTrie;

    @BeforeAll
    static void beforeAllTest() {
        RandomConfiguration.randomConfiguration();
        foundWordsBfsTrie = new HashSet<>();
        foundWordsDfsTrie = new HashSet<>();
    }

    @BeforeEach
    protected void init() {
        foundWords = new HashSet<>();
        trie = Trie.getInstance();
        start = System.nanoTime();
    }

    @AfterAll
    static void afterAllTest() {
        if(foundWordsBfsTrie.equals(foundWordsDfsTrie))
            System.out.println("BfsTrie and DfsTrie returned the same sets of words");
        else
            System.out.println("BfsTrie and DfsTrie returned different sets of words");
    }

}
