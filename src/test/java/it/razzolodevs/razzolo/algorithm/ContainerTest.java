package test.java.it.razzolodevs.razzolo.algorithm;

import main.java.it.razzolodevs.razzolo.model.Point;
import main.java.it.razzolodevs.razzolo.uninformed.Container;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ContainerTest
{
    @Test
    public void stackContainerTest()
    {
        final var container = new Container<Stack, Point>(new Stack());

        _fillContainer(container);
        assertFalse(container.isEmpty());

        final var e = container.remove();
        assertEquals(2, e.getI());
    }

    @Test
    public void queueContainerTest()
    {
        final var container = new Container<LinkedList, Point>(new LinkedList<>());

        _fillContainer(container);
        assertFalse(container.isEmpty());

        final var e = container.remove();
        assertEquals(0, e.getI());
    }

    private void _fillContainer(Container container)
    {
        container.add(new Point(0, 0, "", 0));
        container.add(new Point(1, 0, "", 0));
        container.add(new Point(2, 0, "", 0));
    }
}
