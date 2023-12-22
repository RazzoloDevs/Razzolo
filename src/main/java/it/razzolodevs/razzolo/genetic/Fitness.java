package main.java.it.razzolodevs.razzolo.genetic;

import main.java.it.razzolodevs.razzolo.LoadFile;
import main.java.it.razzolodevs.razzolo.model.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Fitness {
    public static int function(final Point[] arrayPoint){
        final var sb = new StringBuilder();
        for(Point p : arrayPoint)
            sb.append(p.value());

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

    /**
     * @return numero di caratteri nell'ordine giusto
     */
    private static int evaluate(String s, String line){
        int score = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == line.charAt(i))
                score++;
        }
        return score;
    }

}
