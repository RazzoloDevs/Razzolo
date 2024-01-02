package main.java.it.razzolodevs.razzolo.uninformed;

import main.java.it.razzolodevs.razzolo.Util;
import main.java.it.razzolodevs.razzolo.model.Direction;
import main.java.it.razzolodevs.razzolo.model.Point;

import java.util.List;
import java.util.Stack;

public class IterativeDeepening {
    private final char[][] matrix;

    public IterativeDeepening(final char[][] matrix){
        this.matrix = matrix;
    }

    public Point[] iterativeDeepening(String word, int i, int j){
        if(word.charAt(0) != matrix[i][j])
            return null;

        final Point[] coordinates = new Point[word.length()];
        final boolean[][] isVisited = new boolean[4][4];
        final Stack<Point> stack = new Stack<>();

        stack.push(new Point(i,j, matrix[i][j], 0));
        isVisited[i][j] = true;

        while(!stack.isEmpty()){
            final Point point = stack.pop();
            int currentIndex = point.getIndex();
            coordinates[currentIndex] = new Point(point.getI(), point.getJ());
            if(currentIndex == word.length()-1)
                return coordinates;

            int x = point.getI();
            int y = point.getJ();
            // check adjacent cells
            for(int k = 0; k< Direction.DIRECTIONS.length; k++){
                int deltaX = x + Direction.DIRECTIONS[k].x();
                int deltaY = y + Direction.DIRECTIONS[k].y();
                if(Util.checkCells(isVisited, deltaX, deltaY) && matrix[deltaX][deltaY] == word.charAt(currentIndex+1)){
                    stack.push(new Point(deltaX, deltaY, matrix[deltaX][deltaY], currentIndex+1));
                    isVisited[deltaX][deltaY] = true;
                }
            }
        }
        return null;
    }
}
