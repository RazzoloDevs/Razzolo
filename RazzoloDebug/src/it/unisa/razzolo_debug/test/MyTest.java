package it.unisa.razzolo_debug.test;

import it.unisa.razzolo_debug.Algorithms;
import it.unisa.razzolo_debug.LoadFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyTest {
    private final char[][] matrix = {
        {'A','B','C','D'},
        {'E','F','G','H'},
        {'I','L','M','N'},
        {'O','P','Q','R'}
    };
    private Set<String> foundWords = new HashSet<>();
    private final Set<String> trueWords = new HashSet<>(Arrays.asList("GLEBA","AFELIO","FELPI","FELPO","POLI","LEI","FLIP","FLOP"));;
    private final FileInputStream file = LoadFile.getInstance();
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
    private long start;

    @BeforeEach
    public void init(){
        bufferedReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
        foundWords = new HashSet<>();
        start = System.nanoTime();
    }

    @AfterEach
    public void teardown(){
        final var end = System.nanoTime();
        System.out.format("Found words: %s\n", foundWords);
        System.out.format("Elapsed time: %g s\n", ((double)(end-start))/1000000000);
        for(String s : trueWords)
            if(!foundWords.contains(s))
                System.out.format("%s not found\n",s);
    }

    @Test
    public void bfsTest() throws IOException {
        System.out.println("Bfs:");
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                while(bufferedReader.ready()){
                    String line = bufferedReader.readLine();
                    if(matrix[i][j] == line.charAt(0) && Algorithms.bfs(matrix, i, j, line))
                        foundWords.add(line);
                }
                file.getChannel().position(0);
                bufferedReader = new BufferedReader(new InputStreamReader(file));
            }
        }
    }

    @Test
    public void dfsTest() throws IOException {
        System.out.println("Dfs:");
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                while(bufferedReader.ready()){
                    String line = bufferedReader.readLine();
                    if(matrix[i][j] == line.charAt(0) && Algorithms.bfs(matrix, i, j, line))
                        foundWords.add(line);
                }
                file.getChannel().position(0);
                bufferedReader = new BufferedReader(new InputStreamReader(file));
            }
        }
    }
}

