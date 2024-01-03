package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.uninformed.Bfs;
import main.java.it.razzolodevs.razzolo.uninformed.Dfs;
import main.java.it.razzolodevs.razzolo.uninformed.IterativeDeepening;
import org.junit.jupiter.api.Test;

public class RandomUninformedTest extends RandomUninformedConfiguration {

    @Test
    public void bfsTest() {
        System.out.println("Bfs:");
        final var bfs = new Bfs(matrix, dictionary);
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++) {
                foundWords.addAll(bfs.bfs(i, j).keySet());
                foundWordsBfs.addAll(bfs.bfs(i, j).keySet());
            }
    }

    @Test
    public void dfsTest() {
        System.out.println("Dfs:");
        final var dfs = new Dfs(matrix, dictionary);
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++){
                foundWords.addAll(dfs.dfs(i, j).keySet());
                foundWordsDfs.addAll(dfs.dfs(i, j).keySet());
            }
    }

    @Test
    public void IterativeDeepening() {
        System.out.println("Iterative Deepening:");
        final var iterativeDeepening =  new IterativeDeepening(matrix);
        for(final String s : dictionary)
            for(int i = 0; i < matrix.length; i++)
                for(int j = 0; j < matrix[i].length; j++)
                    if (iterativeDeepening.iterativeDeepening(s, i, j) != null) {
                        foundWords.add(s);
                        foundWordID.add(s);
                    }
    }

}
