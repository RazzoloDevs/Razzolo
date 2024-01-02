package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.uninformed.BfsTrie;
import main.java.it.razzolodevs.razzolo.uninformed.DfsTrie;
import org.junit.jupiter.api.Test;

public class UninformedTrieTest extends UninformedTrieConfiguration {

    @Test
    public void bfsTrieTest() {
        System.out.println("Bfs Trie:");
        final BfsTrie bfsTrie = new BfsTrie(matrix, trie);
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++)
                foundWords.addAll(bfsTrie.bfs(i, j).keySet());
    }

    @Test
    public void dfsTrieTest() {
        System.out.println("Dfs Trie:");
        final DfsTrie dfsTrie = new DfsTrie(matrix, trie);
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++)
                foundWords.addAll(dfsTrie.dfs(i, j).keySet());
    }
}
