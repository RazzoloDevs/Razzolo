package it.unisa.razzolo_debug;

import it.unisa.razzolo_debug.model.Point;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Algorithms {
    public static boolean bfs(char[][] matrix, int i, int j, String word){
        final boolean[][] isVisited = new boolean[4][4];

        final Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i,j, matrix[i][j], 0));
        isVisited[i][j] = true;

        while(!queue.isEmpty()){
            final Point point = queue.poll();
            int currentIndex = point.index();
            if(currentIndex == word.length()-1)
                return true;

            int x = point.i();
            int y = point.j();
            // check adjacent cells
            for(int k=0; k<8; k++){
                int deltaX = x + dX[k];
                int deltaY = y + dY[k];
                if(checkCells(isVisited, deltaX, deltaY) && matrix[deltaX][deltaY] == word.charAt(currentIndex+1)){
                    queue.add(new Point(deltaX, deltaY, matrix[deltaX][deltaY], currentIndex+1));
                    isVisited[deltaX][deltaY] = true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] matrix, int i, int j, String word){
        final boolean[][] isVisited = new boolean[4][4];

        final Stack<Point> stack = new Stack<>();
        stack.push(new Point(i,j, matrix[i][j], 0));
        isVisited[i][j] = true;

        while(!stack.isEmpty()){
            final Point point = stack.pop();
            int currentIndex = point.index();
            if(currentIndex == word.length()-1)
                return true;

            int x = point.i();
            int y = point.j();
            // check adjacent cells
            for(int k=0; k<8; k++){
                int deltaX = x + dX[k];
                int deltaY = y + dY[k];
                if(checkCells(isVisited, deltaX, deltaY) && matrix[deltaX][deltaY] == word.charAt(currentIndex+1)){
                    stack.push(new Point(deltaX, deltaY, matrix[deltaX][deltaY], currentIndex+1));
                    isVisited[deltaX][deltaY] = true;
                }
            }
        }
        return false;
    }

    private static boolean checkCells(boolean[][] isVisited, int i, int j){
        if((i>=0 && i<4) && (j>=0 && j<4))
            return !isVisited[i][j];
        return false;
    }

    // all possible directions
    private static final int[] dX = { 0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] dY = { -1, -1, 0, 1, 1, 1, 0, -1};
                                   //up up-dx dx dw-dx dw dw-sx sx up-sx
}
