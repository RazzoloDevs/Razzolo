package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.model.Point;
import main.java.it.razzolodevs.razzolo.model.Trie;

import java.util.*;

public abstract class Configuration {
    protected static final int SIZE = 4;
    protected static char[][] matrix = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'L', 'M', 'N'},
            {'O', 'P', 'Q', 'R'}
    };

    protected static char[][] rMatrix;
    protected HashMap<String, ArrayList<Point>> foundWords;
    protected final Set<String> trueWords = new HashSet<>(Arrays.asList("GLEBA", "AFELIO", "FELPI", "FELPO", "POLI", "LEI", "FLIP", "FLOP"));   // vocaboli che devono essere trovati dall'algoritmo
    protected static HashSet<String> dictionary;
    protected static Trie trie;
    protected long start;

    protected static void randomMatrix(){
        rMatrix = new char[SIZE][SIZE];
        Random random = new Random();
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'Z'};

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int randomIndex = random.nextInt(alphabet.length);
                rMatrix[i][j] = alphabet[randomIndex];
            }
        }
    }

    protected static void printMatrix(char[][] matrix){
        for (char[] chars : matrix) {
            for (char c : chars)
                System.out.print(c + " ");
            System.out.println();
        }
    }

    protected void teardown() {
        final var end = System.nanoTime();
        System.out.format("Found words: %s\n", foundWords.keySet());
        System.out.format("Number of words: %d\n", foundWords.keySet().size());
        System.out.format("Elapsed time: %g s\n", ((double)(end-start))/1000000000);
    }
}