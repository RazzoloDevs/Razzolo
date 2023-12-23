package main.java.it.razzolodevs.razzolo.uninformed;

import main.java.it.razzolodevs.razzolo.model.Direction;
import main.java.it.razzolodevs.razzolo.model.Point;
import main.java.it.razzolodevs.razzolo.Util;

import java.util.Stack;

public class Dfs {
    public static boolean dfs(char[][] matrix, String word){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(word.charAt(0) != matrix[i][j])
                    continue;

                final boolean[][] isVisited = new boolean[4][4];

                final Stack<Point> stack = new Stack<>();
                stack.push(new Point(i,j, matrix[i][j], 0));
                isVisited[i][j] = true;

                // non funziona
                while(!stack.isEmpty()){
                    final Point point = stack.pop();
                    int currentIndex = point.index();

                    int x = point.i();
                    int y = point.j();
                    System.out.println(matrix[x][y]);

                    // check adjacent cells
                    for(int k = 0; k < Direction.DIRECTIONS.length; k++){
                        int deltaX = x + Direction.DIRECTIONS[k].x();
                        int deltaY = y + Direction.DIRECTIONS[k].y();
                        if(Util.checkCells(isVisited, deltaX, deltaY)){
                            stack.push(new Point(deltaX, deltaY, matrix[deltaX][deltaY], currentIndex+1));
                            isVisited[deltaX][deltaY] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
}