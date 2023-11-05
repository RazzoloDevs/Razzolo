import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyTest {
    @Test
    public void bfsTest(){

        char[][] matrix = {
                {'A','B','C','D'},
                {'E','F','G','H'},
                {'I','L','M','N'},
                {'O','P','Q','R'}
        };

        Set<String> wordList = new HashSet<>();
        wordList.add("GLEBA");
        wordList.add("AFELIO");
        wordList.add("FELPI");
        wordList.add("FELPO");
        wordList.add("ABCD");
        wordList.add("POLI");
        wordList.add("LEI");
        wordList.add("FLIP");
        wordList.add("FLOP");
        wordList.add("ABZ");
        wordList.add("AAA");
        wordList.add("ABA");
        wordList.add("LOLI");

        long start = System.nanoTime();
        Set<String> foundWords = new HashSet<>();
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                for(String s : wordList)
                    if(matrix[i][j] == s.charAt(0) && Algorithms.bfs(matrix, i, j, s))
                        foundWords.add(s);
        long end = System.nanoTime();

        System.out.println(foundWords);
        System.out.println("Elapsed time: " + (end-start) + "ns");

        Set<String> trueWords = new HashSet<>(Arrays.asList("GLEBA","AFELIO","FELPI","FELPO","ABCD","POLI","LEI","FLIP","FLOP"));
        Assertions.assertEquals(foundWords, trueWords);
    }
}

