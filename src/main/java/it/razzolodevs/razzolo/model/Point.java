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

    public static String getString(Point[] points){
        StringBuilder s = new StringBuilder();
        for(Point p : points)
            s.append(p.value);
        return s.toString();
    }

    public static Point[] stringToPoint(final String s){
        final Point[] p = new Point[s.length()];
        for(int i=0;i<s.length();i++)
            p[i] = new Point(-1, -1, s.charAt(i), i);
        return p;
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