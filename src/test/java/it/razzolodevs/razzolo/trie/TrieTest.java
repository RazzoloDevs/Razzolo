package test.java.it.razzolodevs.razzolo.trie;

import main.java.it.razzolodevs.razzolo.model.HashDictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class TrieTest extends TrieConfiguration{
    @Test
    public void buildTrie(){

        boolean flag = true;
        int count = 0;
        final HashSet<String> hashDictionary = HashDictionary.getInstance();
        for(String s : hashDictionary){
            if(trie.search(s))
                count++;
            else
                flag = false;
        }

        Assertions.assertEquals(661563, count);
        Assertions.assertTrue(flag);
    }

    @Test
    public void searchSubstring(){
        Assertions.assertEquals(new HashSet<>(Arrays.asList('C', 'D', 'L', 'R', 'S', 'T', 'V', 'Z')), trie.searchBySubstring("ABA"));
        Assertions.assertEquals(new HashSet<>(Arrays.asList('A', 'E', 'N', 'O')), trie.searchBySubstring("ABBACCHI"));
    }
}
