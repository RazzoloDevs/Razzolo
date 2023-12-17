package it.unisa.test;

import it.unisa.Algorithms;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BfsDfsTest extends Configuration{

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
                    if(matrix[i][j] == line.charAt(0) && Algorithms.dfs(matrix, i, j, line))
                        foundWords.add(line);
                }
                file.getChannel().position(0);
                bufferedReader = new BufferedReader(new InputStreamReader(file));
            }
        }
    }
}

