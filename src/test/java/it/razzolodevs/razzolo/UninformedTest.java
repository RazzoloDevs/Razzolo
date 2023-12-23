package test.java.it.razzolodevs.razzolo;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static main.java.it.razzolodevs.razzolo.uninformed.Bfs.bfs;
import static main.java.it.razzolodevs.razzolo.uninformed.Dfs.dfs;
import static main.java.it.razzolodevs.razzolo.uninformed.IterativeDeepening.iterativeDeepening;

public class UninformedTest extends Configuration{

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

    @Test
    public void IterativeDeepening() throws IOException {
        System.out.println("Iterative Deepening:");
        while(bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if (iterativeDeepening(matrix, line, i, j))
                        foundWords.add(line);
        }
    }
}

