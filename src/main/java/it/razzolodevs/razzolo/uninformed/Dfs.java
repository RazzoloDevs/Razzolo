package main.java.it.razzolodevs.razzolo.uninformed;

import main.java.it.razzolodevs.razzolo.model.Direction;
import main.java.it.razzolodevs.razzolo.model.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Dfs {
    private final char[][] matrix;
    private final HashSet<String> dictionary;

    public Dfs(final char[][] matrix, final HashSet<String> dictionary) {
        this.matrix = matrix;
        this.dictionary = dictionary;
    }

    public List<String> dfs(int i, int j){
        final var l = new ArrayList<String>();

        final Stack<Point> stack = new Stack<>();
        stack.push(new Point(i, j, String.valueOf(matrix[i][j]), 0));

        while(!stack.isEmpty()){
            final Point point = stack.pop();
            int currentIndex = point.getIndex();
            String s = point.getString();
            if(dictionary.contains(s))
                l.add(s);

            int x = point.getI();
            int y = point.getJ();

            // check adjacent cells
            for(int k = 0; k < Direction.DIRECTIONS.length; k++){
                int deltaX = x + Direction.DIRECTIONS[k].x();
                int deltaY = y + Direction.DIRECTIONS[k].y();
                if((deltaX >= 0 && deltaX < matrix.length) && (deltaY >= 0 && deltaY < matrix[0].length)){
                    char c = matrix[deltaX][deltaY];
                    if(s.indexOf(c) < 0)
                        stack.push(new Point(deltaX, deltaY, s + c, currentIndex + 1));
                }
            }
        }
        return l;
    }
}