package test.java.it.razzolodevs.razzolo;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static main.java.it.razzolodevs.razzolo.bruteforce.Bfs.bfs;
import static main.java.it.razzolodevs.razzolo.bruteforce.Dfs.dfs;

public class BruteForceTest extends Configuration{

    @Test
    public void bfsTest() throws IOException {
        System.out.println("Bfs:");
        while(bufferedReader.ready()){
            String line = bufferedReader.readLine();
            if(bfs(matrix, line))
                foundWords.add(line);
        }
    }

    @Test
    public void dfsTest() throws IOException {
        System.out.println("Dfs:");
        while(bufferedReader.ready()){
            String line = bufferedReader.readLine();
            if(dfs(matrix, line))
                foundWords.add(line);
        }
    }
}

