package main.java.it.razzolodevs.razzolo.model;

public class Point {

    private final int i;
    private final int j;
    private final char value;
    private final int index;
    private final String string;

    public Point(int i, int j, char value, int index){
        this.i = i;
        this.j = j;
        this.value = value;
        this.index = index;
        this.string = "";
    }

    public Point(int i, int j, String string, int index){
        this.i = i;
        this.j = j;
        this.string = string;
        this.index = index;
        this.value = ' ';
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

    public String getString() {
        return string;
    }
}