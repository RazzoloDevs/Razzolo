package main.java.it.razzolodevs.razzolo.uninformed;

import java.util.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Container<T>
{
    private final ContainerType type;
    private final T instance;

    private enum ContainerType
    {
        STACK,
        QUEUE,
    }

    public Container(T instance)
    {
        if (instance instanceof Stack)
            this.type = ContainerType.STACK;
        else if (instance instanceof Queue)
            this.type = ContainerType.QUEUE;
        else
            throw new IllegalArgumentException();

        this.instance = instance;
    }

    public boolean isEmpty()
    {
        return switch (this.type)
        {
            case ContainerType.STACK -> ((Stack)this.instance).isEmpty();
            case ContainerType.QUEUE -> ((Queue)this.instance).isEmpty();
        };
    }

    public void add(Object item)
    {
        switch (this.type)
        {
            case ContainerType.STACK -> ((Stack)this.instance).push(item);
            case ContainerType.QUEUE -> ((Queue)this.instance).add(item);
        }
    }

    public Object remove()
    {
        return switch (this.type)
        {
            case ContainerType.STACK -> ((Stack)this.instance).pop();
            case ContainerType.QUEUE -> ((Queue)this.instance).remove();
        };
    }
}
