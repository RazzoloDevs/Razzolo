package test.java.it.razzolodevs.razzolo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TrieTest extends TrieConfiguration{

    @Test
    public void buildTrie() throws IOException{
        final var l = new ArrayList<String>();
        while(bufferedReader.ready()){
            String line = bufferedReader.readLine();
            l.add(line);
            trie.insert(line);
        }

        for(String s : l)
            if(!trie.search(s))
                System.out.println(s + " non trovata");

        Assertions.assertEquals(661563, l.size());
    }

    @Test
    public void searchSubstring() throws IOException{
        while(bufferedReader.ready())
            trie.insert(bufferedReader.readLine());

        Assertions.assertEquals(new HashSet<>(Arrays.asList('C', 'D', 'L', 'R', 'S', 'T', 'V', 'Z')), trie.searchBySubstring("ABA"));
        Assertions.assertEquals(new HashSet<>(Arrays.asList('A', 'E', 'N', 'O')), trie.searchBySubstring("ABBACCHI"));

    }
}
