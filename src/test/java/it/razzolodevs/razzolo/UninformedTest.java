package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.dictionary.HashDictionary;
import main.java.it.razzolodevs.razzolo.informed.BfsTrie;
import main.java.it.razzolodevs.razzolo.informed.DfsTrie;
import main.java.it.razzolodevs.razzolo.model.Trie;
import main.java.it.razzolodevs.razzolo.uninformed.*;
import org.junit.jupiter.api.*;

public class UninformedTest extends Configuration {

    @BeforeAll
    protected static void beforeAllTest() {
        printMatrix(matrix);
        dictionary = HashDictionary.getSet();
        trie = Trie.getInstance();
    }

    @BeforeEach
    protected void init() {
        start = System.nanoTime();
    }

    @AfterEach
    protected void teardown() {
        super.teardown();
        for(String s : trueWords)
            if(!foundWords.containsKey(s))
                System.out.println("Word not found: " + s);
    }

    @AfterAll
    protected static void afterAllTest() {
    }

    @Test
    public void bfsTest() {
        System.out.println("Bfs:");
        foundWords = Bfs.run(matrix, dictionary);
    }

    @Test
    public void dfsTest() {
        System.out.println("Dfs:");
        foundWords = Dfs.run(matrix, dictionary);
    }

    @Test
    public void IterativeDeepening() {
        System.out.println("Iterative Deepening:");
        foundWords = IterativeDeepening.run(matrix, dictionary);
    }

    @Test
    public void bfsTrieTest() {
        System.out.println("Bfs Trie:");
        foundWords = BfsTrie.run(matrix, trie);
    }

    @Test
    public void dfsTrieTest() {
        System.out.println("Dfs Trie:");
        foundWords = DfsTrie.run(matrix, trie);
    }
}