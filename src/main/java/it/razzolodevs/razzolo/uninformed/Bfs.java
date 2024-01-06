package main.java.it.razzolodevs.razzolo.uninformed;

import main.java.it.razzolodevs.razzolo.Util;
import main.java.it.razzolodevs.razzolo.model.Direction;
import main.java.it.razzolodevs.razzolo.model.Point;

import java.util.*;

public class Bfs {

    private static char[][] matrix;
    private static HashSet<String> dictionary;

    private static HashMap<String, ArrayList<Point>> bfs(int i, int j){
        final var l = new HashMap<String, ArrayList<Point>>();

        final Queue<ArrayList<Point>> queue = new LinkedList<>();
        final var tmp = new ArrayList<Point>();
        tmp.add(new Point(i, j, matrix[i][j]));
        queue.add(tmp);

        while(!queue.isEmpty()){
            final ArrayList<Point> pointList = queue.poll();
            final Point point = pointList.get(pointList.size()-1);
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
                    queue.add(tmpList);
                }
            }
        }
        return l;
    }

    public static HashMap<String, ArrayList<Point>> run(char[][] m, HashSet<String> d){
        matrix = m;
        dictionary = d;
        final var l = new HashMap<String, ArrayList<Point>>();
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++)
                l.putAll(bfs(i, j));
        return l;
    }
}
