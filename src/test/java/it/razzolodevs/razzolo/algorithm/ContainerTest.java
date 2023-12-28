package test.java.it.razzolodevs.razzolo.algorithm;

import main.java.it.razzolodevs.razzolo.model.Point;
import main.java.it.razzolodevs.razzolo.uninformed.Container;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainerTest
{
    @Test
    public void stackContainerTest()
    {
        final var container = new Container(new Stack<>());

        container.add(new Point(0, 0, "", 0));
        container.add(new Point(1, 0, "", 0));
        container.add(new Point(2, 0, "", 0));
        assertTrue(!container.isEmpty());

        var e = (Point)container.remove();
        assertTrue(e.getI() == 2);
    }

    @Test
    public void queueContainerTest()
    {
        final var container = new Container(new LinkedList<>());

        container.add(new Point(0, 0, "", 0));
        container.add(new Point(1, 0, "", 0));
        container.add(new Point(2, 0, "", 0));
        assertTrue(!container.isEmpty());

        var e = (Point)container.remove();
        assertTrue(e.getI() == 0);
    }
}
