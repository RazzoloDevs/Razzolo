package main.java.it.razzolodevs.razzolo.uninformed;

import main.java.it.razzolodevs.razzolo.Util;
import main.java.it.razzolodevs.razzolo.model.Direction;
import main.java.it.razzolodevs.razzolo.model.Point;

import java.util.*;

public class IterativeDeepening {
    private static char[][] matrix;

    private static Point[] iterativeDeepening(String word, int i, int j){
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
            for(final var direction : Direction.DIRECTIONS){
                int deltaX = x + direction.x();
                int deltaY = y + direction.y();
                if(Util.checkCells(isVisited, deltaX, deltaY) && matrix[deltaX][deltaY] == word.charAt(currentIndex+1)){
                    stack.push(new Point(deltaX, deltaY, matrix[deltaX][deltaY], currentIndex+1));
                    isVisited[deltaX][deltaY] = true;
                }
            }
        }
        return null;
    }

    public static HashMap<String, ArrayList<Point>> run(char[][] m, HashSet<String> dictionary){
        matrix = m;
        final var l = new HashMap<String, ArrayList<Point>>();
        for(final String s : dictionary)
            for(int i = 0; i < matrix.length; i++)
                for(int j = 0; j < matrix[i].length; j++){
                    final var coordinates = iterativeDeepening(s, i, j);
                    if(coordinates != null)
                        l.put(s, new ArrayList<>(Arrays.asList(coordinates)));
                }
        return l;
    }
}
