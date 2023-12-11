package it.unisa.razzolo_debug.genetic;

import it.unisa.razzolo_debug.model.Point;

import java.util.ArrayList;
import java.util.List;

// Gli individui sono rappresentati da un array di Point
public class Generate {

    // Genera individui validi
    public static List<Point[]> generate(char[][] matrix){
        final List<Point[]> l = new ArrayList<>();
        final boolean[][] isVisited = new boolean[4][4];

        for(int a=0; a<Common.N_INDIVIDUALS; a++){
            int stringSize = Common.random.nextInt(2,7);
            Point[] string = new Point[stringSize];
            int x = Common.random.nextInt(4);
            int y = Common.random.nextInt(4);
            int currentIndex = 0;
            Point startPoint = new Point(x, y, matrix[x][y], currentIndex);
            for(int b=1; b<stringSize; b++){
                List<Point> adjacentCells = new ArrayList<>();
                for(int k=0; k<Point.directions.length; k++) {
                    int deltaX = x + Point.directions[k].x();
                    int deltaY = y + Point.directions[k].y();
                    if(checkCells(isVisited, deltaX, deltaY))
                        adjacentCells.add(new Point(deltaX, deltaY, matrix[deltaX][deltaY], b));
                }
                Point p = adjacentCells.get(Common.random.nextInt(adjacentCells.size()));
                string[b] = p;
            }
            l.add(string);
        }
        return l;
    }

    private static boolean checkCells(boolean[][] isVisited, int i, int j){
        if((i>=0 && i<4) && (j>=0 && j<4))
            return !isVisited[i][j];
        return false;
    }

}
