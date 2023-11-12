package it.unisa.razzolo_debug;

import org.junit.jupiter.api.Assertions;
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
    private final FileInputStream file = LoadFile.getInstance();


    @Test
    public Set<String> bfsTest() throws IOException {
        var bufferedReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));

        long start = System.nanoTime();
        Set<String> foundWords = new HashSet<>();
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
        long end = System.nanoTime();

        System.out.format("Found words: %s\n", foundWords);
        System.out.println("Elapsed time: " + (end-start) + "ns");

        Set<String> trueWords = new HashSet<>(Arrays.asList("GLEBA","AFELIO","FELPI","FELPO","POLI","LEI","FLIP","FLOP"));
        for(String s : trueWords){
            if(!foundWords.contains(s))
                System.out.format("%s not found\n",s);
        }
        return foundWords;
    }

    @Test
    public Set<String> dfsTest() throws IOException {
        var bufferedReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));

        long start = System.nanoTime();
        Set<String> foundWords = new HashSet<>();
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
        long end = System.nanoTime();

        System.out.format("Found words: %s\n", foundWords);
        System.out.println("Elapsed time: " + (end-start) + "ns");

        Set<String> trueWords = new HashSet<>(Arrays.asList("GLEBA","AFELIO","FELPI","FELPO","POLI","LEI","FLIP","FLOP"));
        for(String s : trueWords){
            if(!foundWords.contains(s))
                System.out.format("%s not found\n",s);
        }
        return foundWords;
    }

    @Test
    public void bfs_dfsAreEqual() throws IOException {
        Assertions.assertEquals(bfsTest(), dfsTest());
    }
}

