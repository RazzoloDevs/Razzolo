package it.unisa.bruteforce;

import it.unisa.model.Point;

import java.util.Stack;

import static it.unisa.Util.checkCells;

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

                while(!stack.isEmpty()){
                    final Point point = stack.pop();
                    int currentIndex = point.index();
                    if(currentIndex == word.length()-1)
                        return true;

                    int x = point.i();
                    int y = point.j();
                    // check adjacent cells
                    for(int k=0; k<Point.directions.length; k++){
                        int deltaX = x + Point.directions[k].x();
                        int deltaY = y + Point.directions[k].y();
                        if(checkCells(isVisited, deltaX, deltaY) && matrix[deltaX][deltaY] == word.charAt(currentIndex+1)){
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
