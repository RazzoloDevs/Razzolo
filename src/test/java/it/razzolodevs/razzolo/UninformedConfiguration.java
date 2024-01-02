package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.model.HashDictionary;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;

public abstract class UninformedConfiguration extends Configuration {
    protected HashSet<String> dictionary;

    @BeforeEach
    protected void init() {
        foundWords = new HashSet<>();
        dictionary = HashDictionary.getInstance();
        start = System.nanoTime();
    }
}