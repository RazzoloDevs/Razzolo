package it.unisa.genetic;

import it.unisa.model.Point;

import java.util.ArrayList;
import java.util.List;

import static it.unisa.Util.checkCells;

// Gli individui sono rappresentati da un array di Point
public class Generate {

    // Genera individui validi
    public static List<Point[]> generate(char[][] matrix){
        final List<Point[]> l = new ArrayList<>();

        for(int a=0; a<Common.N_INDIVIDUALS; a++){
            final boolean[][] isVisited = new boolean[4][4];

            int stringSize = Common.random.nextInt(2,7);
            Point[] string = new Point[stringSize];
            final int x = Common.random.nextInt(4);
            final int y = Common.random.nextInt(4);
            string[0] = new Point(x, y, matrix[x][y], 0);
            isVisited[x][y] = true;
            for(int stringIndex = 1; stringIndex < stringSize; stringIndex++){
                List<Point> adjacentCells = new ArrayList<>();
                for(int k=0; k<Point.directions.length; k++) {
                    int deltaI = string[stringIndex-1].i() + Point.directions[k].x();
                    int deltaJ = string[stringIndex-1].j() + Point.directions[k].y();
                    if(checkCells(isVisited, deltaI, deltaJ))
                        adjacentCells.add(new Point(deltaI, deltaJ, matrix[deltaI][deltaJ], stringIndex));
                }
                Point p = adjacentCells.get(Common.random.nextInt(adjacentCells.size()));
                string[stringIndex] = p;
                isVisited[string[stringIndex].i()][string[stringIndex].j()] = true;
            }
            l.add(string);
        }
        return l;
    }
}
