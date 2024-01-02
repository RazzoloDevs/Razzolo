package main.java.it.razzolodevs.razzolo.uninformed;

import main.java.it.razzolodevs.razzolo.Util;
import main.java.it.razzolodevs.razzolo.model.Direction;
import main.java.it.razzolodevs.razzolo.model.Point;
import main.java.it.razzolodevs.razzolo.model.Trie;

import java.util.*;

public class DfsTrie {
    private final char[][] matrix;
    private final Trie trie;

    public DfsTrie(final char[][] matrix, final Trie trie) {
        this.matrix = matrix;
        this.trie = trie;
    }

    public List<String> dfs(int i, int j){
        final var l = new ArrayList<String>();

        final var stack = new Stack<ArrayList<Point>>();
        final var tmp = new ArrayList<Point>();
        tmp.add(new Point(i, j, matrix[i][j]));
        stack.add(tmp);

        while(!stack.isEmpty()){
            final ArrayList<Point> pointList = stack.pop();
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
                    stack.add(tmpList);
                }
            }
        }
        return l;
    }
}
