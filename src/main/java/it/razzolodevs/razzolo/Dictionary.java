package main.java.it.razzolodevs.razzolo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Dictionary
{
    private Dictionary()
    {
        final var url = getClass().getClassLoader().getResource("dictionary.txt");
        assert url != null;

        try
        {
            file = new FileInputStream(url.getFile());
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static FileInputStream getInstance()
    {
        if (file == null)
            new Dictionary();
        return file;
    }

    private static FileInputStream file = null;
}
