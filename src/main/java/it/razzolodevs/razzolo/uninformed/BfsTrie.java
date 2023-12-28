package main.java.it.razzolodevs.razzolo.uninformed;

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

        final Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j, String.valueOf(matrix[i][j]), 0));

        while(!queue.isEmpty()){
            final Point point = queue.poll();
            int currentIndex = point.getIndex();
            String s = point.getString();
            if(trie.search(s))
                l.add(s);

            int x = point.getI();
            int y = point.getJ();

            final Set<Character> characterSet = trie.searchBySubstring(s);
            // check adjacent cells
            for(int k = 0; k < Direction.DIRECTIONS.length; k++){
                int deltaX = x + Direction.DIRECTIONS[k].x();
                int deltaY = y + Direction.DIRECTIONS[k].y();
                if((deltaX >= 0 && deltaX < 4) && (deltaY >= 0 && deltaY < 4)){
                    char c = matrix[deltaX][deltaY];
                    if(s.indexOf(c) < 0 && characterSet.contains(c))
                        queue.add(new Point(deltaX, deltaY, s + c, currentIndex + 1));
                }
            }
        }
        return l;
    }
}
