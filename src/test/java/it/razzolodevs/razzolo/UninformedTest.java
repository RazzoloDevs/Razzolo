package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.uninformed.Bfs;
import main.java.it.razzolodevs.razzolo.uninformed.Dfs;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static main.java.it.razzolodevs.razzolo.uninformed.IterativeDeepening.iterativeDeepening;

public class UninformedTest extends UninformedConfiguration {

    @Test
    public void bfsTest() throws IOException {
        System.out.println("Bfs:");
        final Bfs bfs = new Bfs(matrix);
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++)
                foundWords.addAll(bfs.bfs(i, j));
    }

    @Test
    public void dfsTest() throws IOException {
        System.out.println("Dfs:");
        final Dfs dfs = new Dfs(matrix);
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++)
                foundWords.addAll(dfs.dfs(i, j));
    }

    @Test
    public void IterativeDeepening() throws IOException {
        System.out.println("Iterative Deepening:");
        while(bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            for(int i = 0; i < matrix.length; i++)
                for(int j = 0; j < matrix[i].length; j++)
                    if (iterativeDeepening(matrix, line, i, j))
                        foundWords.add(line);
        }
    }
}

