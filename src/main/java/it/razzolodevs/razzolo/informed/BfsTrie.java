package main.java.it.razzolodevs.razzolo.informed;

import main.java.it.razzolodevs.razzolo.Util;
import main.java.it.razzolodevs.razzolo.model.Direction;
import main.java.it.razzolodevs.razzolo.model.Point;
import main.java.it.razzolodevs.razzolo.model.Trie;

import java.util.*;

public class BfsTrie {
    private static char[][] matrix;
    private static Trie trie;

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
            if(trie.search(s))
                l.put(s, pointList);

            int x = point.getI();
            int y = point.getJ();

            final Set<Character> characterSet = trie.searchBySubstring(s);
            // check adjacent cells
            for(final var direction : Direction.DIRECTIONS){
                int deltaX = x + direction.x();
                int deltaY = y + direction.y();
                if(Util.checkCells(deltaX, deltaY, pointList) && characterSet.contains(matrix[deltaX][deltaY])) {
                    final var tmpList = new ArrayList<>(pointList);
                    tmpList.add(new Point(deltaX, deltaY, matrix[deltaX][deltaY]));
                    queue.add(tmpList);
                }
            }
        }
        return l;
    }

    public static HashMap<String, ArrayList<Point>> run(char[][] m, Trie t){
        matrix = m;
        trie = t;
        final var l = new HashMap<String, ArrayList<Point>>();
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++)
                l.putAll(bfs(i, j));
        return l;
    }
}
