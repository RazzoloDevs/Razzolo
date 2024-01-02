package main.java.it.razzolodevs.razzolo.uninformed;

import main.java.it.razzolodevs.razzolo.Util;
import main.java.it.razzolodevs.razzolo.model.Direction;
import main.java.it.razzolodevs.razzolo.model.Point;

import java.util.*;

public class Dfs {
    private final char[][] matrix;
    private final HashSet<String> dictionary;

    public Dfs(final char[][] matrix, final HashSet<String> dictionary) {
        this.matrix = matrix;
        this.dictionary = dictionary;
    }

    public HashMap<String, ArrayList<Point>> dfs(int i, int j){
        final var l = new HashMap<String, ArrayList<Point>>();

        final var stack = new Stack<ArrayList<Point>>();
        final var tmp = new ArrayList<Point>();
        tmp.add(new Point(i, j, matrix[i][j]));
        stack.add(tmp);

        while(!stack.isEmpty()){
            final ArrayList<Point> pointList = stack.pop();
            final Point point = pointList.getLast();
            final String s = Util.getString(pointList);
            if(dictionary.contains(s))
                l.put(s, pointList);

            int x = point.getI();
            int y = point.getJ();

            // check adjacent cells
            for(int k = 0; k < Direction.DIRECTIONS.length; k++){
                int deltaX = x + Direction.DIRECTIONS[k].x();
                int deltaY = y + Direction.DIRECTIONS[k].y();
                if(Util.checkCells(deltaX, deltaY, pointList)) {
                    final var tmpList = new ArrayList<>(pointList);
                    tmpList.add(new Point(deltaX, deltaY, matrix[deltaX][deltaY]));
                    stack.add(tmpList);
                }
            }
        }
        return l;
    }
}