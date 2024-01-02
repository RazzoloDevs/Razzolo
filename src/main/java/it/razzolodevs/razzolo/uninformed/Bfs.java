package main.java.it.razzolodevs.razzolo.uninformed;

import main.java.it.razzolodevs.razzolo.Util;
import main.java.it.razzolodevs.razzolo.model.Direction;
import main.java.it.razzolodevs.razzolo.model.Point;

import java.util.*;

public class Bfs {

    private final char[][] matrix;
    private final HashSet<String> dictionary;

    public Bfs(final char[][] matrix, final HashSet<String> dictionary) {
        this.matrix = matrix;
        this.dictionary = dictionary;
    }

    public List<String> bfs(int i, int j){
        final var l = new ArrayList<String>();

        final Queue<ArrayList<Point>> queue = new LinkedList<>();
        final var tmp = new ArrayList<Point>();
        tmp.add(new Point(i, j, matrix[i][j]));
        queue.add(tmp);

        while(!queue.isEmpty()){
            final ArrayList<Point> pointList = queue.poll();
            final Point point = pointList.getLast();
            final String s = Util.getString(pointList);
            if(dictionary.contains(s))
                l.add(s);

            int x = point.getI();
            int y = point.getJ();

            // check adjacent cells
            for(int k = 0; k < Direction.DIRECTIONS.length; k++){
                int deltaX = x + Direction.DIRECTIONS[k].x();
                int deltaY = y + Direction.DIRECTIONS[k].y();
                if(Util.checkCells(deltaX, deltaY, pointList)) {
                    final var tmpList = new ArrayList<>(pointList);
                    tmpList.add(new Point(deltaX, deltaY, matrix[deltaX][deltaY]));
                    queue.add(tmpList);
                }
            }
        }
        return l;
    }
}
