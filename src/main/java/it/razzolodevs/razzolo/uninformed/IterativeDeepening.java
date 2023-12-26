package main.java.it.razzolodevs.razzolo.uninformed;

import main.java.it.razzolodevs.razzolo.Util;
import main.java.it.razzolodevs.razzolo.model.Direction;
import main.java.it.razzolodevs.razzolo.model.Point;

public class IterativeDeepening {
    public static boolean iterativeDeepening(char[][] matrix, String word, int i, int j){
        if(word.charAt(0) != matrix[i][j])
            return false;

        final boolean[][] isVisited = new boolean[4][4];

        Point point = new Point(i, j, matrix[i][j], 0);
        isVisited[i][j] = true;

        boolean flag = true;
        while(flag){
            flag = false;
            int currentIndex = point.getIndex();
            if(currentIndex == word.length()-1)
                return true;

            int x = point.getI();
            int y = point.getJ();
            // check adjacent cells
            for(int k = 0; k< Direction.DIRECTIONS.length; k++){
                int deltaX = x + Direction.DIRECTIONS[k].x();
                int deltaY = y + Direction.DIRECTIONS[k].y();
                if(Util.checkCells(isVisited, deltaX, deltaY) && matrix[deltaX][deltaY] == word.charAt(currentIndex+1)){
                    point = new Point(deltaX, deltaY, matrix[deltaX][deltaY], currentIndex+1);
                    isVisited[deltaX][deltaY] = true;
                    flag = true;
                }
            }
        }
        return false;
    }
}
