package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.LoadFile;
import main.java.it.razzolodevs.razzolo.model.trie.Trie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TrieTest {

    @Test
    public void buildTrie() throws IOException{
        final var file = LoadFile.getInstance();
        final var bufferedReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));

        final Trie trie = new Trie();

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
}
