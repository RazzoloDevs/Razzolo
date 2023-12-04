package it.unisa.razzolo_debug.genetic;

import it.unisa.razzolo_debug.LoadFile;
import it.unisa.razzolo_debug.model.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/*
    Gli individui sono caratterizzati da un array di Point
*/

public class Genetic {
    /**
     * @return numero di caratteri nell'ordine giusto
     */
    public static int fitness(final Point[] arrayPoint){
        final var sb = new StringBuilder();
        for(Point p : arrayPoint)
            sb.append(p);

        String s = sb.toString();
        int score = 0;
        final var bufferedReader = new BufferedReader(new InputStreamReader(LoadFile.getInstance(), StandardCharsets.UTF_8));
        try {
            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                score += evaluate(s, line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return score;
    }

    private static int evaluate(String s, String line){
        int score = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == line.charAt(i))
                score++;
        }
        return score;
    }

}
