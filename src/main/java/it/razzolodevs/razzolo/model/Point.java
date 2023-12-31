package main.java.it.razzolodevs.razzolo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Point
{
    private final int i;
    private final int j;
    private final char value;
    private final int index;

    public Point(int i, int j, char c)
    {
        this.i = i;
        this.j = j;
        this.value = c;
        this.index = 0;
    }

    public Point(int i, int j)
    {
        this.i = i;
        this.j = j;
        this.value = 0;
        this.index = 0;
    }
}