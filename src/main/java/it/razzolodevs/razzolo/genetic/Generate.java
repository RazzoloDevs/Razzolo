package main.java.it.razzolodevs.razzolo.genetic;

import main.java.it.razzolodevs.razzolo.model.Direction;
import main.java.it.razzolodevs.razzolo.model.Point;
import main.java.it.razzolodevs.razzolo.Util;

import java.util.ArrayList;
import java.util.List;

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
                for(int k = 0; k< Direction.DIRECTIONS.length; k++) {
                    int deltaI = string[stringIndex-1].getI() + Direction.DIRECTIONS[k].x();
                    int deltaJ = string[stringIndex-1].getJ() + Direction.DIRECTIONS[k].y();
                    if(Util.checkCells(isVisited, deltaI, deltaJ))
                        adjacentCells.add(new Point(deltaI, deltaJ, matrix[deltaI][deltaJ], stringIndex));
                }
                Point p = adjacentCells.get(Common.random.nextInt(adjacentCells.size()));
                string[stringIndex] = p;
                isVisited[string[stringIndex].getI()][string[stringIndex].getJ()] = true;
            }
            l.add(string);
        }
        return l;
    }
}
