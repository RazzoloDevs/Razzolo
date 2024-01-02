package main.java.it.razzolodevs.razzolo.model;

public class Point {

    private final int i;
    private final int j;
    private char value;
    private int index;

    public Point(int i, int j, char value, int index){
        this.i = i;
        this.j = j;
        this.value = value;
        this.index = index;
    }

    public Point(int i, int j, char c){
        this.i = i;
        this.j = j;
        this.value = c;
    }

    public Point(int i, int j){
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public char getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }
}