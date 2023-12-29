package main.java.it.razzolodevs.razzolo;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Dictionary
{
    private Dictionary()
    {
        final var url = getClass().getClassLoader().getResource("dictionary.txt");
        assert url != null;

        try
        {
            file = new RandomAccessFile(url.getFile(), "r");
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static RandomAccessFile getInstance()
    {
        if (file == null)
            new Dictionary();
        return file;
    }

    private static RandomAccessFile file = null;
}
