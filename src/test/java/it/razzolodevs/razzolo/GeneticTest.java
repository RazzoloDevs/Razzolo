package test.java.it.razzolodevs.razzolo;

import main.java.it.razzolodevs.razzolo.genetic.Generate;
import main.java.it.razzolodevs.razzolo.model.Point;
import main.java.it.razzolodevs.razzolo.bruteforce.Bfs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GeneticTest{
    protected final char[][] matrix = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'L', 'M', 'N'},
            {'O', 'P', 'Q', 'R'}
    };

    // controllo se gli individui generati sono presenti nella matrice
    @Test
    public void generateTest(){
        List<String> errorList = new ArrayList<>();
        final var l = Generate.generate(matrix);
        for(Point[] p : l){
            String s  = Point.getString(p);
            if(!Bfs.bfs(matrix, s))
                errorList.add(s);
        }
        System.out.println("Parole non trovate: " + errorList);
        Assertions.assertEquals(errorList.size(), 0);
    }
}
