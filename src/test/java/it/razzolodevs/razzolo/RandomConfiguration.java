package test.java.it.razzolodevs.razzolo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class RandomConfiguration {

    protected static final int SIZE = 4;
    protected static char[][] matrix;
    protected static Set<String> foundWords;
    protected static Set<String> foundWordsBfs;
    protected static Set<String> foundWordsDfs;
    protected static Set<String> foundWordID;
    protected long start;

    private static void randomConfiguration(){
        matrix = new char[SIZE][SIZE];
        Random random = new Random();
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'Z'};

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int randomIndex = random.nextInt(alphabet.length);
                matrix[i][j] = alphabet[randomIndex];
            }
        }
    }

    @BeforeAll
    static void beforeAllTest() {
        randomConfiguration();
        foundWordsBfs = new HashSet<>();
        foundWordsDfs = new HashSet<>();
        foundWordID = new HashSet<>();
    }

    @AfterEach
    protected void teardown() {
        final var end = System.nanoTime();
        System.out.format("Found words: %s\n", foundWords);
        System.out.format("Number of words: %d\n", foundWords.size());
        System.out.format("Elapsed time: %g s\n", ((double)(end-start))/1000000000);
    }

    @AfterAll
    static void afterAllTest() {
        if(foundWordsBfs.equals(foundWordsDfs) && foundWordsBfs.equals(foundWordID))
            System.out.println("Bfs, Dfs and ID returned the same sets of words");
        else
            System.out.println("Bfs, Dfs and ID returned different sets of words");
    }

}
