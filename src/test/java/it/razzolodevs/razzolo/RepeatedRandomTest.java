package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.dictionary.HashDictionary;
import main.java.it.razzolodevs.razzolo.informed.BfsTrie;
import main.java.it.razzolodevs.razzolo.informed.DfsTrie;
import main.java.it.razzolodevs.razzolo.model.Trie;
import main.java.it.razzolodevs.razzolo.uninformed.Bfs;
import main.java.it.razzolodevs.razzolo.uninformed.Dfs;
import main.java.it.razzolodevs.razzolo.uninformed.IterativeDeepening;
import org.junit.jupiter.api.*;

public class RepeatedRandomTest extends Configuration {

    @BeforeEach
    protected void init() {
        randomMatrix();
        printMatrix(rMatrix);
        dictionary = HashDictionary.getSet();
        trie = Trie.getInstance();
    }

    @BeforeAll
    protected static void beforeAllTest() {
    }

    @AfterEach
    protected void teardown() {
    }

    @AfterAll
    protected static void afterAllTest() {
    }

    @RepeatedTest(3)
    public void runAllAlgorithmsTest(){
        System.out.println("Running tests on new random matrix");

        start = System.nanoTime();
        System.out.println("Bfs:");
        foundWords = Bfs.run(rMatrix, dictionary);
        resultTest();

        start = System.nanoTime();
        System.out.println("Dfs:");
        foundWords = Dfs.run(rMatrix, dictionary);
        resultTest();

        start = System.nanoTime();
        System.out.println("Iterative Deepening:");
        foundWords = IterativeDeepening.run(rMatrix, dictionary);
        resultTest();

        start = System.nanoTime();
        System.out.println("Bfs Trie:");
        foundWords = BfsTrie.run(rMatrix, trie);
        resultTest();

        start = System.nanoTime();
        System.out.println("Dfs Trie:");
        foundWords = DfsTrie.run(rMatrix, trie);
        resultTest();
    }

    private void resultTest(){
        final var end = System.nanoTime();
        System.out.format("Found words: %s\n", foundWords.keySet());
        System.out.format("Number of words: %d\n", foundWords.keySet().size());
        System.out.format("Elapsed time: %g s\n", ((double)(end-start))/1000000000);
    }

}
