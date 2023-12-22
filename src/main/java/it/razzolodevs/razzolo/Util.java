package main.java.it.razzolodevs.razzolo;

public class Util {
    public static boolean checkCells(boolean[][] isVisited, int i, int j){
        if((i>=0 && i<4) && (j>=0 && j<4))
            return !isVisited[i][j];
        return false;
    }
}