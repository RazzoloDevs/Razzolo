package test.java.it.razzolodevs.razzolo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class TrieTest extends TrieConfiguration{

    @Test
    public void buildTrie() throws IOException{
        boolean flag = true;
        int count = 0;
        file.getChannel().position(0);
        while(bufferedReader.ready()){
            final String line = bufferedReader.readLine();
            if(trie.search(line))
                count++;
            else
                flag = false;
        }

        Assertions.assertEquals(661563, count);
        Assertions.assertTrue(flag);
    }

    @Test
    public void searchSubstring() throws IOException{
        while(bufferedReader.ready())
            trie.insert(bufferedReader.readLine());

        Assertions.assertEquals(new HashSet<>(Arrays.asList('C', 'D', 'L', 'R', 'S', 'T', 'V', 'Z')), trie.searchBySubstring("ABA"));
        Assertions.assertEquals(new HashSet<>(Arrays.asList('A', 'E', 'N', 'O')), trie.searchBySubstring("ABBACCHI"));
    }
}
