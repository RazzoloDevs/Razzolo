package main.java.it.razzolodevs.razzolo.uninformed;

import main.java.it.razzolodevs.razzolo.Util;
import main.java.it.razzolodevs.razzolo.model.Direction;
import main.java.it.razzolodevs.razzolo.model.Point;
import main.java.it.razzolodevs.razzolo.model.Trie;

import java.util.*;

public class BfsTrie {
    private final char[][] matrix;
    private final Trie trie;

    public BfsTrie(final char[][] matrix, final Trie trie) {
        this.matrix = matrix;
        this.trie = trie;
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
            if(trie.search(s))
                l.add(s);

            int x = point.getI();
            int y = point.getJ();

            final Set<Character> characterSet = trie.searchBySubstring(s);
            // check adjacent cells
            for(int k = 0; k < Direction.DIRECTIONS.length; k++){
                int deltaX = x + Direction.DIRECTIONS[k].x();
                int deltaY = y + Direction.DIRECTIONS[k].y();
                if(Util.checkCells(deltaX, deltaY, pointList) && characterSet.contains(matrix[deltaX][deltaY])) {
                    final var tmpList = new ArrayList<>(pointList);
                    tmpList.add(new Point(deltaX, deltaY, matrix[deltaX][deltaY]));
                    queue.add(tmpList);
                }
            }
        }
        return l;
    }
}
