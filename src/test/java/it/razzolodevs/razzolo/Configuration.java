package test.java.it.razzolodevs.razzolo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Configuration {
    protected final char[][] matrix = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'L', 'M', 'N'},
            {'O', 'P', 'Q', 'R'}
    };

    protected Set<String> foundWords;
    protected final Set<String> trueWords = new HashSet<>(Arrays.asList("GLEBA", "AFELIO", "FELPI", "FELPO", "POLI", "LEI", "FLIP", "FLOP"));
    protected long start;
}
