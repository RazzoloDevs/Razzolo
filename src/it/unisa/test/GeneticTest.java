package it.unisa.test;

import it.unisa.genetic.Generate;
import it.unisa.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static it.unisa.bruteforce.Bfs.bfs;
import static it.unisa.model.Point.getString;

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
            String s  = getString(p);
            if(!bfs(matrix, s))
                errorList.add(s);
        }
        System.out.println("Parole non trovate: " + errorList);
        Assertions.assertEquals(errorList.size(), 0);
    }
}
